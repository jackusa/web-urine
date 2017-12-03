package me.zhin.web.weburine.service;

import me.zhin.web.weburine.common.ServerResponse;
import me.zhin.web.weburine.entity.SendDetection;
import me.zhin.web.weburine.entity.Urine;

/**
 * @author zhin
 * @date 2017/11/26
 */
public interface ISendDetectionService {


  ServerResponse<String> addSendDetection(SendDetection sendDetection);

  ServerResponse<String> updateSendDetection(SendDetection sendDetection);

  SendDetection selectSendDetection(Integer id);





}
