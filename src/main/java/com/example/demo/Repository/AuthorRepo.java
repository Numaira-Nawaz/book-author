package com.example.demo.Repository;

import com.example.demo.Entities.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
    /* @Query( value = "SELECT * from author where no_of_publication>1",nativeQuery = true )
     public List<Author> findAllNative();*/
    List<Author> findByNoOfPublicationGreaterThanEqual(Integer noOfPublication);
    List<Author> findByid(Long id);
    Page<Author> findAll(Pageable pageable);
   /*@Query(value = "select new com.example.demo.dto.ResponseDTO(b.title,a.name,a.noOfPublication) from BookEntity b join b.authors a where b.id=:id")

    List<ResponseDTO> getAuthorAndBooks(@Param("id") Long id);*/

}


