package com.monster.greenfruit.pojo.dto;

import java.io.Serializable;

public class AdminDTO implements Serializable {


    private Long adminId;

    private String adminName;

    private String adminCellphone;

    private String sex;

    private String adminIdentity;

    private String password;

    private Integer level;

    private String rePwd;

    private String adminSalt;

    private String district;

    private String perms;


    public AdminDTO() { }

    public AdminDTO(Long adminId, String adminName, String adminCellphone,
                    String sex, String adminIdentity, String password,
                    Integer level, String rePwd, String adminSalt,
                    String district, String perms) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminCellphone = adminCellphone;
        this.sex = sex;
        this.adminIdentity = adminIdentity;
        this.password = password;
        this.level = level;
        this.rePwd = rePwd;
        this.adminSalt = adminSalt;
        this.district = district;
        this.perms = perms;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminSalt() {
        return adminSalt;
    }

    public void setAdminSalt(String adminSalt) {
        this.adminSalt = adminSalt;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminCellphone() {
        return adminCellphone;
    }

    public void setAdminCellphone(String adminCellphone) {
        this.adminCellphone = adminCellphone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdminIdentity() {
        return adminIdentity;
    }

    public void setAdminIdentity(String adminIdentity) {
        this.adminIdentity = adminIdentity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getRePwd() {
        return rePwd;
    }

    public void setRePwd(String rePwd) {
        this.rePwd = rePwd;
    }
}
