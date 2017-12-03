package me.zhin.security.core.validata.code.image;

import me.zhin.security.core.validata.code.impl.AbstractValidateCodeProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

/**
 * @author zhin
 * @date 2017/11/15
 */
@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {
  @Override
  protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
    ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
  }
}
