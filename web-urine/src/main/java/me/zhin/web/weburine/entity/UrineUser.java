package me.zhin.web.weburine.entity;

public class UrineUser {
    private Integer id;

    private String sex;

    private String age;

    private String caseNo;

    private String sampleTypes;

    private String sampleNo;

    private String remarks;

    private String createTime;

    private String updateTime;

    private String name;

    private String urineId;

    public UrineUser(Integer id, String sex, String age, String caseNo, String sampleTypes, String sampleNo, String remarks, String createTime, String updateTime, String name, String urineId) {
        this.id = id;
        this.sex = sex;
        this.age = age;
        this.caseNo = caseNo;
        this.sampleTypes = sampleTypes;
        this.sampleNo = sampleNo;
        this.remarks = remarks;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.name = name;
        this.urineId = urineId;
    }

    public UrineUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo == null ? null : caseNo.trim();
    }

    public String getSampleTypes() {
        return sampleTypes;
    }

    public void setSampleTypes(String sampleTypes) {
        this.sampleTypes = sampleTypes == null ? null : sampleTypes.trim();
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo == null ? null : sampleNo.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrineId() {
        return urineId;
    }

    public void setUrineId(String urineId) {
        this.urineId = urineId == null ? null : urineId.trim();
    }
}