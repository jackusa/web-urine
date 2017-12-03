package me.zhin.web.weburine.security;//package me.zhin.weburine.security;


import me.zhin.web.weburine.dao.UserMapper;
import me.zhin.web.weburine.dto.UserDto;
import me.zhin.web.weburine.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author zhin
 * @date 2017/11/21
 */
@Component
public class UrineUserDetailsServiceImpl implements UserDetailsService {

  private final static Logger logger = LoggerFactory.getLogger(UrineUserDetailsServiceImpl.class);

  @Autowired
  private UserMapper userMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    logger.info("表单用户名: " + username);

    User user = userMapper.selectUserByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException("user name not found");
    }
    return buildUserFromUserEntity(user);
  }

  private UserDetails buildUserFromUserEntity(User user) {
    // 默认用户都具有 USER 权限，在这里可根据角色定制权限
    UserDto userDto = new UserDto(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    BeanUtils.copyProperties(user, userDto);
    return userDto;
  }


}
