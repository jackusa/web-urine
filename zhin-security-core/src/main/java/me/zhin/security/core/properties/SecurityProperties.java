package me.zhin.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhin
 * @date 2017/11/14
 */
@ConfigurationProperties(prefix = "zhin.security")
public class SecurityProperties {

  private BrowserProperties browser = new BrowserProperties();

  private ValidateCodeProperties code = new ValidateCodeProperties();

  private SocialProperties social = new SocialProperties();

  private OAuth2Properties OAuth2 = new OAuth2Properties();

  public OAuth2Properties getOAuth2() {
    return OAuth2;
  }

  public void setOAuth2(OAuth2Properties OAuth2) {
    this.OAuth2 = OAuth2;
  }

  public BrowserProperties getBrowser() {
    return browser;
  }

  public void setBrowser(BrowserProperties browser) {
    this.browser = browser;
  }

  public ValidateCodeProperties getCode() {
    return code;
  }

  public void setCode(ValidateCodeProperties code) {
    this.code = code;
  }

  public SocialProperties getSocial() {
    return social;
  }

  public void setSocial(SocialProperties social) {
    this.social = social;
  }
}
