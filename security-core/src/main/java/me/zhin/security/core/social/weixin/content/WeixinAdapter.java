package me.zhin.security.core.social.weixin.content;

import me.zhin.security.core.social.weixin.api.Weixin;
import me.zhin.security.core.social.weixin.api.WeixinUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @author zhin
 * @date 2017/11/16
 */

public class WeixinAdapter implements ApiAdapter<Weixin> {

  private String openId;

  public WeixinAdapter() {}

  public WeixinAdapter(String openId){
    this.openId = openId;
  }

  @Override
  public boolean test(Weixin api) {
    return true;
  }

  @Override
  public void setConnectionValues(Weixin api, ConnectionValues values) {
    WeixinUserInfo profile = api.getUserInfo(openId);
    values.setProviderUserId(profile.getOpenid());
    values.setDisplayName(profile.getNickname());
    values.setImageUrl(profile.getHeadimgurl());
  }

  @Override
  public UserProfile fetchUserProfile(Weixin api) {
    return null;
  }

  @Override
  public void updateStatus(Weixin api, String message) {

  }
}
