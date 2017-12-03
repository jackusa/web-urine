package me.zhin.web.weburine.service;

import me.zhin.web.weburine.common.ServerResponse;
import me.zhin.web.weburine.entity.Urine;

import java.util.List;

/**
 * @author zhin
 * @date 2017/11/26
 */
public interface IUrineService {


  ServerResponse<String> addUrineTest(Urine urine);

  ServerResponse<String> updateUrineTest(Urine urine);

  Urine selectUrine(String thatDayNo, String detectionDate);

  List<Urine> selectUrine(Integer userId);



}
