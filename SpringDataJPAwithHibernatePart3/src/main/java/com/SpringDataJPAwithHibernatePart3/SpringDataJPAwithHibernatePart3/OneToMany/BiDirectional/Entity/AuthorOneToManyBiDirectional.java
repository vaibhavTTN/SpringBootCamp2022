package com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.BiDirectional.Entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AuthorOneToManyBiDirectional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String authorName;
    @Embedded
    private AddressOneToManyBiDirectional addressOneToManyBiDirectional;

    @ManyToMany(mappedBy = "authorOneToManyBiDirectional",cascade = CascadeType.ALL)
    @Size(min = 3)
    private Set<SubjectOneToManyBiDirectional> subjectOneToManyBiDirectional;

    @OneToMany(mappedBy = "authorOneToManyBiDirectional",cascade = CascadeType.ALL)
    private Set<BookOneToManyBiDirectional> bookOneToManyBiDirectional;

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

    public AddressOneToManyBiDirectional getAddressOneToManyBiDirectional() {
        return addressOneToManyBiDirectional;
    }

    public void setAddressOneToManyBiDirectional(AddressOneToManyBiDirectional addressOneToManyBiDirectional) {
        this.addressOneToManyBiDirectional = addressOneToManyBiDirectional;
    }

    public Set<SubjectOneToManyBiDirectional> getSubjectOneToManyBiDirectional() {
        return subjectOneToManyBiDirectional;
    }

    public void setSubjectOneToManyBiDirectional(Set<SubjectOneToManyBiDirectional> subjectOneToManyBiDirectional) {
        this.subjectOneToManyBiDirectional = subjectOneToManyBiDirectional;
    }

    public Set<BookOneToManyBiDirectional> getBookOneToManyBiDirectional() {
        return bookOneToManyBiDirectional;
    }

    public void setBookOneToManyBiDirectional(Set<BookOneToManyBiDirectional> bookOneToManyBiDirectional) {
        this.bookOneToManyBiDirectional = bookOneToManyBiDirectional;
    }

    public void addAuthor(BookOneToManyBiDirectional book){
        if(book!=null){
            if(bookOneToManyBiDirectional ==null){
                bookOneToManyBiDirectional = new HashSet<>();
            }
            book.setAuthorOneToManyBiDirectional(this);
            bookOneToManyBiDirectional.add(book);
        }
    }
}
