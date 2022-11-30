package com.example.demo.Controllers;

import com.example.demo.Entities.Author;
import com.example.demo.Entities.BookEntity;
import com.example.demo.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/author")
    public Author addAuthor(@RequestBody Author author){
        return authorService.insertAuthor(author);
    }

    @GetMapping("/getauthorbynoofpubgreater/{noOfPublication}")
    public List<Author> getAuthorByNoOfPublicationGreaterThanEqual( @PathVariable  Integer noOfPublication){
        return authorService.AuthorByNoOfPublicationGreaterThanEqual(noOfPublication);
    }
    @GetMapping("/getauthorbyid/{id}")
    public List<Author> getAuthorById(@PathVariable  Long id){
        return authorService.findAuthorById(id);
    }
    @GetMapping("/getAllAuthor/{pageSize}/{pageNumber}")
    public Page<Author> getAllAuthorPagination(@PathVariable int pageSize,@PathVariable int pageNumber) {
        return authorService.getAllAuthor(pageSize,pageNumber);
    }

    /*@PostMapping(value = "/author")

    public String AddAuthor(@RequestParam(value = "name") String name, @RequestParam(value="age") int age,
                        @RequestParam(value = "no_of_publication") int no_of_publication){
        b1.setName(name);
        b1.setNo_of_publication(no_of_publication);
        b1.setAge(age);
        String authorDetail = b1.toString();
        return authorDetail;
    }*/
}
