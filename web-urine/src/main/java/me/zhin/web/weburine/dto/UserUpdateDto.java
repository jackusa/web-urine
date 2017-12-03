package me.zhin.web.weburine.dto;

/**
 * 用户更新的DTO，有需要再增加增加字段
 * @author zhin
 * @date 2017/11/24
 */
public class UserUpdateDto {
  private Integer id;

  private String email;

  private String phone;

  private String sex;

  private String age;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }
}
