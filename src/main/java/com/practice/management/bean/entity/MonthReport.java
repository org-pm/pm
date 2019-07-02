package com.practice.management.bean.entity;

/*
* 月报
* */

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MonthReport {
    private int id;
    private Date startTime;
    private Date endTime;
    private String trainContent;
    private String trainHarvest;
    private Date submitTime;
    private String year;
    private String enterpriseOpinion;
    private String schoolExamine;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTrainContent() {
        return trainContent;
    }

    public void setTrainContent(String trainContent) {
        this.trainContent = trainContent;
    }

    public String getTrainHarvest() {
        return trainHarvest;
    }

    public void setTrainHarvest(String trainHarvest) {
        this.trainHarvest = trainHarvest;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEnterpriseOpinion() {
        return enterpriseOpinion;
    }

    public void setEnterpriseOpinion(String enterpriseOpinion) {
        this.enterpriseOpinion = enterpriseOpinion;
    }

    public String getSchoolExamine() {
        return schoolExamine;
    }

    public void setSchoolExamine(String schoolExamine) {
        this.schoolExamine = schoolExamine;
    }
}