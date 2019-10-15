package com.halbert.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class TreatLog implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;

    private long planId;

    private long shotId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPlanId() {
        return planId;
    }

    public void setPlanId(long planId) {
        this.planId = planId;
    }

    public long getShotId() {
        return shotId;
    }

    public void setShotId(long shotId) {
        this.shotId = shotId;
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

    @Override
    public String toString() {
        return "TreatLog{" +
                "id=" + id +
                ", planId=" + planId +
                ", shotId=" + shotId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
