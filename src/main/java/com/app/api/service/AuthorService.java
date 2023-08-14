package com.app.api.service;

import com.app.api.common.Response;
import com.app.api.entity.Author;
import com.app.api.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Response<Page<Author>> getAuthors(Pageable pageable){
        Response<Page<Author>> response = new Response<>();
        response.setData(authorRepository.findAll(pageable));
        response.setStatus(HttpStatus.OK.value());
        return response;
    }
}
