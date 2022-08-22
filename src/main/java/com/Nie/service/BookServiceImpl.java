package com.Nie.service;

import com.Nie.constant.Constant;
import com.Nie.dao.BookMapper;
import com.Nie.pojo.Book;
import com.Nie.pojo.BookCondition;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    @Qualifier("bookMapperImpl")
    private BookMapper bookMapper;

    @Resource
    private RedisTemplate<String,Book> redisTemplate;

    private String booksKey = null;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public Book selectById(int id) {
        return bookMapper.selectById(id);
    }

    public List<Book> selectAll(BookCondition bookCondition) {
        String[] bookskeys = new String[]{"Books:","category_","price_","bookName_"};
        String booksKeyTmp = "";

        if(!(bookCondition.getCategory() == null || bookCondition.getCategory() == "")){
            bookskeys[1] = "category_" + bookCondition.getCategory()+":";
        }
        if(!(bookCondition.getMinprice() == null || bookCondition.getMinprice().equals(""))
                && !(bookCondition.getMaxprice() == null || bookCondition.getMaxprice().equals(""))
                && (bookCondition.getMaxprice()<bookCondition.getMaxprice())){

            bookskeys[2] = "price_"+bookCondition.getMinprice()+"-"+bookCondition.getMaxprice()+":";
        }
        if(!(bookCondition.getName() == null || bookCondition.getName().equals(""))){
            bookskeys[3] = "bookName_"+bookCondition.getName();
        }
        for (String str:bookskeys) {
            booksKeyTmp += str;
        }
        System.out.println(booksKeyTmp);
        this.booksKey = booksKeyTmp;

        ListOperations listOperations = redisTemplate.opsForList();

        List<Book> booksByRedis = listOperations.range(booksKeyTmp,0,-1);
        if(booksByRedis.size()<1){
            List<Book> booksByMysql = bookMapper.selectAll(bookCondition);
            listOperations.rightPushAll(booksKeyTmp,booksByMysql);
            return booksByMysql;
        }
        return booksByRedis;
    }

    public int insertByBook(Book book) {

//        redisTemplate.delete(this.booksKey);
        return bookMapper.insertByBook(book);
    }

    public int deleteById(int id) {

//        redisTemplate.delete(this.booksKey);
        return bookMapper.deleteById(id);
    }

    public int updateById(Book book) {
//        System.out.println(this.booksKey);
//        redisTemplate.delete(this.booksKey);
        return bookMapper.updateById(book);
    }

    public Book selectByName(String name) {
        return bookMapper.selectByName(name);
    }

    public PageInfo<Book> selectPage(BookCondition bookCondition,Integer pageNum) {
        String[] bookskeys = new String[]{"Books:","category_","price_","bookName_"};
        String booksKeyTmp = "";

        if(bookCondition != null){
            if(!(bookCondition.getCategory() == null || bookCondition.getCategory() == "")){
                bookskeys[1] = "category_" + bookCondition.getCategory()+":";
            }
            if(!(bookCondition.getMinprice() == null || bookCondition.getMinprice().equals(""))
                    && !(bookCondition.getMaxprice() == null || bookCondition.getMaxprice().equals(""))
                    && (bookCondition.getMaxprice()<bookCondition.getMaxprice())){

                bookskeys[2] = "price_"+bookCondition.getMinprice()+"-"+bookCondition.getMaxprice()+":";
            }
            if(!(bookCondition.getName() == null || bookCondition.getName().equals(""))){
                bookskeys[3] = "bookName_"+bookCondition.getName();
            }
        }
        for (String str:bookskeys) {
            booksKeyTmp += str;
        }
//        System.out.println(booksKeyTmp);
        this.booksKey = booksKeyTmp;

        //开启分页功能
        PageHelper.startPage(pageNum, Constant.pageSize);
        //查询所有
/*        ListOperations listOperations = redisTemplate.opsForList();
        List<Book> books = listOperations.range(booksKeyTmp,0,-1);
//        System.out.println(books);
        if(books.size()<1){
            books = bookMapper.selectAll(bookCondition);
            System.out.println(books);
            listOperations.rightPushAll(booksKeyTmp,books);
        }*/
        List<Book> books = bookMapper.selectAll(bookCondition);
        //获取分页相关数据
        PageInfo<Book> pageInfo = new PageInfo<Book>(books,5);
        return pageInfo;

    }
}
