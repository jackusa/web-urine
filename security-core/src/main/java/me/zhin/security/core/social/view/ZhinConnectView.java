package me.zhin.security.core.social.view;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author zhin
 * @date 2017/11/16
 */
public class ZhinConnectView extends AbstractView {
  @Override
  protected void renderMergedOutputModel(Map<String, Object> map,
                                         HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse) throws Exception {

    httpServletResponse.setContentType("text/html;charset=UTF-8");
    if (map.get("connections") == null) {
      httpServletResponse.getWriter().write("<h3>解绑成功</h3>");
    } else {
      httpServletResponse.getWriter().write("<h3>绑定成功</h3>");
    }

  }


}
