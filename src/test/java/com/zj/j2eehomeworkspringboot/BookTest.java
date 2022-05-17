package com.zj.j2eehomeworkspringboot;

import com.zj.middle_book.entity.Book;
import com.zj.middle_book.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class BookTest {
    @Resource
    private BookService bookService;
    @Test
    public void findAllBooksTest(){
        System.out.println(bookService.findAllBooks());
    }
    @Test
    public void findBooksLikeNameTest(){
        List<Book> books = bookService.findBooksLikeName("1");
        System.out.println(books);
    }
    @Test
    public void addBookTest(){

        //添加10条
        for (int i = 1; i <= 10; i++) {
            bookService.addBook(new Book("Java编程思想"+i,"路遥"+i,100.0,"2022-1-1","Java编程思想"+i,"Java"));
        }
    }
    @Test
    public void updateBookTest(){
        bookService.updateBook(new Book(1,"Java","路遥",11.1,"2022-1-1","Java","Java"));
    }
    @Test
    public void deleteBookTest(){
        bookService.deleteBook(10);
    }

    @Test
    public void findBooksByPageTest(){
        List<Book> books = bookService.findBooksByPage(4,3);
        for (Book book : books
             ) {
            System.out.println(book);
        }
    }
    @Test
    public void getBooksTotalTest(){
        System.out.println(bookService.getBooksTotal());
    }

}
