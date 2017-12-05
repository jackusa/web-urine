package me.zhin.security.core.properties;

/**
 * @author zhin
 * @date 2017/11/15
 */
public class SocialProperties {

  /**
   * 社交登录功能拦截的url
   */
  private String filterProcessesUrl = "/auth";

  private QQProperties qq = new QQProperties();

  private WeixinProperties weixin = new WeixinProperties();

  public WeixinProperties getWeixin() {
    return weixin;
  }

  public void setWeixin(WeixinProperties weixin) {
    this.weixin = weixin;
  }

  public QQProperties getQq() {
    return qq;
  }

  public void setQq(QQProperties qq) {
    this.qq = qq;
  }

  public String getFilterProcessesUrl() {
    return filterProcessesUrl;
  }

  public void setFilterProcessesUrl(String filterProcessesUrl) {
    this.filterProcessesUrl = filterProcessesUrl;
  }
}
