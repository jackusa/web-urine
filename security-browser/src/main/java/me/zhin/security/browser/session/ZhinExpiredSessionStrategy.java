package me.zhin.security.browser.session;

import me.zhin.security.core.properties.SecurityProperties;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * session过期处理策略
 * @author zhin
 * @date 2017/11/16
 */

public class ZhinExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {


  public ZhinExpiredSessionStrategy(SecurityProperties securityProperties) {
    super(securityProperties);
  }

  @Override
  public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent)
      throws IOException, ServletException {

    onSessionInvalid(sessionInformationExpiredEvent.getRequest(),
        sessionInformationExpiredEvent.getResponse());
  }

  /**
   * session失效是否是并发导致的
   * @return
   */
  @Override
  protected boolean isConcurrency() {
    return true;
  }


}
