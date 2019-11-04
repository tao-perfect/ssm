package com.zking.ssm.model;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
@ToString
public class BookFile implements Serializable{
    private String fileId;

    private String realName;

    private String contentType;

    private Date createdate;

    public BookFile(String fileId, String realName, String contentType, Date createdate) {
        this.fileId = fileId;
        this.realName = realName;
        this.contentType = contentType;
        this.createdate = createdate;
    }

    public BookFile() {
        super();
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}