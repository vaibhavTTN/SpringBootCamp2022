package com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToOne.Repositroy;

import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToOne.Entity.AuthorOneToOne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorOneToOneRepository extends CrudRepository<AuthorOneToOne,Integer> {
}
