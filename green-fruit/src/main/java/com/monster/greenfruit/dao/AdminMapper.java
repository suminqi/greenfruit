package com.monster.greenfruit.dao;

import com.monster.greenfruit.pojo.domain.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long adminId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated
     */
    int insert(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated
     */
    Admin selectByPrimaryKey(Long adminId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated
     */
    List<Admin> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Admin record);


    /**
     * 2020-03-19
     * developed by Smq
     */
    Admin selectByCellphone(@Param(value = "adminCellphone") String adminCellphone);

    /**
     * 2020-03-19
     * developed by Smq
     */
    List<Admin> searchAdmin(Long adminId,String adminName,String adminCellphone,Integer level);

}