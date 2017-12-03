package me.zhin.web.weburine.dao;

import me.zhin.web.weburine.entity.Urine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UrineMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(Urine record);

  int insertSelective(Urine record);

  Urine selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Urine record);

  int updateByPrimaryKey(Urine record);

  Urine selectUrineByDateAndNo(@Param("thatDayNo") String thatDayNo,
                               @Param("detectionDate") String detectionDate);

  List<Urine> selectUrineByUserId(Integer userId);

}