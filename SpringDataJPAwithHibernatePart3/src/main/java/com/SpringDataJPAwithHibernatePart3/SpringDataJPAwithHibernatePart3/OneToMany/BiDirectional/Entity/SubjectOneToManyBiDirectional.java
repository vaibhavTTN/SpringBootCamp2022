package com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.BiDirectional.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SubjectOneToManyBiDirectional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String subjectName;

    @ManyToMany
    @JoinTable(
            name = "SubjectOneToManyBiDirectional_AuthorOneToManyBiDirectional",
            joinColumns = @JoinColumn(
                    name = "subjectId",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                name = "authorId",
                referencedColumnName = "id"
            )
    )
    private Set<AuthorOneToManyBiDirectional> authorOneToManyBiDirectional;

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

    public Set<AuthorOneToManyBiDirectional> getAuthorOneToManyBiDirectional() {
        return authorOneToManyBiDirectional;
    }

    public void setAuthorOneToManyBiDirectional(Set<AuthorOneToManyBiDirectional> authorOneToManyBiDirectional) {
        this.authorOneToManyBiDirectional = authorOneToManyBiDirectional;
    }
}
