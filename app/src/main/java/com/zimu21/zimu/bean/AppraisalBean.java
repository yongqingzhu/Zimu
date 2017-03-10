package com.zimu21.zimu.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/9.
 */

public class AppraisalBean implements Serializable {
    private int id;
    private String name;
    private String content;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    private String url;
    private String num;

}
