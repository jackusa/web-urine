package me.zhin.security.core.validata.code.image;

import me.zhin.security.core.validata.code.ValidateCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author zhin
 * @date 2017/11/14
 */
public class ImageCode extends ValidateCode {

  private BufferedImage image;

  public ImageCode(BufferedImage image, String code, int expireIn) {
    super(code, expireIn);
    this.image = image;
  }

  public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
    super(code, expireTime);
    this.image = image;
  }

  public BufferedImage getImage() {
    return image;
  }

  public void setImage(BufferedImage image) {
    this.image = image;
  }

}
