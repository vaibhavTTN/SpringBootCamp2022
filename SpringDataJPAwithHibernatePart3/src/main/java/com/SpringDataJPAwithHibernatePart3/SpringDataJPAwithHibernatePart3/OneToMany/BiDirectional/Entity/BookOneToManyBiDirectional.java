package com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.BiDirectional.Entity;

import javax.persistence.*;

@Entity
public class BookOneToManyBiDirectional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private AuthorOneToManyBiDirectional authorOneToManyBiDirectional;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public AuthorOneToManyBiDirectional getAuthorOneToManyBiDirectional() {
        return authorOneToManyBiDirectional;
    }

    public void setAuthorOneToManyBiDirectional(AuthorOneToManyBiDirectional authorOneToManyBiDirectional) {
        this.authorOneToManyBiDirectional = authorOneToManyBiDirectional;
    }
}
