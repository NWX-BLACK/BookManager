package com.Nie.servlet;

import com.Nie.pojo.Book;
import com.Nie.pojo.BookCondition;
import com.Nie.pojo.BookImage;
import com.Nie.service.BookImageServiceImpl;
import com.Nie.service.BookServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class productsServlet {

    @Autowired
    private BookServiceImpl bookServiceImpl;

    @Resource
    private BookImageServiceImpl bookImageServiceImpl;

    @RequestMapping("/add")
    public String addBook(){

        return "admin/products/add";
    }

    @GetMapping("/edit")
    public String editBookById(@RequestParam("id") int id,@RequestParam("pageNum") int pageNum, Model model){
        Book book = bookServiceImpl.selectById(id);
        model.addAttribute("book",book);

        BookImage bookImage = bookImageServiceImpl.selectByBookId(id);
        String imgURL = "";
        if(bookImage != null){
            imgURL = bookImage.getImgUrl();
        }

//        System.out.println(imgURL);
        model.addAttribute("imgURL",imgURL);
        model.addAttribute("pageNum",pageNum);
        return "admin/products/edit";
    }

/*    @RequestMapping("/list")
    public String listBookAll(BookCondition bookCondition,Model model){
*//*        if(bookCondition.getName() == null || bookCondition.getName().length()<1) bookCondition.setName(null);
        if(bookCondition.getCategory() == null || bookCondition.getCategory().length()<1) bookCondition.setCategory(null);*//*

        List<Book> books = bookServiceImpl.selectAll(bookCondition);

        model.addAttribute("books",books);
        if(books == null || books.size()<1) model.addAttribute("conditionError","未查询到书籍");
        return "admin/products/list";
    }*/

    @RequestMapping("/list/page/{pageNum}")
    public String listBookPage(@PathVariable("pageNum") Integer pageNum ,HttpServletRequest request,Model model){
        BookCondition bookCondition = (BookCondition) request.getSession().getAttribute("bookCondition");

        PageInfo<Book> page = bookServiceImpl.selectPage(bookCondition,pageNum);

        model.addAttribute("page",page);
        request.setAttribute("bookc",bookCondition);
        if(page.getList() == null || page.getList().size()<1) model.addAttribute("conditionError","未查询到书籍");
        return "admin/products/list";
    }
}
