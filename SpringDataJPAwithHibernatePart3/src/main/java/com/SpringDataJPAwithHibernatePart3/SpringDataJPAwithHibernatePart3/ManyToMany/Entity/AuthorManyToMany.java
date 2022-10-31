package com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.ManyToMany.Entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class AuthorManyToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String authorName;
    @Embedded
    private AddressManyToMany addressManyToMany;

    @ManyToMany(mappedBy = "authorManyToMany",cascade = CascadeType.ALL)
    @Size(min = 3)
    private Set<SubjectManyToMany> subjectManyToMany;

    @ManyToMany(mappedBy = "authorManyToMany",cascade = CascadeType.ALL)
    private Set<BookManyToMany> bookManyToMany;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public AddressManyToMany getAddressManyToMany() {
        return addressManyToMany;
    }

    public void setAddressManyToMany(AddressManyToMany addressManyToMany) {
        this.addressManyToMany = addressManyToMany;
    }

    public Set<SubjectManyToMany> getSubjectManyToMany() {
        return subjectManyToMany;
    }

    public void setSubjectManyToMany(Set<SubjectManyToMany> subjectManyToMany) {
        this.subjectManyToMany = subjectManyToMany;
    }

    public Set<BookManyToMany> getBookManyToMany() {
        return bookManyToMany;
    }

    public void setBookManyToMany(Set<BookManyToMany> bookManyToMany) {
        this.bookManyToMany = bookManyToMany;
    }

    public AddressManyToMany getAddress() {
        return addressManyToMany;
    }

    public void setAddress(AddressManyToMany addressManyToMany) {
        this.addressManyToMany = addressManyToMany;
    }


}
