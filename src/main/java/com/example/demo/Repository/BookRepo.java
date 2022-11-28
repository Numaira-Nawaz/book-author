package com.example.demo.Repository;

import com.example.demo.Entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepo extends JpaRepository<BookEntity,Long> {
            List<BookEntity> findByPriceGreaterThanEqual(double price);
}
