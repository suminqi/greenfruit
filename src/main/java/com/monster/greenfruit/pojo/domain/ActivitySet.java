package com.monster.greenfruit.pojo.domain;

public class ActivitySet {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity_set.admin_id
     *
     * @mbggenerated
     */
    private Long adminId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity_set.admin_name
     *
     * @mbggenerated
     */
    private String adminName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_set.admin_id
     *
     * @return the value of activity_set.admin_id
     * @mbggenerated
     */
    public Long getAdminId() {
        return adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_set.admin_id
     *
     * @param adminId the value for activity_set.admin_id
     * @mbggenerated
     */
    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_set.admin_name
     *
     * @return the value of activity_set.admin_name
     * @mbggenerated
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_set.admin_name
     *
     * @param adminName the value for activity_set.admin_name
     * @mbggenerated
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }
}