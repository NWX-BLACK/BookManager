package com.Nie.dao;

import com.Nie.pojo.Book;
import com.Nie.pojo.BookCondition;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookMapper {
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
}
