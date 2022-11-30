package com.example.demo.Services;

import com.example.demo.Entities.Author;
import com.example.demo.Repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AuthorService {

    @Autowired
    AuthorRepo authorRepo;
    public Author insertAuthor(Author author){
        return authorRepo.save(author);
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
    /*List<ResponseDTO> getAuthorAndItsBooks(@PathVariable Long id) {
        return authorService.AuthorAndItsBooks(id);
    }*/
}
