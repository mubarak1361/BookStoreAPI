package com.app.api.service;

import com.app.api.dto.AuthorDTO;
import com.app.api.dto.BookDTO;
import com.app.api.entity.Book;
import com.app.api.entity.BookAuthor;
import com.app.api.repo.BookAuthorRepository;
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

    @Autowired
    private BookAuthorRepository bookAuthorRepository;

    public List<Book> getBooks(Set<Long> year, String bookType){
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

    public BookDTO getBookById(Long bookId, boolean authorData){
        BookDTO bookDTO = null;
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isPresent()){
            bookDTO = new BookDTO();
            bookDTO.setId(book.get().getId());
            bookDTO.setName(book.get().getName());
            bookDTO.setDescription(book.get().getDescription());
            bookDTO.setBookType(book.get().getBookType());
            bookDTO.setYearOfPublication(book.get().getYearOfPublication());
            if(authorData){
                List<BookAuthor> bookAuthors = bookAuthorRepository.findAllByBookId(bookId);
                List<AuthorDTO> authorDTOS = new ArrayList<>();
                for (BookAuthor author: bookAuthors){
                    AuthorDTO authorDTO = new AuthorDTO();
                    authorDTO.setId(author.getAuthor().getId());
                    authorDTO.setName(author.getAuthor().getName());
                    authorDTO.setGender(author.getAuthor().getGender());
                    authorDTOS.add(authorDTO);
                }
                bookDTO.setAuthors(authorDTOS);
            }
        }
        return bookDTO;
    }

    public Book updateBook(Book book){
        return bookRepository.save(book);
    }

    public String deleteBookById(Long bookId){
        bookRepository.deleteById(bookId);
        return "Deleted Successfully";
    }

    public List<Book> getBooksByRawQuery(Set<Long> year) {
        return bookRepository.findAllByYearOfPublicationIn(year);
    }
}
