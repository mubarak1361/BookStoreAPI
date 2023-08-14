package com.app.api.controller;

import com.app.api.common.Response;
import com.app.api.entity.Author;
import com.app.api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    private Response<Page<Author>> getAuthors(Pageable pageable){
        return authorService.getAuthors(pageable);
    }
}
