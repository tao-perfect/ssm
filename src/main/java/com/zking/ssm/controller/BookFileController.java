package com.zking.ssm.controller;

import com.zking.ssm.model.Book;
import com.zking.ssm.model.BookFile;
import com.zking.ssm.service.IBookFileService;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.vo.BookFileVo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("/bookFile")
public class BookFileController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBookFileService bookFileService;
    private final  String DEFAULT_PATH="/uploads";
    @RequestMapping("/upload")
    public String upload(HttpServletRequest request, BookFileVo bookFileVo){
        /*
        * 1.保存图片信息 t_book_file
        * 2.根据书本ID修改书本信息
        * 3.将文件保存到指定位置
        * */
        MultipartFile bookFile=bookFileVo.getBookFile();
        System.out.println(bookFile.getContentType());
        System.out.println(bookFile.getOriginalFilename());
        String fileId= UUID.randomUUID().toString().replace("-","");
        Book book=new Book();
        book.setId(bookFileVo.getId());
        book.setBookimage(fileId);

        bookFileVo.setFileId(fileId);
        bookFileVo.setContentType(bookFile.getContentType());
        bookFileVo.setRealName(bookFile.getOriginalFilename());

        bookService.updateBookImage(book,bookFileVo);
//        上传文件
        String relativePath=DEFAULT_PATH+ File.separator+bookFile.getOriginalFilename();
        String realPath=request.getServletContext().getRealPath(relativePath);

        try {
            bookFile.transferTo(new File(realPath));
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/book/queryBookPager";
    }
    @RequestMapping(value="/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam String fileId){
    try {
        //先根据文件id查询对应图片信息
        BookFile bookFile=bookFileService.selectByPrimaryKey(fileId);

        //下载关键代码
        String relativePath=DEFAULT_PATH+ File.separator+bookFile.getRealName();
        String realPath=request.getServletContext().getRealPath(relativePath);
        File file=new File(realPath);
        HttpHeaders headers = new HttpHeaders();//http头信息
        String downloadFileName = new String(bookFile.getRealName().getBytes("UTF-8"),"iso-8859-1");//设置编码
        headers.setContentDispositionFormData("attachment", downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //MediaType:互联网媒介类型  contentType：具体请求中的媒体类型信息
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
    }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
