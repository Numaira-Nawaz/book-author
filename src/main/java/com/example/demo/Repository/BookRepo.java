package com.example.demo.Repository;

import com.example.demo.Entities.BookEntity;
import com.example.demo.dto.ResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepo extends JpaRepository<BookEntity,Long> {
    List<BookEntity> findByPriceGreaterThanEqual(double price);

    @Query(value = "Select * from book b join author a ON a.book_id=b.id where b.id=:id",nativeQuery = true)
    BookEntity findBookEntityByIdAndAuthors(@Param("id") Long id);
    /*@Query(value = "Select new com.example.demo.dto.ResponseDTO(b.title,b.date_of_publication,b.authors,b.price,a.name,a.age,a.noOfPublication)" +
            " from BookEntity b join Author a  where b.id=:id")
    List<BookEntity> getAuthorAndBooks(@Param("id") Long id);*/
}
