package com.app.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookDTO {
    private Long id;
    private String name;
    private String description;
    private Integer yearOfPublication;
    private String bookType;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private List<AuthorDTO> authors;
}
