package com.zimu21.zimu.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/8.
 */

public class RecommendBean implements Serializable{
    private int id;
    private String name;
    private String mContent;
    private String readMun;
    private String replyMun;
    private String comment;
    public String getReadMun() {
        return readMun;
    }

    public void setReadMun(String readMun) {
        this.readMun = readMun;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public String getReplyMun() {
        return replyMun;
    }

    public void setReplyMun(String replyMun) {
        this.replyMun = replyMun;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public RecommendBean() {

    }




}
