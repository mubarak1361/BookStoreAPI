package com.app.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDTO {
    private Long id;
    private String name;
    private String gender;
}
