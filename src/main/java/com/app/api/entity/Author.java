package com.app.api.entity;

import com.app.api.serializer.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "created_at")
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date createdAt;
    @Column(name = "updated_at")
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date updatedAt;
}
