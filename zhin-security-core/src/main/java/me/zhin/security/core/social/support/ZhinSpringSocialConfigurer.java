package me.zhin.security.core.social.support;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author zhin
 * @date 2017/11/15
 */
public class ZhinSpringSocialConfigurer extends SpringSocialConfigurer {

  private String filterProcessesUrl;

  private SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor;

  public ZhinSpringSocialConfigurer(String filterProcessesUrl) {
    this.filterProcessesUrl = filterProcessesUrl;
  }

  @SuppressWarnings("unchecked")
  @Override
  protected <T> T postProcess(T object) {
    SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
    filter.setFilterProcessesUrl(filterProcessesUrl);
    if (socialAuthenticationFilterPostProcessor != null) {
      socialAuthenticationFilterPostProcessor.process(filter);
    }
    return (T) filter;
  }

  public String getFilterProcessesUrl() {
    return filterProcessesUrl;
  }

  public void setFilterProcessesUrl(String filterProcessesUrl) {
    this.filterProcessesUrl = filterProcessesUrl;
  }

  public SocialAuthenticationFilterPostProcessor getSocialAuthenticationFilterPostProcessor() {
    return socialAuthenticationFilterPostProcessor;
  }

  public void setSocialAuthenticationFilterPostProcessor(SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor) {
    this.socialAuthenticationFilterPostProcessor = socialAuthenticationFilterPostProcessor;
  }
}
