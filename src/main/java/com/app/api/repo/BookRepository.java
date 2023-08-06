package com.app.api.repo;

import com.app.api.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {

    String rawQuery = "SELECT * FROM book where year_of_publication IN :yop";

    List<Book> findAllByYearOfPublicationInAndBookType(Set<Integer> yearOfPublication, String bookType);

    @Query(nativeQuery = true, value = rawQuery)
    List<Book> findAllByYearOfPublicationIn(@Param(value = "yop") Set<Integer> year);
}
