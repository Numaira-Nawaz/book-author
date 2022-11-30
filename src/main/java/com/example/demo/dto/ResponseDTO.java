package com.example.demo.dto;

import com.example.demo.Entities.Author;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor

@ToString
public class ResponseDTO {
    private Long id;
    private String title;
    private List<Author> authors;

    public ResponseDTO(Long id, String title, List<Author> authors) {
        this.id = id;
        this.title = title;
        this.authors = authors;
    }
}
