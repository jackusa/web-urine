package me.zhin.web.weburine.service;

import me.zhin.web.weburine.common.ServerResponse;
import me.zhin.web.weburine.entity.Urine;
import me.zhin.web.weburine.entity.UrineUser;

/**
 * @author zhin
 * @date 2017/11/26
 */
public interface IUrineUserService {

  ServerResponse<String> addUrineUser(UrineUser urineUser);

  ServerResponse<String> updateUrineUser(UrineUser urineUser);

  UrineUser selectUrineUser(Integer id);

}
