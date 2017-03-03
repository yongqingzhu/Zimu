package com.zimu21.zimu.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/1.
 */

public class ExpertSubscribe implements Serializable{

    private int id ;
    private String icon;
    private String name;
    private String grade;

    public ExpertSubscribe(String icon, String name, String grade, String myslfe, String addraee, String mun) {
        this.icon = icon;
        this.name = name;
        this.grade = grade;
        this.myslfe = myslfe;
        this.addraee = addraee;
        this.mun = mun;
    }

    private String myslfe;
    private String addraee;
    private String mun;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMyslfe() {
        return myslfe;
    }

    public void setMyslfe(String myslfe) {
        this.myslfe = myslfe;
    }

    public String getAddraee() {
        return addraee;
    }

    public void setAddraee(String addraee) {
        this.addraee = addraee;
    }

    public String getMun() {
        return mun;
    }

    public void setMun(String mun) {
        this.mun = mun;
    }



}
