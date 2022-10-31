package com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.ManyToMany.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SubjectManyToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String subjectName;

    @ManyToMany
    @JoinTable(
            name = "SubjectManyToMany_AuthorManyToMany",
            joinColumns = @JoinColumn(
                    name = "subjectId",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                name = "authorId",
                referencedColumnName = "id"
            )
    )
    private Set<AuthorManyToMany> authorManyToMany;

    public Set<AuthorManyToMany> getAuthor() {
        return authorManyToMany;
    }

    public Set<AuthorManyToMany> getAuthorManyToMany() {
        return authorManyToMany;
    }

    public void setAuthorManyToMany(Set<AuthorManyToMany> authorManyToMany) {
        this.authorManyToMany = authorManyToMany;
    }

    public void setAuthor(Set<AuthorManyToMany> authorManyToMany) {
        this.authorManyToMany = authorManyToMany;
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
