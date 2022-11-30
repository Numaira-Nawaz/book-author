package com.example.demo.Services;

import com.example.demo.dto.AuthorDTO;
import com.example.demo.Entities.Author;
import com.example.demo.Entities.BookEntity;
import com.example.demo.Repository.BookRepo;
import com.example.demo.dto.AuthorRequest;
import com.example.demo.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;
    public void insertBook(BookEntity book){
        bookRepo.save(book);
    }
    public void insertMulBooks(List<BookEntity> book){
        bookRepo.saveAll(book);
    }
    public List<BookEntity> SearchBookByPrice(double price){
        return bookRepo.findByPriceGreaterThanEqual(price);
    }

    public ResponseDTO getBookAuthor(Long id){
       BookEntity book =  bookRepo.findBookEntityByIdAndAuthors(id);
       List<AuthorDTO> authors = new ArrayList<>();
       book.getAuthors().forEach(author ->authors.add(new AuthorDTO(author.getName(),author.getAge(),author.getNoOfPublication())) );
//        for (Author author:book.getAuthors()) {
//            authors.add(new AuthorDTO(author.getName(),author.getAge(),author.getNoOfPublication()));
//        }
        ResponseDTO bookresponse = new ResponseDTO(book.getTitle(),book.getDateOfPublication(),authors,book.getPrice());
        return bookresponse;
    }

    public BookEntity insertBookAndAuthor(AuthorRequest book){
        return bookRepo.save(book.getBook());
    }
    public List<BookEntity> getAllBookAuthor(){
        return bookRepo.findAll();
    }
//    public List<ResponseDTO> getAuthorAndItsBooks(Long id) {
//        return bookRepo.getAuthorAndBooks(id);
//    }

}
