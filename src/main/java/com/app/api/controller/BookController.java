package com.app.api.controller;

import com.app.api.entity.Book;
import com.app.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books")
    public List<Book> getBooks(@RequestParam(value = "yearOfPublication", required = false) Set<Integer> year, @RequestParam(value = "bookType", required = false) String bookType){
        return bookService.getBooks(year,bookType);
    }

    @PostMapping(value = "/books")
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @GetMapping(value = "/books/{id}")
    public Book getBookById(@PathVariable("id") Integer bookId){
        return bookService.getBookById(bookId);
    }

    @PutMapping(value = "/books")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping(value = "/books/{bookId}")
    public String deleteBookById(@PathVariable Integer bookId){
        return bookService.deleteBookById(bookId);
    }

    @GetMapping(value = "/raw/books")
    public List<Book> getBooksByRawQuery(@RequestParam(value = "yearOfPublication") Set<Integer> year){
        return bookService.getBooksByRawQuery(year);
    }
}
