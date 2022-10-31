package com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToOne.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SubjectOneToOne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String subjectName;

    @ManyToMany
    @JoinTable(
            name = "SubjectOneToOne_AuthorOneToOne",
            joinColumns = @JoinColumn(
                    name = "subjectId",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                name = "authorId",
                referencedColumnName = "id"
            )
    )
    private Set<AuthorOneToOne> authorOneToOne;

    public Set<AuthorOneToOne> getAuthor() {
        return authorOneToOne;
    }

    public void setAuthor(Set<AuthorOneToOne> authorOneToOne) {
        this.authorOneToOne = authorOneToOne;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
