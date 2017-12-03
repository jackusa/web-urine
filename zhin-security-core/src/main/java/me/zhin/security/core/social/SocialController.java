package me.zhin.security.core.social;

import me.zhin.security.core.social.support.SocialUserInfo;
import org.springframework.social.connect.Connection;

/**
 * @author zhin
 * @date 2017/11/21
 */
public abstract class SocialController {

  /**
   * 根据Connection信息构建SocialUserInfo
   * @param connection
   * @return
   */
  protected SocialUserInfo buildSocialUserInfo(Connection<?> connection) {
    SocialUserInfo userInfo = new SocialUserInfo();
    userInfo.setProviderId(connection.getKey().getProviderId());
    userInfo.setProviderUserId(connection.getKey().getProviderUserId());
    userInfo.setNickname(connection.getDisplayName());
    userInfo.setHeadimg(connection.getImageUrl());
    return userInfo;
  }

}
