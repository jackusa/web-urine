package me.zhin.security.core.validata.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author zhin
 * @date 2017/11/17
 */
public interface ValidateCodeRepository {

  /**
   * 保存验证码
   * @param request
   * @param code
   * @param validateCodeType
   */
  void save(ServletWebRequest request, ValidateCode code,
            ValidateCodeType validateCodeType);


  ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType);

  void remove(ServletWebRequest request, ValidateCodeType validateCodeType);
}
