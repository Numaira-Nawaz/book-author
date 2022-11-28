package com.example.demo.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private int date_of_publication;
    @Column
    private double price;
    @OneToMany(targetEntity = Author.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="Book_id",referencedColumnName = "id")
    private List<Author>  authors;


    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date_of_publication=" + date_of_publication +
                ", price=" + price +
                ", authors=" + authors +
                '}';
    }
}
