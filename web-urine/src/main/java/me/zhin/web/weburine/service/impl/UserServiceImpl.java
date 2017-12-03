package me.zhin.web.weburine.service.impl;

import me.zhin.web.weburine.common.Const;
import me.zhin.web.weburine.common.ServerResponse;
import me.zhin.web.weburine.dao.UserMapper;
import me.zhin.web.weburine.entity.User;
import me.zhin.web.weburine.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author zhin
 * @date 2017/11/12
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private PasswordEncoder passwordEncoder;

  /**
   * 用户注册
   * @param user 用户实体
   * @return 返回服务器响应对象
   */
  @Override
  public ServerResponse<String> register(User user) {
    // 校验用户名、邮箱或手机号是否有重复
    ServerResponse<String> validResponse = this.checkValid(user.getUsername(), Const.USERNAME);
    // isSuccess()-->返回 false 说明已存在用户名或邮箱
    if (!validResponse.isSuccess()) {
      // 用户名已存在
      return validResponse;
    }
    if ( StringUtils.isNotBlank(user.getEmail()) ) {
      validResponse = this.checkValid(user.getEmail(), Const.EMAIL);
      if (!validResponse.isSuccess()) {
        // 邮箱已存在
        return validResponse;
      }
    }
    // 注册可以用手机号或邮箱，所以可能为空
    if ( StringUtils.isNotBlank(user.getPhone()) ) {
      validResponse = this.checkValid(user.getPhone(), Const.PHONE);
      if (!validResponse.isSuccess()) {
        // 手机号已存在
        return validResponse;
      }
    }
    // 设置用户角色
    user.setRole(Const.Role.ROLE_CUSTOMER);
    user.setCreateTime(String.valueOf(System.currentTimeMillis()));
    // 使用 Spring 提供的加解密工具类
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    // 以上校验通过则注册
    int resultCount = userMapper.insert(user);
    if (resultCount > 0) {
      return ServerResponse.createBySuccessMessage("注册成功");
    } else {
      return ServerResponse.createByErrorMessage("注册失败");
    }
  }

  /**
   * 校验用户名、邮箱或手机号是否在数据库有重复
   * @param str 用户名、邮箱或手机号字符串
   * @param type 类型--username、email、phone
   * @return 返回服务器响应对象
   */
  @Override
  public ServerResponse<String> checkValid(String str, String type) {
    if (StringUtils.isNotBlank(type)) {
      // 开始校验
      int resultCount = 0;
      if (Const.USERNAME.equals(type)) {
        resultCount = userMapper.checkUsername(str);
        if (resultCount > 0) {
          return ServerResponse.createByErrorMessage("用户名已存在");
        }
      } else if (Const.EMAIL.equals(type)) {
        resultCount = userMapper.checkEmail(str);
        if (resultCount > 0) {
          return ServerResponse.createByErrorMessage("邮箱已存在");
        }
      } else if (Const.PHONE.equals(type)) {
        resultCount = userMapper.checkPhone(str);
        if (resultCount > 0) {
          return ServerResponse.createByErrorMessage("手机号已存在");
        }
      }
    } else {
      return ServerResponse.createByErrorMessage("参数错误");
    }

    return ServerResponse.createBySuccessMessage("校验成功");
  }


  @Override
  public ServerResponse<User> updateInformation(User user) {
    int resultCount = userMapper.checkEmail(user.getEmail());
    if (resultCount > 0) {
      return ServerResponse.createByErrorMessage("邮箱已使用，请更换其他邮箱再尝试");
    }

    resultCount = userMapper.checkPhone(user.getPhone());
    if (resultCount > 0) {
      return ServerResponse.createByErrorMessage("手机已使用，请更换其他手机再尝试");
    }

    user.setUpdateTime(String.valueOf(System.currentTimeMillis()));
    resultCount = userMapper.updateByPrimaryKeySelective(user);
    if (resultCount > 0) {
      return ServerResponse.createBySuccess("更新个人信息成功", user);
    } else {
      System.out.println("更新个人信息失败");
      return ServerResponse.createByErrorMessage("更新个人信息失败");
    }
  }

  @Override
  public User selectUser(Integer id) {
    return userMapper.selectByPrimaryKey(id);
  }

  @Override
  public ServerResponse<String> updateInfoByClient(User user) {
    int resultCount = userMapper.updateByPrimaryKeySelective(user);
    if (resultCount > 0) {
      return ServerResponse.createBySuccessMessage("更新用户详情成功");
    } else {
      return ServerResponse.createByErrorMessage("更新用户详情失败");
    }

  }


}
