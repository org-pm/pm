package com.practice.management.bean.entity;


import java.util.Date;

public class WeekTrain {
    private Long id;
    private Integer trainTimes;
    private Integer trainNumber;
    private Date startTime;
    private Date endTime;
    private String baseName;
    private String weekTeach;
    private String weekStudentLearn;
    private String feedbackFocus;
    private String trainAssessmentSituation;
    private Long majorId;
    private Long enterpriseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTrainTimes() {
        return trainTimes;
    }

    public void setTrainTimes(Integer trainTimes) {
        this.trainTimes = trainTimes;
    }

    public Integer getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(Integer trainNumber) {
        this.trainNumber = trainNumber;
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

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getWeekTeach() {
        return weekTeach;
    }

    public void setWeekTeach(String weekTeach) {
        this.weekTeach = weekTeach;
    }

    public String getWeekStudentLearn() {
        return weekStudentLearn;
    }

    public void setWeekStudentLearn(String weekStudentLearn) {
        this.weekStudentLearn = weekStudentLearn;
    }

    public String getFeedbackFocus() {
        return feedbackFocus;
    }

    public void setFeedbackFocus(String feedbackFocus) {
        this.feedbackFocus = feedbackFocus;
    }

    public String getTrainAssessmentSituation() {
        return trainAssessmentSituation;
    }

    public void setTrainAssessmentSituation(String trainAssessmentSituation) {
        this.trainAssessmentSituation = trainAssessmentSituation;
    }

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}
