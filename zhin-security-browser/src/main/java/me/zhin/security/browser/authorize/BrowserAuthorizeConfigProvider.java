package me.zhin.security.browser.authorize;

import me.zhin.security.core.authorize.AuthorizeConfigProvider;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * @author zhin
 * @date 2017/11/21
 */
@Component
@Order(Integer.MIN_VALUE)
public class BrowserAuthorizeConfigProvider implements AuthorizeConfigProvider {
  @Override
  public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>
                           .ExpressionInterceptUrlRegistry config) {
    config.antMatchers(HttpMethod.GET,
        "/**/*.js",
        "/**/*.css",
        "/**/*.jpg",
        "/**/*.png",
        "/**/*.gif").permitAll();
    return false;
  }
}
