package com.zking.ssm.service;

import com.zking.ssm.model.BookFile;
import org.springframework.stereotype.Repository;


public interface IBookFileService {
//    查询根据图片ID查询图片
    BookFile selectByPrimaryKey(String fileId);
}