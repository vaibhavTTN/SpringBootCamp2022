package com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.Unidirectional.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SubjectOneToManyUniDirectional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String subjectName;

    @ManyToMany
    @JoinTable(
            name = "SubjectOneToManyUniDirectional_AuthorOneToManyUniDirectional",
            joinColumns = @JoinColumn(
                    name = "subjectId",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                name = "authorId",
                referencedColumnName = "id"
            )
    )
    private Set<AuthorOneToManyUniDirectional> authorOneToManyUniDirectional;

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

    public Set<AuthorOneToManyUniDirectional> getAuthorOneToManyUniDirectional() {
        return authorOneToManyUniDirectional;
    }

    public void setAuthorOneToManyUniDirectional(Set<AuthorOneToManyUniDirectional> authorOneToManyUniDirectional) {
        this.authorOneToManyUniDirectional = authorOneToManyUniDirectional;
    }
}
