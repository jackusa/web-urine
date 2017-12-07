package me.zhin.web.weburine.controller;

import me.zhin.web.weburine.common.ServerResponse;
import me.zhin.web.weburine.dao.UserMapper;
import me.zhin.web.weburine.dto.UserDto;
import me.zhin.web.weburine.dto.UserUpdateDto;
import me.zhin.web.weburine.entity.SendDetection;
import me.zhin.web.weburine.entity.Urine;
import me.zhin.web.weburine.entity.UrineUser;
import me.zhin.web.weburine.entity.User;
import me.zhin.web.weburine.service.ISendDetectionService;
import me.zhin.web.weburine.service.IUrineService;
import me.zhin.web.weburine.service.IUrineUserService;
import me.zhin.web.weburine.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhin
 * @date 2017/11/12
 */
@Controller
public class UserController {

  @Autowired
  private IUserService iUserService;

  @Autowired
  private IUrineUserService iUrineUserService;

  @Autowired
  private IUrineService iUrineService;

  @Autowired
  private ISendDetectionService iSendDetectionService;


  /**
   * 创建一个用户
   * @param user 用户实体
   * @return 视图名称
   */
  @PostMapping("/users")
  @ResponseBody
  public ServerResponse<String> register(User user, Model model) {
    return iUserService.register(user);
  }


  @GetMapping("/urines")
  public String queryUrine(@AuthenticationPrincipal UserDto user,
                           RedirectAttributes redirectAttributes,
                           @RequestParam String thatDayNo,
                           @RequestParam String detectionDate) {

    Urine urine = iUrineService.selectUrine(thatDayNo, detectionDate);
    UrineUser urineUser = null;
    SendDetection sendDetection = null;
    redirectAttributes.addFlashAttribute("thatDayNo", thatDayNo);
    redirectAttributes.addFlashAttribute("detectionDate", detectionDate);
    redirectAttributes.addFlashAttribute("user", user);
    redirectAttributes.addFlashAttribute("isQuery", true);
    if (urine != null) {
      urineUser = iUrineUserService.selectUrineUser(urine.getUrineUserId());
      sendDetection = iSendDetectionService.selectSendDetection(urine.getSendDetectionId());

      String[] urines = urine.getAllValue();
      String[] urineNames = Urine.getAllName();
      Map<String, String> urineMap = new HashMap<>(urines.length);
      for (int i = 0; i < urines.length; i++) {
        if (urines[i] != null && !"null".equals(urines[i])) {
          urineMap.put(urineNames[i], urines[i]);
        }
      }
      redirectAttributes.addFlashAttribute("urineMap", urineMap);

      if (urineUser != null) {
        redirectAttributes.addFlashAttribute("urineUser", urineUser);
      }

      if (sendDetection != null) {
        redirectAttributes.addFlashAttribute("sendDetection", sendDetection);
      }

    } else {
      redirectAttributes.addFlashAttribute("hasUrineData", false);
    }

    return "redirect:/data";
  }


  @PostMapping("/saves/{id:\\d+}")
  @ResponseBody
  public ServerResponse<String> saveUrineData(@PathVariable String id,
                              @RequestParam String thatDayNo,
                              @RequestParam String detectionDate) {
    Urine urine = iUrineService.selectUrine(thatDayNo, detectionDate);
    if (urine != null) {
      urine.setUserId(Integer.valueOf(id));
    }
    return iUrineService.updateUrineTest(urine);
  }

  /**
   * 修改用户个人信息
   * @param model 数据
   * @return 视图名称
   */
  @PostMapping("/users/{id:\\d+}")
  public String modifyInfo(@PathVariable String id, UserUpdateDto userUpdateDto,
                           Model model) {
    User user = new User();
    BeanUtils.copyProperties(userUpdateDto, user);
    user.setId(Integer.valueOf(id));
    ServerResponse<User> response = iUserService.updateInformation(user);

    if (response.isSuccess()) {
      UserDto userDto = new UserDto(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
      user = iUserService.selectUser(Integer.valueOf(id));
      BeanUtils.copyProperties(user, userDto);
      // 重新加载登录的认证用户
      Authentication authentication = new UsernamePasswordAuthenticationToken(
          userDto, userDto.getPassword(), userDto.getAuthorities());
      SecurityContextHolder.getContext().setAuthentication(authentication);
      model.addAttribute("user", userDto);
      model.addAttribute("message", response.getMsg());
      return "redirect:/data";
    } else {
      return "redirect:/data";
    }
  }


}
