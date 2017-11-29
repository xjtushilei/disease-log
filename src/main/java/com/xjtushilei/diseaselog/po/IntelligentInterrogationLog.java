package com.xjtushilei.diseaselog.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class IntelligentInterrogationLog {
    @Id
    private String sessionId;

    private Date time;
    private String status;

    private String name;
    private String sex;
    private String dob;
    private String cardNo;

    @Lob
    private String questions;
    @Lob
    private String finalDisease;
    @Lob
    private String recommendation;
    @Lob
    private String allLog;

    private Boolean debug;

    @Override
    public String toString() {
        return "IntelligentInterrogationLog{" +
                "sessionId='" + sessionId + '\'' +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", dob='" + dob + '\'' +
                ", debug=" + debug +
                '}';
    }

    public IntelligentInterrogationLog() {
    }


    public IntelligentInterrogationLog(String sessionId, String time, String status, String name, String sex, String dob, String cardNo, String questions, String finalDisease, String recommendation, String allLog, Boolean debug) throws ParseException {
        this.sessionId = sessionId;
//        "2017-11-28 14:42:21"
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.time = formatter.parse(time);
        this.status = status;
        this.name = name;
        this.sex = sex;
        this.dob = dob;
        this.cardNo = cardNo;
        this.questions = questions;
        this.finalDisease = finalDisease;
        this.recommendation = recommendation;
        this.allLog = allLog;
        this.debug = debug;
    }
    public IntelligentInterrogationLog(String sessionId, Date time, String status, String name, String sex, String dob, String cardNo, String questions, String finalDisease, String recommendation, String allLog, Boolean debug) throws ParseException {
        this.sessionId = sessionId;
//        "2017-11-28 14:42:21"
        this.time = time;
        this.status = status;
        this.name = name;
        this.sex = sex;
        this.dob = dob;
        this.cardNo = cardNo;
        this.questions = questions;
        this.finalDisease = finalDisease;
        this.recommendation = recommendation;
        this.allLog = allLog;
        this.debug = debug;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(time);
    }

    public void setTime(String time) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.time = formatter.parse(time);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getFinalDisease() {
        return finalDisease;
    }

    public void setFinalDisease(String finalDisease) {
        this.finalDisease = finalDisease;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getAllLog() {
        return allLog;
    }

    public void setAllLog(String allLog) {
        this.allLog = allLog;
    }

    public Boolean getDebug() {
        return debug;
    }

    public void setDebug(Boolean debug) {
        this.debug = debug;
    }
}
