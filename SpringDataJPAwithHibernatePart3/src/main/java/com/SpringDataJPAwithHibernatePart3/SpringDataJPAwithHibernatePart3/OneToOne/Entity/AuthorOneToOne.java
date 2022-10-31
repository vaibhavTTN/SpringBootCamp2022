package com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToOne.Entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class AuthorOneToOne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String authorName;
    @Embedded
    private AddressOneToOne addressOneToOne;

    @ManyToMany(mappedBy = "authorOneToOne",cascade = CascadeType.ALL)
    @Size(min = 3)
    private Set<SubjectOneToOne> subjectOneToOne;

    @OneToOne(mappedBy = "authorOneToOne",cascade = CascadeType.ALL)
    private BookOneToOne bookOneToOne;

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

    public BookOneToOne getBook() {
        return bookOneToOne;
    }

    public void setBook(BookOneToOne bookOneToOne) {
        this.bookOneToOne = bookOneToOne;
    }

    public AddressOneToOne getAddress() {
        return addressOneToOne;
    }

    public void setAddress(AddressOneToOne addressOneToOne) {
        this.addressOneToOne = addressOneToOne;
    }

    public AddressOneToOne getAddressOneToOne() {
        return addressOneToOne;
    }

    public void setAddressOneToOne(AddressOneToOne addressOneToOne) {
        this.addressOneToOne = addressOneToOne;
    }

    public Set<SubjectOneToOne> getSubjectOneToOne() {
        return subjectOneToOne;
    }

    public void setSubjectOneToOne(Set<SubjectOneToOne> subjectOneToOne) {
        this.subjectOneToOne = subjectOneToOne;
    }

    public BookOneToOne getBookOneToOne() {
        return bookOneToOne;
    }

    public void setBookOneToOne(BookOneToOne bookOneToOne) {
        this.bookOneToOne = bookOneToOne;
    }
}
