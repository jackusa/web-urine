package me.zhin.web.weburine.service;

import me.zhin.web.weburine.common.ServerResponse;
import me.zhin.web.weburine.entity.User;

/**
 * @author zhin
 * @date 2017/11/12
 */


public interface IUserService {

  /**
   * 用户注册
   * @param user 用户实体
   * @return 返回服务器响应对象
   */
  ServerResponse<String> register(User user);

  /**
   * 校验用户名、邮箱或手机号是否在数据库有重复
   * @param str 用户名、邮箱或手机号字符串
   * @param type 类型--username、email、phone
   * @return 返回服务器响应对象
   */
  ServerResponse<String> checkValid(String str, String type);


  /**
   * 更新用户个人信息
   * @param user 用户
   * @return 返回服务器响应对象
   */
  ServerResponse<User> updateInformation(User user);


  /**
   * 更新从PC客户端传来的用户信息
   * @param user 用户
   * @return 返回服务器响应对象
   */
  ServerResponse<String> updateInfoByClient(User user);


  User selectUser(Integer id);


}
