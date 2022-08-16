package com.Nie.servlet;

import com.Nie.pojo.Book;

import com.Nie.pojo.BookCondition;
import com.Nie.service.BookServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/servlet")
public class crudServlet {
    @Autowired
    private BookServiceImpl bookServiceImpl;

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
        return "forward:/products/list/page/1";
    }

    @RequestMapping("/editBookServlet")
    public String editBookServlet(Book book,@RequestParam("pageNum") Integer pageNum){
//        System.out.println(pageNum);
        bookServiceImpl.updateById(book);
        return "redirect:/products/list/page/"+pageNum;
    }
}
