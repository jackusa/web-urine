package me.zhin.security.core.social.weixin.content;

import org.springframework.social.oauth2.AccessGrant;

/**
 * @author zhin
 * @date 2017/11/16
 */
public class WeixinAccessGrant extends AccessGrant {
  private String openId;

  public WeixinAccessGrant() {
    super("");
  }

  public WeixinAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn) {
    super(accessToken, scope, refreshToken, expiresIn);
  }

  /**
   * @return the openId
   */
  public String getOpenId() {
    return openId;
  }

  /**
   * @param openId the openId to set
   */
  public void setOpenId(String openId) {
    this.openId = openId;
  }


}
