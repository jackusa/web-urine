package me.zhin.web.weburine.common;



/**
 * @author zhin
 * @date 2017/10/31
 */
public enum ResponseCode {

  /**
   * 表示某个操作成功
   */
  SUCCESS(0, "SUCCESS"),
  ERROR(1, "ERROR"),
  NEED_LOGIN(10, "NEED_LOGIN"),
  ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT");

  private final int code;
  private final String desc;

  ResponseCode(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public int getCode() {
    return code;
  }

  public String getDesc() {
    return desc;
  }


}
