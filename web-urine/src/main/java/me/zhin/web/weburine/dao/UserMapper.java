package me.zhin.web.weburine.dao;

import me.zhin.web.weburine.entity.Urine;
import me.zhin.web.weburine.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);



  int checkUsername(String str);

  int checkEmail(String str);

  int checkPhone(String str);

  User selectUserByUsername(String username);







}