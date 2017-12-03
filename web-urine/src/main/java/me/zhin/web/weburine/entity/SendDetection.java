package me.zhin.web.weburine.entity;

public class SendDetection {
    private Integer id;

    private String doctor;

    private String checker;

    private String verifyer;

    private String sendDetectionTime;

    private String createTime;

    private String updateTime;

    private String urineId;

    public SendDetection(Integer id, String doctor, String checker, String verifyer, String sendDetectionTime, String createTime, String updateTime, String urineId) {
        this.id = id;
        this.doctor = doctor;
        this.checker = checker;
        this.verifyer = verifyer;
        this.sendDetectionTime = sendDetectionTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.urineId = urineId;
    }

    public SendDetection() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor == null ? null : doctor.trim();
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker == null ? null : checker.trim();
    }

    public String getVerifyer() {
        return verifyer;
    }

    public void setVerifyer(String verifyer) {
        this.verifyer = verifyer == null ? null : verifyer.trim();
    }

    public String getSendDetectionTime() {
        return sendDetectionTime;
    }

    public void setSendDetectionTime(String sendDetectionTime) {
        this.sendDetectionTime = sendDetectionTime == null ? null : sendDetectionTime.trim();
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

    public String getUrineId() {
        return urineId;
    }

    public void setUrineId(String urineId) {
        this.urineId = urineId == null ? null : urineId.trim();
    }
}