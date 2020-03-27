package com.monster.greenfruit.pojo.domain;

import java.util.Date;

public class SeasonStatistics {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column season_statistics.year
     *
     * @mbggenerated
     */
    private Date year;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column season_statistics.season
     *
     * @mbggenerated
     */
    private String season;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column season_statistics.season_income
     *
     * @mbggenerated
     */
    private Long seasonIncome;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column season_statistics.growth_rate
     *
     * @mbggenerated
     */
    private Double growthRate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column season_statistics.year
     *
     * @return the value of season_statistics.year
     * @mbggenerated
     */
    public Date getYear() {
        return year;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column season_statistics.year
     *
     * @param year the value for season_statistics.year
     * @mbggenerated
     */
    public void setYear(Date year) {
        this.year = year;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column season_statistics.season
     *
     * @return the value of season_statistics.season
     * @mbggenerated
     */
    public String getSeason() {
        return season;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column season_statistics.season
     *
     * @param season the value for season_statistics.season
     * @mbggenerated
     */
    public void setSeason(String season) {
        this.season = season == null ? null : season.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column season_statistics.season_income
     *
     * @return the value of season_statistics.season_income
     * @mbggenerated
     */
    public Long getSeasonIncome() {
        return seasonIncome;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column season_statistics.season_income
     *
     * @param seasonIncome the value for season_statistics.season_income
     * @mbggenerated
     */
    public void setSeasonIncome(Long seasonIncome) {
        this.seasonIncome = seasonIncome;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column season_statistics.growth_rate
     *
     * @return the value of season_statistics.growth_rate
     * @mbggenerated
     */
    public Double getGrowthRate() {
        return growthRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column season_statistics.growth_rate
     *
     * @param growthRate the value for season_statistics.growth_rate
     * @mbggenerated
     */
    public void setGrowthRate(Double growthRate) {
        this.growthRate = growthRate;
    }
}