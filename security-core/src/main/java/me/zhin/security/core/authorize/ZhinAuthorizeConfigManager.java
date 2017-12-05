package me.zhin.security.core.authorize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhin
 * @date 2017/11/21
 */
@Component
public class ZhinAuthorizeConfigManager implements AuthorizeConfigManager {


  @Autowired
  private List<AuthorizeConfigProvider> authorizeConfigProviders;

  @Override
  public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>
                         .ExpressionInterceptUrlRegistry config) {
    boolean existAnyRequestConfig = false;
    String existAnyRequestConfigName = null;

    for (AuthorizeConfigProvider authorizeConfigProvider : authorizeConfigProviders) {
      boolean currentIsAnyRequestConfig = authorizeConfigProvider.config(config);
      if (existAnyRequestConfig && currentIsAnyRequestConfig) {
        throw new RuntimeException("重复的anyRequest配置:" + existAnyRequestConfigName + ","
            + authorizeConfigProvider.getClass().getSimpleName());
      } else if (currentIsAnyRequestConfig) {
        existAnyRequestConfig = true;
        existAnyRequestConfigName = authorizeConfigProvider.getClass().getSimpleName();
      }
    }

    if (!existAnyRequestConfig) {
      config.anyRequest().authenticated();
    }


  }
}
