package me.zhin.web.weburine.config;

import me.zhin.security.core.authorize.AuthorizeConfigProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zhin
 * @date 2017/11/21
 */

@Configuration
@Order(Integer.MIN_VALUE+1)
public class WebSecurityConfiguration implements AuthorizeConfigProvider {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>
                              .ExpressionInterceptUrlRegistry config) {

    config.antMatchers( "/","/index", "/detail", "/about", "/signUp", "/users",
        "/urines", "/patients", "/discover")
        .permitAll()
        .antMatchers(HttpMethod.GET, "/data").hasAnyRole("USER", "ADMIN")
        .anyRequest()
        .authenticated();

    return false;
  }

}
