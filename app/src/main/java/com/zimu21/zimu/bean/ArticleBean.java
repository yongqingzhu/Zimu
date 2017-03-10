package com.zimu21.zimu.bean;

/**
 * Created by Administrator on 2017/3/8.
 */

public class ArticleBean {
    private String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    private String content;
    private String num;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
