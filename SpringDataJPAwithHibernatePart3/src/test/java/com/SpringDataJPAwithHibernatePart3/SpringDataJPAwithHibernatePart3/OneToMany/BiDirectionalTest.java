package com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany;

import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.BiDirectional.Entity.AddressOneToManyBiDirectional;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.BiDirectional.Entity.AuthorOneToManyBiDirectional;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.BiDirectional.Entity.BookOneToManyBiDirectional;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.BiDirectional.Entity.SubjectOneToManyBiDirectional;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.BiDirectional.Repository.AuthorOneToManyBiDirectionalRepository;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToOne.Entity.AuthorOneToOne;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class BiDirectionalTest {
    @Test
    void contextLoads() {
    }

    @Autowired
    AuthorOneToManyBiDirectionalRepository authorOneToManyBiDirectionalRepository;

    @Test
    public void createOneToManyBIDirectionalTest(){
        AuthorOneToManyBiDirectional author = new AuthorOneToManyBiDirectional();
        author.setAuthorName("vaibhav");

        AddressOneToManyBiDirectional address = new AddressOneToManyBiDirectional();

        address.setStreetNumber(142);
        address.setLocation("Kanpur");
        address.setState("U.P");

        author.setAddressOneToManyBiDirectional(address);

        Set<AuthorOneToManyBiDirectional> authorlist = new HashSet<>();
        authorlist.add(author);
        BookOneToManyBiDirectional book = new BookOneToManyBiDirectional();
        book.setBookName("A.O.T");

        author.addAuthor(book);

        Set<SubjectOneToManyBiDirectional> subjectList = new HashSet<>();
        SubjectOneToManyBiDirectional subject1 = new SubjectOneToManyBiDirectional();
        subject1.setSubjectName("English language or literature");
        subject1.setAuthorOneToManyBiDirectional(authorlist);

        SubjectOneToManyBiDirectional subject2 = new SubjectOneToManyBiDirectional();
        subject2.setSubjectName("creative writing");
        subject2.setAuthorOneToManyBiDirectional(authorlist);

        SubjectOneToManyBiDirectional subject3 = new SubjectOneToManyBiDirectional();
        subject3.setSubjectName("communication and media");

        subjectList.add(subject1);
        subjectList.add(subject2);
        subjectList.add(subject3);

        author.setSubjectOneToManyBiDirectional(subjectList);

        authorOneToManyBiDirectionalRepository.save(author);
    }

    @Test
    @Transactional
    public void getAuthorOneToManyBiDirectional(){
        AuthorOneToManyBiDirectional author = authorOneToManyBiDirectionalRepository.findById(1).get();
        System.out.println(author.getAuthorName());

        AddressOneToManyBiDirectional address = author.getAddressOneToManyBiDirectional();
        System.out.println(address.getStreetNumber());
        System.out.println(address.getLocation());
        System.out.println(address.getState());

        Set<SubjectOneToManyBiDirectional> subject = author.getSubjectOneToManyBiDirectional();
        subject.forEach(e-> System.out.println(e.getSubjectName()));

        Set<BookOneToManyBiDirectional> book = author.getBookOneToManyBiDirectional();
        book.forEach(e-> System.out.println(e.getBookName()));

    }
}
