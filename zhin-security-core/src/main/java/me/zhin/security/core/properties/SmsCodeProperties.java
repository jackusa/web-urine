package me.zhin.security.core.properties;

/**
 * @author zhin
 * @date 2017/11/15
 */
public class SmsCodeProperties {

  private int length = 6;
  private int expireIn = 60;

  private String url;

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getExpireIn() {
    return expireIn;
  }

  public void setExpireIn(int expireIn) {
    this.expireIn = expireIn;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
