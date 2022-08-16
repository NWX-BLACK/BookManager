package com.Nie.dao;

import com.Nie.pojo.Book;
import com.Nie.pojo.BookCondition;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class BookMapperImpl implements BookMapper{
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Book selectById(int id) {
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        return mapper.selectById(id);
    }

    public List<Book> selectAll(BookCondition bookCondition) {
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        return mapper.selectAll(bookCondition);
    }


    public Book selectByName(String bookName) {
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        return mapper.selectByName(bookName);
    }

    public int insertByBook(Book books) {
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        return mapper.insertByBook(books);
    }


    public int deleteById(int bookId) {
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        return mapper.deleteById(bookId);
    }


    public int updateById(Book books) {
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        return mapper.updateById(books);
    }

}
