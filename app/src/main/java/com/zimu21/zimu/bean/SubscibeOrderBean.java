package com.zimu21.zimu.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/11.
 */

public class SubscibeOrderBean implements Serializable{
    private int id;
    private String teacherIcon;
    private String teacherName;

    public String getTeacherContent() {
        return teacherContent;
    }

    public void setTeacherContent(String teacherContent) {
        this.teacherContent = teacherContent;
    }

    public String getBabyReason() {
        return babyReason;
    }

    public void setBabyReason(String babyReason) {
        this.babyReason = babyReason;
    }

    public String getRefeshTime() {
        return refeshTime;
    }

    public void setRefeshTime(String refeshTime) {
        this.refeshTime = refeshTime;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherIcon() {
        return teacherIcon;
    }

    public void setTeacherIcon(String teacherIcon) {
        this.teacherIcon = teacherIcon;
    }

    private String teacherContent;
    private String refeshTime;
    private String babyReason;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





}
