package com.example.demo.Services;

import com.example.demo.Entities.Author;
import com.example.demo.Repository.AuthorRepo;
import com.example.demo.dto.AuthorDTO;
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
    @Autowired
    AuthorRepo authorRepo;
    public String insertBook(BookEntity book){
        String msg;
        if (book.getSalePrice()<=book.getPrice()) {
            bookRepo.save(book);
                msg = "Book inserted";
        }else{
                msg = "Sale price must be less than or equal to price";
        }
        return  msg;
    }

    public String insertBookByAuthorId(BookEntity book,Long id){
        String msg;
        if (book.getSalePrice()<=book.getPrice()) {
            List<Author> al = new ArrayList<>();
            al.add(authorRepo.getReferenceById(id));
            book.setAuthors(al);
            bookRepo.save(book);
            msg = "Book inserted";
        }else{
            msg = "Sale price must be less than or equal to price";
        }
        return  msg;
    }
    public void insertMulBooks(List<BookEntity> book){
        bookRepo.saveAll(book);
    }
    public List<BookEntity> SearchBookByPrice(double price){
        return bookRepo.findByPriceGreaterThanEqual(price);
    }
    public BookEntity findBookById(Long id){
       return bookRepo.findById(id).get();
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
    public BookEntity updateBook(BookEntity book){
        return bookRepo.save(book);
    }



    public List<String> getAllBookName(){
        return bookRepo.getBookByTitle();
    }

}
