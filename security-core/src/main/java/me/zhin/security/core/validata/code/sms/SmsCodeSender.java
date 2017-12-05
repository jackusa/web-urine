package me.zhin.security.core.validata.code.sms;

/**
 * @author zhin
 * @date 2017/11/15
 */
public interface SmsCodeSender {

  /**
   * 自定义发送短信验证码
   * @param mobile 手机
   * @param code 验证码
   */
  void send(String mobile, String code);

}
