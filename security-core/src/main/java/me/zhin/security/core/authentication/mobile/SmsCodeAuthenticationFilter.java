package me.zhin.security.core.authentication.mobile;

import me.zhin.security.core.properties.SecurityConstants;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhin
 * @date 2017/11/15
 */
public class SmsCodeAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
  private String mobileParameter = SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE;
  private boolean postOnly = true;

  public SmsCodeAuthenticationFilter() {
    super(new AntPathRequestMatcher("/authentication/mobile", "POST"));
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException {
    if (this.postOnly && !request.getMethod().equals("POST")) {
      throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
    } else {
      String mobile = this.obtainMobile(request);
      if (mobile == null) {
        mobile = "";
      }

      mobile = mobile.trim();
      SmsCodeAuthenticationToken authRequest = new SmsCodeAuthenticationToken(mobile);
      this.setDetails(request, authRequest);
      return this.getAuthenticationManager().authenticate(authRequest);
    }
  }


  protected String obtainMobile(HttpServletRequest request) {
    return request.getParameter(this.mobileParameter);
  }

  protected void setDetails(HttpServletRequest request, SmsCodeAuthenticationToken authRequest) {
    authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
  }

  public void setUsernameParameter(String mobileParameter) {
    Assert.hasText(mobileParameter, "Username parameter must not be empty or null");
    this.mobileParameter = mobileParameter;
  }

  public void setPostOnly(boolean postOnly) {
    this.postOnly = postOnly;
  }

  public final String getUsernameParameter() {
    return this.mobileParameter;
  }

}
