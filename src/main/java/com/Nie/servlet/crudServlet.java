package com.Nie.servlet;

import com.Nie.Utils.UpLoadFilesUtil;
import com.Nie.pojo.Book;

import com.Nie.pojo.BookCondition;
import com.Nie.pojo.BookImage;
import com.Nie.service.BookImageServiceImpl;
import com.Nie.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;

import static com.Nie.constant.Constant.ROOT_BOOK;

@Controller
@RequestMapping("/servlet")
public class crudServlet {
    @Autowired
    private BookServiceImpl bookServiceImpl;

    @Resource
    private BookImageServiceImpl bookImageServiceImpl;

    /*
    * 数据库删除书籍
    * */
    @RequestMapping("/delete/{id}")
    public String deleteBookServlet(@PathVariable("id") int id,@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize){
        bookServiceImpl.deleteById(id);
        System.out.println(pageSize);
        if(pageSize<=1)
            return "redirect:/products/list/page/"+(pageNum-1);
        return "redirect:/products/list/page/"+pageNum;
    }

    @RequestMapping("/toAdd")
    public String addBookServlet(Book book){
        bookServiceImpl.insertByBook(book);
        return "redirect:/products/list/page/1";
    }

    /*
    * 数据库按条件查询书籍
    * */
    @RequestMapping("/findProductByManyCondition/{flag}")
    public String findProductByManyCondition(BookCondition bookCondition, HttpServletRequest request, @PathVariable("flag") boolean flag){
        HttpSession session = request.getSession();
        if(flag){
            session.setAttribute("bookCondition",bookCondition);
        }else{
            if(request.getSession().getAttribute("bookCondition") != null)
            request.getSession().removeAttribute("bookCondition");
        }
        return "redirect:/products/list/page/1";
    }

    @RequestMapping("/editBookServlet")
//    @ResponseBody
    public String editBookServlet(@RequestParam("pageNum") Integer pageNum,Book book,@RequestParam("file") MultipartFile file,HttpServletRequest request){

        if (file.isEmpty()) {
            System.out.println("图片未上传");
        } else {
            try {
                Path path = Paths.get(request.getServletContext().getRealPath(ROOT_BOOK), file.getOriginalFilename());
                File tempFile = new File(path.toString());

                //判断图片是否已存在
                if (!tempFile.exists()) {
                    //不存在，图片上传到工程目录的图片文件夹中
                    File newFile = new File("E:\\IDEA\\BookManager\\src\\main\\webapp\\static\\image\\book\\"+file.getOriginalFilename());
                    file.transferTo(tempFile);
                    file.transferTo(newFile);

//                    Files.copy(file.getInputStream(), path);
                    System.out.println("upLoad Image Success");

                }

                //把图片地址存储到bookImage表中,并和book表通过bookId关联
                BookImage bookImage = bookImageServiceImpl.selectByBookId(book.getId());

                String imgUrl = "static/image/book/"+ file.getOriginalFilename();
                if(bookImage!= null){

                    //判断之前有没有上传过，有就更新
                    if(!bookImage.getImgUrl().equals(imgUrl)){
                        bookImage.setImgUrl(imgUrl);
                        bookImageServiceImpl.updateByBookImage(bookImage);
                        System.out.println("图片已更新");
                    }
                }else{
                    //没有就增加
                    bookImage = new BookImage(null,book.getId(),imgUrl);
                    bookImageServiceImpl.insertByBookImage(bookImage);
                }

//                tempFile.delete();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        bookServiceImpl.updateById(book);
        return "redirect:/products/list/page/"+pageNum;
    }
}
