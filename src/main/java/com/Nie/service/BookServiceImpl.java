package com.Nie.service;

import com.Nie.constant.Constant;
import com.Nie.dao.BookMapper;
import com.Nie.pojo.Book;
import com.Nie.pojo.BookCondition;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    @Qualifier("bookMapperImpl")
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public Book selectById(int id) {
        return bookMapper.selectById(id);
    }

    public List<Book> selectAll(BookCondition bookCondition) {
        return bookMapper.selectAll(bookCondition);
    }

    public int insertByBook(Book book) {
        return bookMapper.insertByBook(book);
    }

    public int deleteById(int id) {
        return bookMapper.deleteById(id);
    }

    public int updateById(Book book) {
        return bookMapper.updateById(book);
    }

    public Book selectByName(String name) {
        return bookMapper.selectByName(name);
    }

    public PageInfo<Book> selectPage(BookCondition bookCondition,Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum, Constant.pageSize);
        //查询所有
        List<Book> books = bookMapper.selectAll(bookCondition);
        //获取分页相关数据
        PageInfo<Book> pageInfo = new PageInfo<Book>(books,5);
        return pageInfo;
    }
}
