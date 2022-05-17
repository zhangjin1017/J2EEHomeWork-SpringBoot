package com.zj.middle_book.service.impl;

import com.zj.middle_book.entity.Book;
import com.zj.middle_book.mapper.BookMapper;
import com.zj.middle_book.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;
    @Override
    public List<Book> findAllBooks() {
        return bookMapper.findAllBooks();
    }

    @Override
    public List<Book> findBooksLikeName(String name) {
        return bookMapper.findBooksLikeName(name);
    }

    @Override
    public List<Book> findBooksLikeNameByPage(String name, int currentPage, int pageSize) {
        return bookMapper.findBooksLikeNameByPage(name,(currentPage-1)*pageSize,pageSize);
    }

    @Override
    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookMapper.deleteBook(id);
    }

    @Override
    public List<Book> findBooksByPage(int currentPage, int pageSize) {
        return bookMapper.findBooksByPage((currentPage-1)*pageSize,pageSize);
    }

    @Override
    public int getBooksTotal() {
        return bookMapper.getBooksTotal();
    }
}
