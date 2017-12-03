package me.zhin.web.weburine.controller;

import me.zhin.web.weburine.common.ServerResponse;
import me.zhin.web.weburine.entity.SendDetection;
import me.zhin.web.weburine.entity.Urine;
import me.zhin.web.weburine.entity.UrineUser;
import me.zhin.web.weburine.entity.User;
import me.zhin.web.weburine.service.ISendDetectionService;
import me.zhin.web.weburine.service.IUrineService;
import me.zhin.web.weburine.service.IUrineUserService;
import me.zhin.web.weburine.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhin
 * @date 2017/11/24
 */
@RestController
public class ReceiveController {

  @Autowired
  private IUrineService iUrineService;

  @Autowired
  private ISendDetectionService iSendDetectionService;

  @Autowired
  private IUrineUserService iUrineUserService;

  @PostMapping("/urines")
  @ResponseBody
  public ServerResponse<String> receiveUrineData(@RequestBody Urine urine) {
    System.out.println("上传尿检数据");
    if (iUrineService.selectUrine(urine.getThatDayNo(), urine.getDetectDate()) != null ) {
      return iUrineService.updateUrineTest(urine);
    } else {
      return iUrineService.addUrineTest(urine);
    }

  }


  @PostMapping("/patients")
  @ResponseBody
  public ServerResponse<String> receiveUserData(@RequestBody UrineUser urineUser) {
    System.out.println("上传尿检用户数据");

    if (iUrineUserService.selectUrineUser(urineUser.getId()) != null) {
      return iUrineUserService.updateUrineUser(urineUser);
    } else {
      return iUrineUserService.addUrineUser(urineUser);
    }
  }


  @PostMapping("/discover")
  @ResponseBody
  public ServerResponse<String> receiveData(@RequestBody SendDetection sendDetection) {
    System.out.println("上传送检数据");
    if (iUrineUserService.selectUrineUser(sendDetection.getId()) != null) {
      return iSendDetectionService.updateSendDetection(sendDetection);
    } else {
      return iSendDetectionService.addSendDetection(sendDetection);
    }

  }


}
