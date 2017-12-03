package me.zhin.security.core.authentication;

import me.zhin.security.core.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @author zhin
 * @date 2017/11/21
 */
@Component
public class FormAuthenticationConfig {

  @Autowired
  protected AuthenticationSuccessHandler myAuthenticationSuccessHandler;

  @Autowired
  protected AuthenticationFailureHandler myAuthenticationFailureHandler;

  public void configure(HttpSecurity http) throws Exception {
    http.formLogin()
        .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
        .loginProcessingUrl(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM)
        .successHandler(myAuthenticationSuccessHandler)
        .failureHandler(myAuthenticationFailureHandler);

  }

}
