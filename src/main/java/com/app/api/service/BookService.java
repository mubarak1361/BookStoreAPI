package com.app.api.service;

import com.app.api.entity.Book;
import com.app.api.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks(Set<Integer> year, String bookType){
        List<Book> books = new ArrayList<>();
        if(year==null && bookType==null){
            bookRepository.findAll().forEach(books::add);
        }else{
            return bookRepository.findAllByYearOfPublicationInAndBookType(year,bookType);
        }
        return books;
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public Book getBookById(Integer bookId){
        Optional<Book> book = bookRepository.findById(bookId);
        return book.orElse(null);
    }

    public Book updateBook(Book book){
        return bookRepository.save(book);
    }

    public String deleteBookById(Integer bookId){
        bookRepository.deleteById(bookId);
        return "Deleted Successfully";
    }

    public List<Book> getBooksByRawQuery(Set<Integer> year) {
        return bookRepository.findAllByYearOfPublicationIn(year);
    }
}
