package com.zking.ssm.model;

import lombok.ToString;

import java.io.Serializable;
@ToString
public class BookType implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookType() {
    }

    public BookType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
