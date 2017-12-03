package me.zhin.web.weburine.dto;

import me.zhin.web.weburine.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 用于认证的用户与前端显示的DTO
 * @author zhin
 * @date 2017/11/23
 */
public class UserDto extends User implements UserDetails {




  private Collection<GrantedAuthority> authorities;


  public UserDto() {
  }

  public UserDto(Collection<? extends GrantedAuthority> authorities) {
    this.authorities = (Collection<GrantedAuthority>) authorities;
  }


  @Override
  public Collection<GrantedAuthority> getAuthorities() {
    return this.authorities;
  }



  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
