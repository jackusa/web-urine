package me.zhin.security.core.social.qq.connet;

import me.zhin.security.core.social.qq.api.QQ;
import me.zhin.security.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @author zhin
 * @date 2017/11/15
 */
public class QQAdapter implements ApiAdapter<QQ> {
  @Override
  public boolean test(QQ qq) {
    return true;
  }

  @Override
  public void setConnectionValues(QQ qq, ConnectionValues connectionValues) {
    QQUserInfo userInfo = qq.getUserInfo();

    connectionValues.setDisplayName(userInfo.getNickname());
    connectionValues.setImageUrl(userInfo.getFigureurl_qq_1());
    connectionValues.setProfileUrl(null);
    connectionValues.setProviderUserId(userInfo.getOpenId());

  }

  @Override
  public UserProfile fetchUserProfile(QQ qq) {
    return null;
  }

  @Override
  public void updateStatus(QQ qq, String s) {
    // 没有主页，QQ空间未考虑
  }
}
