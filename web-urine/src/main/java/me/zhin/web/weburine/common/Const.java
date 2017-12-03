package me.zhin.web.weburine.common;

/**
 * @author zhin
 * @date 2017/11/13
 */
public class Const {

  public static final String CURRENT_USER = "currentUser";
  public static final String EMAIL = "email";
  public static final String USERNAME = "username";
  public static final String PHONE = "phone";

  public interface Role {
    /**
     * 管理员
     */
    int ROLE_ADMIN = 1;
    /**
     * 普通用户
     */
    int ROLE_CUSTOMER = 0;
  }

}
