package me.zhin.web.weburine.controller;

import me.zhin.web.weburine.dao.SendDetectionMapper;
import me.zhin.web.weburine.dao.UrineMapper;
import me.zhin.web.weburine.dao.UrineUserMapper;
import me.zhin.web.weburine.dto.UserDto;
import me.zhin.web.weburine.entity.SendDetection;
import me.zhin.web.weburine.entity.Urine;
import me.zhin.web.weburine.entity.UrineUser;
import me.zhin.web.weburine.service.ISendDetectionService;
import me.zhin.web.weburine.service.IUrineService;
import me.zhin.web.weburine.service.IUrineUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhin
 * @date 2017/11/10
 */
@Controller
public class IndexController {

  // todo html做seo优化

  private boolean isLogin = false;

  @Autowired
  private IUrineUserService iUrineUserService;

  @Autowired
  private IUrineService iUrineService;

  @Autowired
  private ISendDetectionService iSendDetectionService;


  @ModelAttribute
  public void isLogin(@AuthenticationPrincipal UserDetails user, Model model) {
    if (user != null) {
      isLogin = true;
      model.addAttribute("isLogin", true);
    }
  }

  @GetMapping(value = {"/index", "/"})
  public String index(Model model) {

    return "index";
  }

  @GetMapping("/data")
  public String data(@AuthenticationPrincipal UserDto user, Model model) {
    // 能走到此URL说明用户已登录，user 是自定义返回的 UserDto 对象，返回给前端显示
    model.addAttribute("user", user);

    UrineUser urineUser = null;
    SendDetection sendDetection = null;
    List<Urine> urineList = iUrineService.selectUrine(user.getId());

    if (urineList.size() > 0) {
      // 目前只显示一条数据
      for(int i = 0; i < 1; i++) {
        int lastIndex = urineList.size()-1;
        urineUser = iUrineUserService.selectUrineUser(urineList.get(lastIndex).getUrineUserId());
        sendDetection = iSendDetectionService.selectSendDetection(urineList.get(lastIndex).getSendDetectionId());
        String[] urines = urineList.get(lastIndex).getAllValue();
        String[] urineNames = Urine.getAllName();
        Map<String, String> urineMap = new HashMap<>(urines.length);

        for (int j = 0; j < urines.length; j++) {
          if (urines[j] != null && !"null".equals(urines[j])) {
            urineMap.put(urineNames[j], urines[j]);
          }
        }

        model.addAttribute("urineMap", urineMap);
        model.addAttribute("urineUser", urineUser);
        model.addAttribute("sendDetection", sendDetection);
      }

    }


    return "data";
  }

  @GetMapping("/detail")
  public String detail(Model model) {


    return "detail";
  }

  @GetMapping("/about")
  public String about(Model model) {

    return "about";
  }

  @GetMapping("/login")
  public String login(Model model) {

    return "login";
  }

  @GetMapping("/signUp")
  public String signUp(Model model) {

    return "signUp";
  }

  @GetMapping("/session/invalid")
  public String sessionInvalid(Model model) {
    model.addAttribute("error", "Session已失效");
    model.addAttribute("message", "请用户重新登录");
    return "/session/invalid";
  }

}

