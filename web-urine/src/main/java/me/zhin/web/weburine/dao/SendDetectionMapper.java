package me.zhin.web.weburine.dao;

import me.zhin.web.weburine.entity.SendDetection;

public interface SendDetectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SendDetection record);

    int insertSelective(SendDetection record);

    SendDetection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SendDetection record);

    int updateByPrimaryKey(SendDetection record);
}