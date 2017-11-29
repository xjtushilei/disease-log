package com.xjtushilei.diseaselog.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Evaluate {
    @Id
    @GeneratedValue
    private Long id;

    private String sessionId;

    private String note;

    private String name;


    public Evaluate() {
    }

    public Evaluate( String sessionId, String note, String name) {
        this.sessionId = sessionId;
        this.note = note;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
