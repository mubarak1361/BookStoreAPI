package com.app.api.common;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Response<T> {
    private int Status;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private T data;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String error;
}
