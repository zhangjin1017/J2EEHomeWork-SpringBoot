package com.zj.middle_book.controller;

import com.zj.middle_book.entity.Book;
import com.zj.middle_book.entity.resp.RestBean;
import com.zj.middle_book.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookService bookService;

    @GetMapping("/getBooksTotal")
    public RestBean<Integer> getBooksTotal(){
        int total = bookService.getBooksTotal();
        return new RestBean<Integer>(200,"请求成功",total);
    }

    @GetMapping("/findBooksByPage/{currentPage}/{pageSize}")
    public RestBean<List<Book>> findBooksByPage(@PathVariable("currentPage") int currentPage, @PathVariable("pageSize") int pageSize){
        try {
            List<Book> bookList = bookService.findBooksByPage(currentPage,pageSize);
            return new RestBean<List<Book>>(200,"请求成功",bookList);
        } catch (Exception e) {
            return new RestBean(500,"查询失败",e.getMessage());
        }
    }

    @GetMapping("/findAllBooks")
    public RestBean getBook() {
        try {
            List<Book> books = bookService.findAllBooks();
            return new RestBean(200,"查询成功",books);
        } catch (Exception e) {
            return new RestBean(500,"查询失败",e.getMessage());
        }
    }

    @GetMapping("/findLikeName/{name}/{currentPage}/{pageSize}")
    public RestBean findBooksLikeName(@PathVariable("name") String name, @PathVariable("currentPage") int currentPage, @PathVariable("pageSize") int pageSize){
        try {
            List<Book> books = bookService.findBooksLikeName(name);
            return new RestBean(200,"查询成功",books);
        } catch (Exception e) {
            return new RestBean(500,"查询失败",e.getMessage());
        }
    }
    @PostMapping("/addBook")
    public RestBean addBook(Book book) {
        try {
            bookService.addBook(book);
            return new RestBean(200,"添加成功");
        } catch (Exception e) {
            return new RestBean(500,"添加失败",e.getMessage());
        }
    }

    @PostMapping("/updateBook")
    public RestBean updateBook(Book book) {
        try {
            bookService.updateBook(book);
            return new RestBean(200,"修改成功");
        } catch (Exception e) {
            return new RestBean(500,"修改失败",e.getMessage());
        }
    }

    @PostMapping("/deleteBook")
    public RestBean deleteBook(Integer id) {
        try {
            bookService.deleteBook(id);
            return new RestBean(200,"删除成功");
        } catch (Exception e) {
            return new RestBean(500,"删除失败",e.getMessage());
        }
    }
}
