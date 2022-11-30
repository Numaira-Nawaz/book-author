package com.example.demo.Entities;

import lombok.*;
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
    @Column(name = "date_of_publication")
    private int dateOfPublication;
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
                ", dateOfPublication=" + dateOfPublication +
                ", price=" + price +
                ", authors=" + authors +
                '}';
    }
}
