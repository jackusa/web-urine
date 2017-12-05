package me.zhin.security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.zhin.security.core.properties.LoginResponseType;
import me.zhin.security.core.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhin
 * @date 2017/11/14
 * 自定义登录成功处理器的行为
 */
@Component("c")
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
  private final static Logger logger = LoggerFactory.getLogger(MyAuthenticationSuccessHandler.class);

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private SecurityProperties securityProperties;

  private RequestCache requestCache = new HttpSessionRequestCache();


  /**
   *
   * @param httpServletRequest
   * @param httpServletResponse
   * @param authentication 封装认证信息，包括用户信息
   * @throws IOException
   * @throws ServletException
   */
  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
      Authentication authentication) throws IOException, ServletException {

    logger.info("登录成功");
    // 如果不配置默认为转发链接方式，需要配置转发链接，如果不配做默认为首页
    if (LoginResponseType.JSON.equals(securityProperties.getBrowser().getSignInResponseType())) {
      httpServletResponse.setContentType("application/json;charset=UTF-8");
      String type = authentication.getClass().getSimpleName();
      httpServletResponse.getWriter().write(objectMapper.writeValueAsString(type));
    } else {
      // 如果设置了zhin.security.browser.singInSuccessUrl，总是跳到设置的地址上
      // 如果没设置，则尝试跳转到登录之前访问的地址上，如果登录前访问地址为空，则跳到网站根路径上
      if (StringUtils.isNotBlank(securityProperties.getBrowser().getSingInSuccessUrl())) {
        requestCache.removeRequest(httpServletRequest, httpServletResponse);
        setAlwaysUseDefaultTargetUrl(true);
        setDefaultTargetUrl(securityProperties.getBrowser().getSingInSuccessUrl());
      }
      super.onAuthenticationSuccess(httpServletRequest, httpServletResponse, authentication);
    }

  }
}
