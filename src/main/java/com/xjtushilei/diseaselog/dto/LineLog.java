package com.xjtushilei.diseaselog.dto;

import com.xjtushilei.diseaselog.po.IntelligentInterrogationLog;

import java.text.ParseException;


public class LineLog extends IntelligentInterrogationLog {
    private long noteSum;
    private String tishi;

    public LineLog() {

    }

    public LineLog(long noteSum, IntelligentInterrogationLog log) throws ParseException {
        super(log.getSessionId(),
                log.getTime(),
                log.getStatus(),
                log.getName(),
                log.getSex(),
                log.getDob(),
                log.getCardNo(),
                log.getQuestions(),
                log.getFinalDisease(),
                log.getRecommendation(),
                log.getAllLog(),
                log.getDebug());
        this.noteSum = noteSum;
        this.tishi = "点击查看";
    }

    public String getTishi() {
        return tishi;
    }

    public void setTishi(String tishi) {
        this.tishi = tishi;
    }


    public long getNoteSum() {
        return noteSum;
    }

    public void setNoteSum(long noteSum) {
        this.noteSum = noteSum;
    }
}
