package com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.BiDirectional.Repository;

import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.BiDirectional.Entity.AuthorOneToManyBiDirectional;
import org.springframework.data.repository.CrudRepository;

public interface AuthorOneToManyBiDirectionalRepository extends CrudRepository<AuthorOneToManyBiDirectional,Integer> {
}