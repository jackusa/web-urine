package me.zhin.security.core.social.weixin.api;

/**
 * @author zhin
 * @date 2017/11/16
 */
public interface Weixin {

  WeixinUserInfo getUserInfo(String openId);

}
