package me.zhin.security.core.validata.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @author zhin
 * @date 2017/11/14
 */
public class ValidateCodeException extends AuthenticationException {

  private static final long serialVersionUID = -7285211528095468156L;
  public ValidateCodeException(String msg) {
    super(msg);
  }

}
