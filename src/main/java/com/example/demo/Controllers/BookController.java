package com.example.demo.Controllers;

import com.example.demo.Entities.BookEntity;
import com.example.demo.Services.BookService;
import com.example.demo.dto.AuthorRequest;
import com.example.demo.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping(value = "/book")
    public String inset(@RequestBody BookEntity book){
       return bookService.insertBook(book);

    }

    @PostMapping("multiplebooks")
    public String insertMultiple(@RequestBody List<BookEntity> books){
        bookService.insertMulBooks(books);
        return books.size()+ " Books are added";
    }
    @GetMapping("/searchbyandauthors/{id}")
    public ResponseDTO searchByID(@PathVariable Long id){
        return  bookService.getBookAuthor(id);

    }
    @GetMapping("/searchbypricegreaterthanequal{price}")
    public List<BookEntity> searchByPrice(@PathVariable double price){
        List<BookEntity> books = bookService.SearchBookByPrice(price);
        return books;
    }
    @PostMapping("/bookauthor")
    public BookEntity addBook(@RequestBody AuthorRequest book){
        return bookService.insertBookAndAuthor(book);
    }
    @GetMapping("/findAllBookAuthor")
    public List<BookEntity> findAllBookAuthor(){
        return bookService.getAllBookAuthor();
    }
    @GetMapping("/allauthorbybookid/{id}")
    ResponseDTO AuthorAndItsBooks(@PathVariable Long id) {
        return bookService.getBookAuthor(id);
    }
    @GetMapping("/allbooksname")
    public List<String> getAllBookTitle(){
        return bookService.getAllBookName();
    }
    @PutMapping("/updatebookname/{id}")
    public BookEntity updateBookName(@PathVariable Long id,@RequestParam String title){
        BookEntity book = bookService.findBookById(id);
        book.setTitle(title);
        bookService.updateBook(book);
        return book;
    }
    @PutMapping("/updatebooksaleprice/{id}")
    public BookEntity updateBookSalePrice(@PathVariable Long id,@RequestParam Double salePrice){
        BookEntity book = bookService.findBookById(id);
        if (salePrice<= book.getPrice()) {
            book.setSalePrice(salePrice);
            bookService.updateBook(book);
            System.out.println("sale price updated successfully!");
        }else{
            System.out.println("sale price must be less than price.");
        }
        return book;
    }
    @GetMapping("/findbookbyid/{id}")
    public BookEntity findBook(@PathVariable Long id){
        return bookService.findBookById(id);
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
