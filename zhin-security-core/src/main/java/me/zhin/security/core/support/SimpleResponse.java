package me.zhin.security.core.support;

/**
 * @author zhin
 * @date 2017/11/14
 */
public class SimpleResponse {


  private Object content;


  public SimpleResponse(Object content) {
    this.content = content;
  }

  public Object getContent() {
    return content;
  }

  public void setContent(Object content) {
    this.content = content;
  }
}
