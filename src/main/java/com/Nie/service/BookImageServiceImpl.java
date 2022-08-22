package com.Nie.service;

import com.Nie.dao.BookImageMapper;
import com.Nie.dao.BookImageMapperImpl;
import com.Nie.pojo.BookImage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookImageServiceImpl implements BookImageService {

    @Resource
    private BookImageMapper bookImageMapperImpl;

    @Override
    public BookImage selectByBookImageId(Integer bookImageId) {
        return bookImageMapperImpl.selectByBookImageId(bookImageId);
    }

    @Override
    public BookImage selectByBookId(Integer bookId) {

        return bookImageMapperImpl.selectByBookId(bookId);
    }

    @Override
    public int insertByBookImage(BookImage bookImage) {
        return bookImageMapperImpl.insertByBookImage(bookImage);
    }

    @Override
    public int deleteByBookImageId(Integer bookImageId) {
        return bookImageMapperImpl.deleteByBookImageId(bookImageId);
    }

    @Override
    public int updateByBookImage(BookImage bookImage) {
        return bookImageMapperImpl.updateByBookImage(bookImage);
    }
}
