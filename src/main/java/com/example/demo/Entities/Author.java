package com.example.demo.Entities;
import javax.persistence.*;
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    @Column
    private String name;
    @Column
    private int age;
    @Column(name = "no_of_publication")
    private int noOfPublication;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNo_of_publication() {
        return noOfPublication;
    }

    public void setNo_of_publication(int no_of_publication) {
        this.noOfPublication = no_of_publication;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", no_of_publication=" + noOfPublication+
                '}';
    }
}
