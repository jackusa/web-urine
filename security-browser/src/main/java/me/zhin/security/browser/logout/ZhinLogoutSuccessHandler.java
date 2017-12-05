package me.zhin.security.browser.logout;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.zhin.security.core.properties.SecurityConstants;
import me.zhin.security.core.support.SimpleResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhin
 * @date 2017/11/16
 */
public class ZhinLogoutSuccessHandler implements LogoutSuccessHandler {

  private Logger logger = LoggerFactory.getLogger(ZhinLogoutSuccessHandler.class);

  public ZhinLogoutSuccessHandler(String signOutUrl) {
    this.signOutUrl = signOutUrl;
  }

  private String signOutUrl;

  private ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public void onLogoutSuccess(HttpServletRequest httpServletRequest,
                              HttpServletResponse httpServletResponse,
                              Authentication authentication) throws IOException, ServletException {
    logger.info("退出--成功");
    // 用户没有配置(等于默认配置)登出成功页面就就返回json数据
    if (StringUtils.equals(signOutUrl, SecurityConstants.DEFAULT_SIGN_OUT_PAGE_URL)) {
      httpServletResponse.setContentType("application/json;charset=UTF-8");
      httpServletResponse.getWriter()
          .write(objectMapper.writeValueAsString(new SimpleResponse("退出成功")));
    } else {
      httpServletResponse.sendRedirect(signOutUrl);
    }

  }
}
