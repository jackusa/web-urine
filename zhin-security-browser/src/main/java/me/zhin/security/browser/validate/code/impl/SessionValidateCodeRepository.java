package me.zhin.security.browser.validate.code.impl;

import me.zhin.security.core.validata.code.ValidateCode;
import me.zhin.security.core.validata.code.ValidateCodeRepository;
import me.zhin.security.core.validata.code.ValidateCodeType;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author zhin
 * @date 2017/11/17
 */
@Component
public class SessionValidateCodeRepository implements ValidateCodeRepository {

  String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

  private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

  @Override
  public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType) {
    sessionStrategy.setAttribute(request, getSessionKey(request, validateCodeType), code);
  }

  private String getSessionKey(ServletWebRequest request, ValidateCodeType validateCodeType) {
    return SESSION_KEY_PREFIX + validateCodeType.toString().toUpperCase();
  }

  @Override
  public ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType) {
    return (ValidateCode) sessionStrategy.getAttribute(request, getSessionKey(request, validateCodeType));
  }

  @Override
  public void remove(ServletWebRequest request, ValidateCodeType validateCodeType) {
    sessionStrategy.removeAttribute(request, getSessionKey(request, validateCodeType));
  }
}
