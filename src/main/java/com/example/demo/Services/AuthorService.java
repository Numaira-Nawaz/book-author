package com.example.demo.Services;

import com.example.demo.Entities.Author;
import com.example.demo.Entities.BookEntity;
import com.example.demo.Repository.AuthorRepo;
import com.example.demo.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AuthorService {

    @Autowired
    AuthorRepo authorRepo;
    @Autowired
    BookRepo bookRepo;
    public Author insertAuthor(Author author){

        return authorRepo.save(author);
    }
    //insertAuthorByExistingBook
    public String insertAuthorByBkId(Author author,Long bid){
        authorRepo.save(author);
        authorRepo.setAuthoorBookId(author.getId(),bid);
        return "Inserted";
    }

    public List<Author> AuthorByNoOfPublicationGreaterThanEqual(Integer noOfPublication){
        return authorRepo.findByNoOfPublicationGreaterThanEqual(noOfPublication);
    }
    public List<Author> findAuthorById( Long id){
        System.out.println("hello");
        return authorRepo.findByid(id);
    }
    public Page<Author> getAllAuthor(int pageSize,int pageNumber) {
        Pageable p = PageRequest.of(pageNumber, pageSize);
        return authorRepo.findAll(p);
    }
    public void delete(Long id){
        Author a = authorRepo.findById(id).get();
        authorRepo.delete(a);
    }
    /*List<ResponseDTO> getAuthorAndItsBooks(@PathVariable Long id) {
        return authorService.AuthorAndItsBooks(id);
    }*/
}
