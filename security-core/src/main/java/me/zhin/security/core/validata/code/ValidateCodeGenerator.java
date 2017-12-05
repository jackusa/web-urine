package me.zhin.security.core.validata.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author zhin
 * @date 2017/11/14
 */
public interface ValidateCodeGenerator {

  /**
   * 生成图片验证码
   * @param request 用户验证时发送的请求
   * @return 一张图片验证码
   */
  ValidateCode generate(ServletWebRequest request);

}
