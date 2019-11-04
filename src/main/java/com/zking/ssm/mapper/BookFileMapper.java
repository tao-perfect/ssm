package com.zking.ssm.mapper;

import com.zking.ssm.model.BookFile;
import org.springframework.stereotype.Repository;

@Repository
public interface BookFileMapper {
//    保存图片信息
    int insert(BookFile record);
//    查询根据图片ID查询图片
    BookFile selectByPrimaryKey(String fileId);

}