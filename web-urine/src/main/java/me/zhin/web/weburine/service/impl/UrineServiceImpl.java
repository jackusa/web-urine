package me.zhin.web.weburine.service.impl;

import me.zhin.web.weburine.common.ServerResponse;
import me.zhin.web.weburine.dao.UrineMapper;
import me.zhin.web.weburine.entity.Urine;
import me.zhin.web.weburine.service.IUrineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhin
 * @date 2017/11/26
 */
@Service("iUrineService")
public class UrineServiceImpl implements IUrineService {

  @Autowired
  private UrineMapper urineMapper;

  @Override
  public ServerResponse<String> addUrineTest(Urine urine) {
    int resultCount = urineMapper.insert(urine);
    if (resultCount > 0) {
      return ServerResponse.createBySuccessMessage("添加尿检数据成功");
    } else {
      return ServerResponse.createByErrorMessage("添加尿检数据失败");
    }
  }

  @Override
  public ServerResponse<String> updateUrineTest(Urine urine) {
    int resultCount = urineMapper.updateByPrimaryKey(urine);
    if (resultCount > 0) {
      return ServerResponse.createBySuccessMessage("更新尿检数据成功");
    } else {
      return ServerResponse.createByErrorMessage("更新尿检数据失败");
    }
  }

  @Override
  public Urine selectUrine(String thatDayNo, String detectionDate) {
    return urineMapper.selectUrineByDateAndNo(thatDayNo, detectionDate);
  }

  @Override
  public List<Urine> selectUrine(Integer userId) {
    return urineMapper.selectUrineByUserId(userId);
  }


}
