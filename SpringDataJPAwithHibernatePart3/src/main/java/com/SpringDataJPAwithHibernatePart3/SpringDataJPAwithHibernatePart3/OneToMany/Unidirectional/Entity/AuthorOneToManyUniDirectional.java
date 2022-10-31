package com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.Unidirectional.Entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AuthorOneToManyUniDirectional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String authorName;
    @Embedded
    private AddressOneToManyUniDirectional addressOneToManyUniDirectional;

    @ManyToMany(mappedBy = "authorOneToManyUniDirectional",cascade = CascadeType.ALL)
    @Size(min = 3)
    private Set<SubjectOneToManyUniDirectional> subjectOneToManyUniDirectional;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorId")
    private Set<BookOneToManyUniDirectional> bookOneToManyUniDirectional;

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

    public AddressOneToManyUniDirectional getAddressOneToManyUniDirectional() {
        return addressOneToManyUniDirectional;
    }

    public void setAddressOneToManyUniDirectional(AddressOneToManyUniDirectional addressOneToManyUniDirectional) {
        this.addressOneToManyUniDirectional = addressOneToManyUniDirectional;
    }

    public Set<SubjectOneToManyUniDirectional> getSubjectOneToManyUniDirectional() {
        return subjectOneToManyUniDirectional;
    }

    public void setSubjectOneToManyUniDirectional(Set<SubjectOneToManyUniDirectional> subjectOneToManyUniDirectional) {
        this.subjectOneToManyUniDirectional = subjectOneToManyUniDirectional;
    }

    public Set<BookOneToManyUniDirectional> getBookOneToManyUniDirectional() {
        return bookOneToManyUniDirectional;
    }

    public void setBookOneToManyUniDirectional(Set<BookOneToManyUniDirectional> bookOneToManyUniDirectional) {
        this.bookOneToManyUniDirectional = bookOneToManyUniDirectional;
    }
}
