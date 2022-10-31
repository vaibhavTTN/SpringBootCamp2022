package com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToOne.Entity;

import javax.persistence.*;

@Entity
public class BookOneToOne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bookName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorId")
    private AuthorOneToOne authorOneToOne;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AuthorOneToOne getAuthorOneToOne() {
        return authorOneToOne;
    }

    public void setAuthorOneToOne(AuthorOneToOne authorOneToOne) {
        this.authorOneToOne = authorOneToOne;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public AuthorOneToOne getAuthor() {
        return authorOneToOne;
    }

    public void setAuthor(AuthorOneToOne authorOneToOne) {
        this.authorOneToOne = authorOneToOne;
    }
}
