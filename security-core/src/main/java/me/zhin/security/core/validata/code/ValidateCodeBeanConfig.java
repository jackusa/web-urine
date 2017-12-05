package me.zhin.security.core.validata.code;

import me.zhin.security.core.properties.SecurityProperties;
import me.zhin.security.core.validata.code.image.ImageCodeGenerator;
import me.zhin.security.core.validata.code.sms.DefaultSmsCodeSender;
import me.zhin.security.core.validata.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 验证码相关的扩展点配置。配置在这里的bean，业务系统都可以通过声明同类型或同名的bean来覆盖安全
 * 模块默认的配置。
 * @author zhin
 * @date 2017/11/14
 */
@Configuration
public class ValidateCodeBeanConfig {

  @Autowired
  private SecurityProperties securityProperties;

  @Bean
  @ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
  public ValidateCodeGenerator imageValidateCodeGenerator() {
    ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
    codeGenerator.setSecurityProperties(securityProperties);
    return codeGenerator;
  }

  @Bean
  @ConditionalOnMissingBean(SmsCodeSender.class)
  public SmsCodeSender smsCodeSender() {
    return new DefaultSmsCodeSender();
  }


}
