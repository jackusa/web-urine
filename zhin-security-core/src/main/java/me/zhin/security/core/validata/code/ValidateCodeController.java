package me.zhin.security.core.validata.code;

import me.zhin.security.core.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhin
 * @date 2017/11/14
 */
@RestController
public class ValidateCodeController {

  @Autowired
  private ValidateCodeProcessorHolder validateCodeProcessorHolder;


  @GetMapping(SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/{type}")
  public void createCode(HttpServletRequest request,
                         HttpServletResponse response,
                         @PathVariable String type) throws Exception {

    validateCodeProcessorHolder.findValidateCodeProcessor(type)
        .create(new ServletWebRequest(request, response));
  }



}
