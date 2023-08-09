package com.app.api.controller;

import com.app.api.common.Response;
import com.app.api.dto.BookDTO;
import com.app.api.entity.Book;
import com.app.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books")
    public List<Book> getBooks(@RequestParam(value = "yearOfPublication", required = false) Set<Long> year, @RequestParam(value = "bookType", required = false) String bookType){
        return bookService.getBooks(year,bookType);
    }

    @PostMapping(value = "/books")
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @GetMapping(value = "/books/{id}")
    public Response<BookDTO> getBookById(@PathVariable("id") Long bookId, @RequestParam(value = "authorData",required = false) boolean authorData){
        return bookService.getBookById(bookId,authorData);
    }

    @PutMapping(value = "/books")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping(value = "/books/{bookId}")
    public String deleteBookById(@PathVariable Long bookId){
        return bookService.deleteBookById(bookId);
    }

    @GetMapping(value = "/raw/books")
    public List<Book> getBooksByRawQuery(@RequestParam(value = "yearOfPublication") Set<Long> year){
        return bookService.getBooksByRawQuery(year);
    }
}
