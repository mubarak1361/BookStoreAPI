package com.app.api.repo;

import com.app.api.entity.Author;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends PagingAndSortingRepository<Author,Long> {
}
