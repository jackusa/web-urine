package me.zhin.security.core.validata.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author zhin
 * @date 2017/11/15
 * 校验码处理器，封装不同校验码的处理逻辑
 */
public interface ValidateCodeProcessor {

  /**
   * 创建校验码
   *
   * @param request
   * @throws Exception
   */
  void create(ServletWebRequest request) throws Exception;

  /**
   * 校验验证码
   *
   * @param servletWebRequest
   * @throws Exception
   */
  void validate(ServletWebRequest servletWebRequest);

}
