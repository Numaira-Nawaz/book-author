package com.example.demo.dto;

import com.example.demo.Entities.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthorRequest {
    private BookEntity book;
}
