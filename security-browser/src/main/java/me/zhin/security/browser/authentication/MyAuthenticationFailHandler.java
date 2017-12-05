package me.zhin.security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.zhin.security.core.properties.LoginResponseType;
import me.zhin.security.core.properties.SecurityProperties;
import me.zhin.security.core.support.SimpleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhin
 * @date 2017/11/14
 */
@Component("myAuthenticationFailHandler")
public class MyAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {

  private final static Logger logger = LoggerFactory.getLogger(MyAuthenticationSuccessHandler.class);

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private SecurityProperties securityProperties;

  @Override
  public void onAuthenticationFailure(
      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
      AuthenticationException e) throws IOException, ServletException {

    logger.info("登录失败");

    if (LoginResponseType.JSON.equals(securityProperties.getBrowser().getSignInResponseType())) {
      // 返回500错误
      httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
      httpServletResponse.setContentType("application/json;charset=UTF-8");
      httpServletResponse.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse(e.getMessage())));
    } else {
      super.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
    }


  }
}
