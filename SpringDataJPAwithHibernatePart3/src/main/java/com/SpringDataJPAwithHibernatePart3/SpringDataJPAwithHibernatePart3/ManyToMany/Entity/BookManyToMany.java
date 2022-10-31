package com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.ManyToMany.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BookManyToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bookName;

    @ManyToMany
    @JoinTable(
            name = "authorManyToMany_bookManyToMany",
            joinColumns = @JoinColumn(name = "authorId",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "bookId",referencedColumnName = "id")
    )
    private Set<AuthorManyToMany> authorManyToMany;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<AuthorManyToMany> getAuthorManyToMany() {
        return authorManyToMany;
    }

    public void setAuthorManyToMany(Set<AuthorManyToMany> authorManyToMany) {
        this.authorManyToMany = authorManyToMany;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

}
