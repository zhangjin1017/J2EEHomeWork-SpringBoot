package com.zj.middle_book.service;

import com.zj.middle_book.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    // 查询所有图书
    List<Book> findAllBooks();
    //按照书名模糊查询
    List<Book> findBooksLikeName(String name);
    //模糊分页查询
    List<Book> findBooksLikeNameByPage(@Param("name") String name, @Param("start") int start, @Param("end") int end);
    //添加图书
    void addBook(Book book);
    //修改图书
    void updateBook(Book book);
    //删除图书
    void deleteBook(Integer id);
    //分页查询
    List<Book> findBooksByPage(int currentPage, int pageSize);
    //获取总数
    int getBooksTotal();
}
