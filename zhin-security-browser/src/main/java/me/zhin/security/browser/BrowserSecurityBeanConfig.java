package me.zhin.security.browser;

import me.zhin.security.browser.logout.ZhinLogoutSuccessHandler;
import me.zhin.security.browser.session.ZhinExpiredSessionStrategy;
import me.zhin.security.browser.session.ZhinInvalidSessionStrategy;
import me.zhin.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * @author zhin
 * @date 2017/11/16
 */
@Configuration
public class BrowserSecurityBeanConfig {

  @Autowired
  private SecurityProperties securityProperties;

  /**
   * session失效时的处理策略配置
   * @return
   */
  @Bean
  @ConditionalOnMissingBean(InvalidSessionStrategy.class)
  public InvalidSessionStrategy invalidSessionStrategy(){
    return new ZhinInvalidSessionStrategy(securityProperties);
  }

  @Bean
  @ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
  public SessionInformationExpiredStrategy sessionInformationExpiredStrategy(){
    return new ZhinExpiredSessionStrategy(securityProperties);
  }

  @Bean
  @ConditionalOnMissingBean(ZhinLogoutSuccessHandler.class)
  public LogoutSuccessHandler logoutSuccessHandler() {
    return new ZhinLogoutSuccessHandler(securityProperties.getBrowser().getSignOutUrl());
  }

}
