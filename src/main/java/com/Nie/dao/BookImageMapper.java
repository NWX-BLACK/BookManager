package com.Nie.dao;

import com.Nie.pojo.Book;
import com.Nie.pojo.BookImage;
import org.apache.ibatis.annotations.Param;

public interface BookImageMapper {

     //通过自身的ID查
     BookImage selectByBookImageId(Integer bookImageId);

     //通过bookId查
     BookImage selectByBookId(Integer bookId);

     //增加一个bookImage
     int insertByBookImage(@Param("bookImage") BookImage bookImage);

     //通过id删除一个bookImage
     int deleteByBookImageId(Integer bookImageId);

     //修改一个bookImage
     int  updateByBookImage(@Param("bookImage")  BookImage bookImage);
}
