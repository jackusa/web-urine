package me.zhin.web.weburine.service.impl;

import me.zhin.web.weburine.common.ServerResponse;
import me.zhin.web.weburine.dao.SendDetectionMapper;
import me.zhin.web.weburine.entity.SendDetection;
import me.zhin.web.weburine.service.ISendDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhin
 * @date 2017/11/26
 */
@Service("iSendDetectionService")
public class SendDetectionServiceImpl implements ISendDetectionService {

  @Autowired
  private SendDetectionMapper sendDetectionMapper;


  @Override
  public ServerResponse<String> addSendDetection(SendDetection sendDetection) {

    int resultCount = sendDetectionMapper.insert(sendDetection);
    if (resultCount > 0) {
      return ServerResponse.createBySuccessMessage("添加送检信息成功");
    } else {
      return ServerResponse.createByErrorMessage("添加送检信息失败");
    }

  }

  @Override
  public ServerResponse<String> updateSendDetection(SendDetection sendDetection) {
    int resultCount = sendDetectionMapper.updateByPrimaryKey(sendDetection);
    if (resultCount > 0) {
      return ServerResponse.createBySuccessMessage("更新送检信息成功");
    } else {
      return ServerResponse.createByErrorMessage("更新送检信息失败");
    }
  }

  @Override
  public SendDetection selectSendDetection(Integer id) {
    return sendDetectionMapper.selectByPrimaryKey(id);
  }
}
