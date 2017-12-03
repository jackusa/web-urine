package me.zhin.web.weburine.service.impl;

import me.zhin.web.weburine.common.ServerResponse;
import me.zhin.web.weburine.dao.UrineUserMapper;
import me.zhin.web.weburine.entity.Urine;
import me.zhin.web.weburine.entity.UrineUser;
import me.zhin.web.weburine.service.IUrineUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhin
 * @date 2017/11/26
 */
@Service("iUrineUserService")
public class UrineUserServiceImpl implements IUrineUserService {

  @Autowired
  private UrineUserMapper urineUserMapper;


  @Override
  public ServerResponse<String> addUrineUser(UrineUser urineUser) {

    int resultCount = urineUserMapper.insert(urineUser);
    if (resultCount > 0) {
      return ServerResponse.createBySuccessMessage("添加尿检用户成功");
    } else {
      return ServerResponse.createByErrorMessage("添加尿检用户失败");
    }

  }

  @Override
  public ServerResponse<String> updateUrineUser(UrineUser urineUser) {
    int resultCount = urineUserMapper.updateByPrimaryKey(urineUser);
    if (resultCount > 0) {
      return ServerResponse.createBySuccessMessage("更新尿检用户成功");
    } else {
      return ServerResponse.createByErrorMessage("更新尿检用户失败");
    }
  }

  @Override
  public UrineUser selectUrineUser(Integer id) {
    return urineUserMapper.selectByPrimaryKey(id);
  }


}
