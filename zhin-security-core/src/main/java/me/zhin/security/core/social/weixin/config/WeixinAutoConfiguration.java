package me.zhin.security.core.social.weixin.config;

import me.zhin.security.core.properties.SecurityProperties;
import me.zhin.security.core.properties.WeixinProperties;
import me.zhin.security.core.social.view.ZhinConnectView;
import me.zhin.security.core.social.weixin.content.WeixinConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.web.servlet.View;

/**
 * @author zhin
 * @date 2017/11/16
 */

@Configuration
@ConditionalOnProperty(prefix = "zhin.security.social.weixin", name = "app-id")
public class WeixinAutoConfiguration extends SocialAutoConfigurerAdapter {

  @Autowired
  private SecurityProperties securityProperties;


  @Override
  protected ConnectionFactory<?> createConnectionFactory() {
    WeixinProperties weixinConfig = securityProperties.getSocial().getWeixin();
    return new WeixinConnectionFactory(weixinConfig.getProviderId(),
        weixinConfig.getAppId(), weixinConfig.getAppSecret());
  }

  @Bean({"connect/weixinConnect", "connect/weixinConnected"})
  @ConditionalOnMissingBean(name = "weixinConnectedView")
  public View weixinConnectedView() {
    return new ZhinConnectView();
  }


}
