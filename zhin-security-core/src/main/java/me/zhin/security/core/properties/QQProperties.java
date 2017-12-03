package me.zhin.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author zhin
 * @date 2017/11/15
 */
public class QQProperties extends SocialProperties {

  private String providerId = "qq";

  public String getProviderId() {
    return providerId;
  }

  public void setProviderId(String providerId) {
    this.providerId = providerId;
  }
}
