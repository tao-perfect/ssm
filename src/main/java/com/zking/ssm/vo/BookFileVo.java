package com.zking.ssm.vo;

import com.zking.ssm.model.BookFile;
import org.springframework.web.multipart.MultipartFile;

public class BookFileVo extends BookFile {
    private Integer id;//书本编号
    private MultipartFile bookFile; //书本图片

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MultipartFile getBookFile() {
        return bookFile;
    }

    public void setBookFile(MultipartFile bookFile) {
        this.bookFile = bookFile;
    }
}
