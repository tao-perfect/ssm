package com.zking.ssm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@ToString
public class Book {
    // 书本验证分组
    public static interface ValidateGroups {
        // 新增/修改
        public static interface Add {
        }
        // x修改/删除
        public static interface Edit {
        }
    }
//    @JsonIgnore是忽略这个字段
//    @JsonIgnore
    @NotNull(message = "书本编号不能为空",groups = {ValidateGroups.Edit.class})
    private Integer id;
    //格式化字段
    @JsonProperty(value = "bname")
    @NotBlank(message = "书本名称不能为空！",groups ={ValidateGroups.Edit.class,ValidateGroups.Add.class})
    private String bookname;
    @NotNull(message = "书本价格不能为空！",groups = ValidateGroups.Add.class)
    @Range(min = 50,max = 100,message = "价格必须在50到100！")
    private Float price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdate;

    private String booktype;

    private String bookimage;

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Book(Integer id, String bookname, Float price, String booktype, String bookimage) {
        this.id = id;
        this.bookname = bookname;
        this.price = price;
        this.booktype = booktype;
        this.bookimage = bookimage;
    }

    public Book() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    public String getBookimage() {
        return bookimage;
    }

    public void setBookimage(String bookimage) {
        this.bookimage = bookimage;
    }
}