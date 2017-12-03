package me.zhin.web.weburine.dao;

import me.zhin.web.weburine.entity.UrineUser;

public interface UrineUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UrineUser record);

    int insertSelective(UrineUser record);

    UrineUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UrineUser record);

    int updateByPrimaryKey(UrineUser record);
}