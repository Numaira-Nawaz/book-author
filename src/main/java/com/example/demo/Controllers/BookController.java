package com.example.demo.Controllers;

import com.example.demo.Entities.Author;
import com.example.demo.Entities.BookEntity;
import com.example.demo.Repository.AuthorRepo;
import com.example.demo.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired

    BookRepo bookRepo;
    @PostMapping(value = "/book")
    public String insertBook(@RequestBody BookEntity book){

        bookRepo.save(book);
        return "Book added Successfully!";
    }

    @PostMapping("multiplebooks")
    public String insertMulBooks(@RequestBody List<BookEntity> book){
        bookRepo.saveAll(book);
        return book.size()+" books added";
    }
    @GetMapping("/searchbyid{price}")
    public List<BookEntity> SearchBookById(@PathVariable double price){
        return bookRepo.findByPriceGreaterThanEqual(price);
    }

    /*public String hello(@RequestParam(value = "title") String title, @RequestParam(value="date_of_publication") int date_of_publication,
                        @RequestParam(value = "price") double price,Author author){

        //b1.setAuthor(author);
        b1.setTitle(title);
        b1.setDate_of_publication(date_of_publication);
        b1.setPrice(price);
        //b1.setAuthor(author);
       String bookDetail = b1.toString();
       return bookDetail;
    }
*/
}
