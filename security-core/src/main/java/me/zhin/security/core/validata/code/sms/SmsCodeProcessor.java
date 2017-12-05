package me.zhin.security.core.validata.code.sms;

import me.zhin.security.core.properties.SecurityConstants;
import me.zhin.security.core.validata.code.ValidateCode;
import me.zhin.security.core.validata.code.impl.AbstractValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;


/**
 * @author zhin
 * @date 2017/11/15
 */
@Component("smsValidateCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {
  /**
   * 短信验证码发送器
   */
  @Autowired
  private SmsCodeSender smsCodeSender;

  @Override
  protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
    String paramName = SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE;
    String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
    smsCodeSender.send(mobile, validateCode.getCode());
  }
}
