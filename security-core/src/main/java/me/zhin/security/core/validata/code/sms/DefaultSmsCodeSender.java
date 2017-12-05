package me.zhin.security.core.validata.code.sms;

/**
 * @author zhin
 * @date 2017/11/15
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
  /**
   * 这里使用短信服务商发送短信至手机号
   * @param mobile 手机
   * @param code 验证码
   */
  @Override
  public void send(String mobile, String code) {
    System.out.println("向手机: " + mobile + "发送验证码: " + code);
  }
}
