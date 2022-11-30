package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class ResponseDTO {
    //Book Attributes
    private String title;
    private int dateOfPublication;
    private double price;

    //Author's Attribute
    private List<AuthorDTO> authors;

    public ResponseDTO(String title, int dateOfPublication,List<AuthorDTO> authors, double price) {
        this.title = title;
        this.dateOfPublication = dateOfPublication;
        this.authors = authors;
        this.price = price;
    }
}
