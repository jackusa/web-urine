package me.zhin.security.browser;


import me.zhin.security.core.authentication.FormAuthenticationConfig;
import me.zhin.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import me.zhin.security.core.authorize.AuthorizeConfigManager;
import me.zhin.security.core.properties.SecurityProperties;
import me.zhin.security.core.validata.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * @author zhin
 * @date 2017/11/14
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private SecurityProperties securityProperties;

  @Autowired
  private DataSource dataSource;

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

  @Autowired
  private ValidateCodeSecurityConfig validateCodeSecurityConfig;

  @Autowired
  private SpringSocialConfigurer springSocialConfigurer;

  @Autowired
  private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;

  @Autowired
  private InvalidSessionStrategy invalidSessionStrategy;

  @Autowired
  private LogoutSuccessHandler logoutSuccessHandler;

  @Autowired
  private AuthorizeConfigManager authorizeConfigManager;

  @Autowired
  private FormAuthenticationConfig formAuthenticationConfig;

  /**
   * 配置记住我
   * @return
   */
  @Bean
  public PersistentTokenRepository persistentTokenRepository() {
    JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
    tokenRepository.setDataSource(dataSource);
    tokenRepository.setCreateTableOnStartup(false);
    return tokenRepository;
  }


  @Override
  protected void configure(HttpSecurity http) throws Exception {

    formAuthenticationConfig.configure(http);

    http.apply(validateCodeSecurityConfig)
        .and()
          .apply(smsCodeAuthenticationSecurityConfig)
        .and()
          .apply(springSocialConfigurer)
        .and()
          .rememberMe()
            .tokenRepository(persistentTokenRepository())
            .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
            .userDetailsService(userDetailsService)
        .and()
          .sessionManagement()
            .invalidSessionStrategy(invalidSessionStrategy)
            .invalidSessionUrl(securityProperties.getBrowser().getSession().getSessionInvalidUrl())
            .maximumSessions(securityProperties.getBrowser().getSession().getMaximumSessions())
            // 达到最大登录session后，阻止后面的session登录
            .maxSessionsPreventsLogin(securityProperties.getBrowser().getSession().isMaxSessionsPreventsLogin())
            .expiredSessionStrategy(sessionInformationExpiredStrategy)
          .and()
        .and()
          .logout()
          .logoutUrl("/signOut")
          .logoutSuccessHandler(logoutSuccessHandler)
          .deleteCookies("JSESSIONID")
        .and()
          .csrf().disable();


    authorizeConfigManager.config(http.authorizeRequests());

  }
}
