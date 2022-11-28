package com.example.demo.Controllers;

import com.example.demo.Entities.Author;
import com.example.demo.Entities.BookEntity;
import com.example.demo.Repository.AuthorRepo;
import com.example.demo.Repository.BookRepo;
import com.example.demo.dto.AuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class AuthorController {
   @Autowired
    AuthorRepo authorRepo;
   @Autowired
    BookRepo bookRepo;
   @PostMapping("/bookauthor")
   public BookEntity addBook(@RequestBody AuthorRequest book){
       return bookRepo.save(book.getBook());
   }
    public List<BookEntity> findAllBookAuthor(){
       return bookRepo.findAll();
    }

   @PostMapping("/author")
   public Author addAuthor(@RequestBody Author author){

       return authorRepo.save(author);

   }

//    @GetMapping("/getauthor")
//    public List<Author> getAuthor(){
//       return authorRepo.findAllNative();
//    }
    @GetMapping("/getauthorbybid/{noOfPublication}")
    public List<Author> getAuthorByNoOfPublicationGreaterThanEqual( @PathVariable  Integer noOfPublication){
        System.out.println("hello");
        return authorRepo.findByNoOfPublicationGreaterThanEqual(noOfPublication);
    }
    @GetMapping("/getauthorbyid/{id}")
    public List<Author> getAuthorById( @PathVariable  Long id){
        System.out.println("hello");
        return authorRepo.findByid(id);
    }
    @GetMapping("/getAllAuthor/{pageSize}/{pageNumber}")
    public Page<Author> getAllAuthor(@PathVariable int pageSize,@PathVariable int pageNumber){

        Pageable p = PageRequest.of(pageNumber,pageSize);
        return authorRepo.findAll(p);
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
