package com.monster.greenfruit.dao;

import com.monster.greenfruit.pojo.domain.YearStatistics;

import java.util.Date;
import java.util.List;

public interface YearStatisticsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table year_statistics
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Date year);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table year_statistics
     *
     * @mbggenerated
     */
    int insert(YearStatistics record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table year_statistics
     *
     * @mbggenerated
     */
    YearStatistics selectByPrimaryKey(Date year);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table year_statistics
     *
     * @mbggenerated
     */
    List<YearStatistics> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table year_statistics
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(YearStatistics record);
}