package com.zking.ssm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NewsCateGory implements Serializable{
    private Integer id;

    private Integer nid;

    private Integer cid;

    private List<News> newsList=new ArrayList<>();
    public NewsCateGory(Integer id, Integer nid, Integer cid) {
        this.id = id;
        this.nid = nid;
        this.cid = cid;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public NewsCateGory() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}