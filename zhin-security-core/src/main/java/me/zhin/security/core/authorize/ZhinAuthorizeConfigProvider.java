package me.zhin.security.core.authorize;

import me.zhin.security.core.properties.SecurityConstants;
import me.zhin.security.core.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * 安全模块通用的URL授权
 * @author zhin
 * @date 2017/11/21
 */
@Component
@Order(Integer.MIN_VALUE)
public class ZhinAuthorizeConfigProvider implements AuthorizeConfigProvider {

  @Autowired
  private SecurityProperties securityProperties;

  @Override
  public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>
                           .ExpressionInterceptUrlRegistry config) {

    config.antMatchers(
        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
        SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE,
        SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_OPENID,
        securityProperties.getBrowser().getSignInPage(),
        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
        securityProperties.getBrowser().getSignUpUrl(),
        securityProperties.getBrowser().getSession().getSessionInvalidUrl(),
        securityProperties.getBrowser().getSignOutUrl()
    ).permitAll();

    if (StringUtils.isNotBlank(securityProperties.getBrowser().getSignOutUrl())) {
      config.antMatchers(securityProperties.getBrowser().getSignOutUrl()).permitAll();
    }
    return false;

  }
}
