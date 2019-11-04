package com.zking.ssm.model;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class Resouce implements Serializable{
    private Integer id;

    private String key;

    private String val;

    private Integer sortnum;

    private Integer status;

    public Resouce(Integer id, String key, String val, Integer sortnum, Integer status) {
        this.id = id;
        this.key = key;
        this.val = val;
        this.sortnum = sortnum;
        this.status = status;
    }

    public Resouce() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public Integer getSortnum() {
        return sortnum;
    }

    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}