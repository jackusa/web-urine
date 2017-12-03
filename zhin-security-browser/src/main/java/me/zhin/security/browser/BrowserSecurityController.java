package me.zhin.security.browser;

import me.zhin.security.core.properties.LoginResponseType;
import me.zhin.security.core.properties.SecurityConstants;
import me.zhin.security.core.social.SocialController;
import me.zhin.security.core.social.support.SocialUserInfo;
import me.zhin.security.core.properties.SecurityProperties;
import me.zhin.security.core.support.SimpleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhin
 * @date 2017/11/14
 */
@RestController
public class BrowserSecurityController extends SocialController {
  private final static Logger logger = LoggerFactory.getLogger(BrowserSecurityController.class);

  /**
   * 拿到引发跳转的请求
   */
  private RequestCache requestCache = new HttpSessionRequestCache();

  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

  @Autowired
  private SecurityProperties securityProperties;

  @Autowired
  private ProviderSignInUtils providerSignInUtils;

  /**
   * 当需要身份认证时，跳转到这里
   * 判断引发跳转的请求是否为html
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
  @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
  public SimpleResponse requireAuthentication(HttpServletRequest request,
                                              HttpServletResponse response) throws IOException {
    // 之前缓存的请求
    SavedRequest savedRequest = requestCache.getRequest(request, response);
    if (savedRequest != null) {
      String target = savedRequest.getRedirectUrl();
      logger.info("引发跳转的url: " + target);
      // 如果是用 登录响应类型为 REDIRECT 就认为浏览器
      if (LoginResponseType.REDIRECT.equals(securityProperties.getBrowser().getSignInResponseType())) {
        redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getSignInPage());
      }
    }
    return new SimpleResponse("访问的服务需要身份认证，请引导用户到登录页");
  }


//  @GetMapping("/session/invalid")
//  @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
//  public SimpleResponse sessionInvalid() {
//    return new SimpleResponse("session失效，请重新登录");
//  }

  /**
   * 用户第一次社交登录时，会引导用户进行用户注册或绑定，
   * 此服务用于在注册或绑定页面获取社交网站用户信息
   * @param request
   * @return
   */
  @GetMapping(SecurityConstants.DEFAULT_SOCIAL_USER_INFO_URL)
  public SocialUserInfo getSocialUserInfo(HttpServletRequest request) {
    Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
    return buildSocialUserInfo(connection);
  }

}
