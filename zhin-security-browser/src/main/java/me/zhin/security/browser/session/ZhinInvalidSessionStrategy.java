package me.zhin.security.browser.session;

import me.zhin.security.core.properties.SecurityProperties;
import org.springframework.security.web.session.InvalidSessionStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * session失效处理策略
 * @author zhin
 * @date 2017/11/16
 */
public class ZhinInvalidSessionStrategy extends AbstractSessionStrategy
    implements InvalidSessionStrategy {

  public ZhinInvalidSessionStrategy(SecurityProperties securityProperties) {
    super(securityProperties);
  }

  @Override
  public void onInvalidSessionDetected(HttpServletRequest httpServletRequest,
                                       HttpServletResponse httpServletResponse)
      throws IOException, ServletException {
    onSessionInvalid(httpServletRequest, httpServletResponse);
  }


}
