package me.zhin.web.weburine.entity;

public class Urine {
  private Integer id;

  private String thatDayNo;

  private String leu;

  private String glu;

  private String mca;

  private String bil;

  private String ph;

  private String sg;

  private String ket;

  private String pro;

  private String nit;

  private String uro;

  private String cre;

  private String bld;

  private String ca;

  private String vc;

  private String cal;

  private String paperType;

  private String createTime;

  private String updateTime;

  private Integer userId;

  private String detectDate;

  private Integer sendDetectionId;

  private Integer urineUserId;

  private String time;

  public Urine(Integer id, String thatDayNo, String leu, String glu, String mca, String bil, String ph, String sg, String ket, String pro, String nit, String uro, String cre, String bld, String ca, String vc, String cal, String paperType, String createTime, String updateTime, Integer userId, String detectDate, Integer sendDetectionId, Integer urineUserId, String time) {
    this.id = id;
    this.thatDayNo = thatDayNo;
    this.leu = leu;
    this.glu = glu;
    this.mca = mca;
    this.bil = bil;
    this.ph = ph;
    this.sg = sg;
    this.ket = ket;
    this.pro = pro;
    this.nit = nit;
    this.uro = uro;
    this.cre = cre;
    this.bld = bld;
    this.ca = ca;
    this.vc = vc;
    this.cal = cal;
    this.paperType = paperType;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.userId = userId;
    this.detectDate = detectDate;
    this.sendDetectionId = sendDetectionId;
    this.urineUserId = urineUserId;
    this.time = time;
  }

  public Urine() {
    super();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getThatDayNo() {
    return thatDayNo;
  }

  public void setThatDayNo(String thatDayNo) {
    this.thatDayNo = thatDayNo == null ? null : thatDayNo.trim();
  }

  public String getLeu() {
    return leu;
  }

  public void setLeu(String leu) {
    this.leu = leu == null ? null : leu.trim();
  }

  public String getGlu() {
    return glu;
  }

  public void setGlu(String glu) {
    this.glu = glu == null ? null : glu.trim();
  }

  public String getMca() {
    return mca;
  }

  public void setMca(String mca) {
    this.mca = mca == null ? null : mca.trim();
  }

  public String getBil() {
    return bil;
  }

  public void setBil(String bil) {
    this.bil = bil == null ? null : bil.trim();
  }

  public String getPh() {
    return ph;
  }

  public void setPh(String ph) {
    this.ph = ph == null ? null : ph.trim();
  }

  public String getSg() {
    return sg;
  }

  public void setSg(String sg) {
    this.sg = sg == null ? null : sg.trim();
  }

  public String getKet() {
    return ket;
  }

  public void setKet(String ket) {
    this.ket = ket == null ? null : ket.trim();
  }

  public String getPro() {
    return pro;
  }

  public void setPro(String pro) {
    this.pro = pro == null ? null : pro.trim();
  }

  public String getNit() {
    return nit;
  }

  public void setNit(String nit) {
    this.nit = nit == null ? null : nit.trim();
  }

  public String getUro() {
    return uro;
  }

  public void setUro(String uro) {
    this.uro = uro == null ? null : uro.trim();
  }

  public String getCre() {
    return cre;
  }

  public void setCre(String cre) {
    this.cre = cre == null ? null : cre.trim();
  }

  public String getBld() {
    return bld;
  }

  public void setBld(String bld) {
    this.bld = bld == null ? null : bld.trim();
  }

  public String getCa() {
    return ca;
  }

  public void setCa(String ca) {
    this.ca = ca == null ? null : ca.trim();
  }

  public String getVc() {
    return vc;
  }

  public void setVc(String vc) {
    this.vc = vc == null ? null : vc.trim();
  }

  public String getCal() {
    return cal;
  }

  public void setCal(String cal) {
    this.cal = cal == null ? null : cal.trim();
  }

  public String getPaperType() {
    return paperType;
  }

  public void setPaperType(String paperType) {
    this.paperType = paperType == null ? null : paperType.trim();
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime == null ? null : createTime.trim();
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime == null ? null : updateTime.trim();
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getDetectDate() {
    return detectDate;
  }

  public void setDetectDate(String detectDate) {
    this.detectDate = detectDate == null ? null : detectDate.trim();
  }

  public Integer getSendDetectionId() {
    return sendDetectionId;
  }

  public void setSendDetectionId(Integer sendDetectionId) {
    this.sendDetectionId = sendDetectionId;
  }

  public Integer getUrineUserId() {
    return urineUserId;
  }

  public void setUrineUserId(Integer urineUserId) {
    this.urineUserId = urineUserId;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time == null ? null : time.trim();
  }

  public String[] getAllValue() {
    return new String[]{
        getLeu(), getGlu(), getMca(), getBil(), getPh(), getSg(), getKet(),
        getPro(), getNit(), getUro(), getCre(), getBld(), getCa(), getVc(),
    };
  }

  public static String[] getAllName() {
    return new String[]{
        "LEU (白细胞)", "GLU (葡萄糖)", "MCA (微量白蛋白)", "BIL (胆红素)",
        "PH (PH值)", "SG (比重)", "KET (酮体)", "PRO (蛋白质)", "NIT (亚硝酸盐)",
        "URO (胆原)", "CRE (肌酐)", "BLD (潜血)", "CA (钙离子)", "VC (抗坏血酸)"
    };
  }

  public static String[] getAllNameEn() {
    return new String[]{
        "LEU", "GLU", "MCA", "BIL", "PH", "SG", "KET",
        "PRO", "NIT", "URO", "CRE", "BLD", "CA", "VC"
    };
  }

  public static String[] getAllNameCn() {
    return new String[]{
        "白细胞", "葡萄糖", "微量白蛋白", "胆红素", "PH值", "比重", "酮体",
        "蛋白质", "亚硝酸盐", "胆原", "肌酐", "潜血", "钙离子", "抗坏血酸",
    };
  }
}