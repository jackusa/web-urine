package me.zhin.security.core.properties;

/**
 * @author zhin
 * @date 2017/11/14
 */

public class ImageCodeProperties extends SmsCodeProperties {

  private int width = 67;
  private int height = 23;


  public ImageCodeProperties() {
    setLength(4);
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

}
