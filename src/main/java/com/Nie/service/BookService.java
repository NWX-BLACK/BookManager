package com.Nie.service;

import com.Nie.pojo.Book;
import com.Nie.pojo.BookCondition;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BookService {
    //    1. 通过id查询
    Book selectById(int id);

    //    2. 查询全部
    List<Book> selectAll(BookCondition bookCondition);

    //    3. 插入一个Book
    int insertByBook(Book book);

    //    4. 通过id删除
    int deleteById(int id);

    //    5. 通过id更新
    int updateById(Book book);

    //        通过书籍名查询
    Book selectByName(String name);


    PageInfo<Book> selectPage(BookCondition bookCondition,Integer pageNum);
}
