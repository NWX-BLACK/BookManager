package com.Nie.dao;

import com.Nie.pojo.BookImage;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class BookImageMapperImpl implements BookImageMapper {

    @Resource
    private SqlSessionTemplate sqlSession;

    @Override
    public BookImage selectByBookImageId(Integer bookImageId) {
        BookImageMapper mapper = sqlSession.getMapper(BookImageMapper.class);
        return mapper.selectByBookImageId(bookImageId);
    }

    @Override
    public BookImage selectByBookId(Integer bookId) {
        BookImageMapper mapper = sqlSession.getMapper(BookImageMapper.class);
        return mapper.selectByBookId(bookId);
    }

    @Override
    public int insertByBookImage(BookImage bookImage) {
        BookImageMapper mapper = sqlSession.getMapper(BookImageMapper.class);
        return mapper.insertByBookImage(bookImage);
    }

    @Override
    public int deleteByBookImageId(Integer bookImageId) {
        BookImageMapper mapper = sqlSession.getMapper(BookImageMapper.class);
        return mapper.deleteByBookImageId(bookImageId);
    }

    @Override
    public int updateByBookImage(BookImage bookImage) {
        BookImageMapper mapper = sqlSession.getMapper(BookImageMapper.class);
        return mapper.updateByBookImage(bookImage);
    }
}
