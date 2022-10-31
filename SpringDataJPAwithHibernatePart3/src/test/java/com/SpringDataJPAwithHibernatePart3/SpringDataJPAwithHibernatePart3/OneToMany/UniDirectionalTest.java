package com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany;

import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.Unidirectional.Entity.AddressOneToManyUniDirectional;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.Unidirectional.Entity.AuthorOneToManyUniDirectional;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.Unidirectional.Entity.BookOneToManyUniDirectional;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.Unidirectional.Entity.SubjectOneToManyUniDirectional;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.Unidirectional.Repository.AuthorOneToManyUniDirectionalRepository;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.Unidirectional.Repository.BookOneToManyUniDirectionalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class UniDirectionalTest {

    @Test
    void contextLoads() {
    }

    @Autowired
    AuthorOneToManyUniDirectionalRepository authorOneToManyUniDirectionalRepository;

    @Autowired
    BookOneToManyUniDirectionalRepository bookOneToManyUniDirectionalRepository;

    @Test
    public void createOneToManyUniDirectionalTest(){
        AuthorOneToManyUniDirectional author = new AuthorOneToManyUniDirectional();
        author.setAuthorName("vaibhav");

        AddressOneToManyUniDirectional address = new AddressOneToManyUniDirectional();

        address.setStreetNumber(142);
        address.setLocation("Kanpur");
        address.setState("U.P");

        author.setAddressOneToManyUniDirectional(address);

        Set<AuthorOneToManyUniDirectional> authorlist = new HashSet<>();
        authorlist.add(author);

        Set<BookOneToManyUniDirectional> bookList = new HashSet<>();
        BookOneToManyUniDirectional book = new BookOneToManyUniDirectional();
        book.setBookName("A.O.T");
        bookList.add(book);

        author.setBookOneToManyUniDirectional(bookList);

        Set<SubjectOneToManyUniDirectional> subjectList = new HashSet<>();
        SubjectOneToManyUniDirectional subject1 = new SubjectOneToManyUniDirectional();
        subject1.setSubjectName("English language or literature");
        subject1.setAuthorOneToManyUniDirectional(authorlist);

        SubjectOneToManyUniDirectional subject2 = new SubjectOneToManyUniDirectional();
        subject2.setSubjectName("creative writing");
        subject2.setAuthorOneToManyUniDirectional(authorlist);

        SubjectOneToManyUniDirectional subject3 = new SubjectOneToManyUniDirectional();
        subject3.setSubjectName("communication and media");
        subject3.setAuthorOneToManyUniDirectional(authorlist);

        subjectList.add(subject1);
        subjectList.add(subject2);
        subjectList.add(subject3);

        author.setSubjectOneToManyUniDirectional(subjectList);

        authorOneToManyUniDirectionalRepository.save(author);
    }

    @Test
    @Transactional
    public void getAuthorOneToManyUniDirectional(){
        AuthorOneToManyUniDirectional author = authorOneToManyUniDirectionalRepository.findById(1).get();
        System.out.println(author.getAuthorName());

        AddressOneToManyUniDirectional address = author.getAddressOneToManyUniDirectional();
        System.out.println(address.getStreetNumber());
        System.out.println(address.getLocation());
        System.out.println(address.getState());

        Set<SubjectOneToManyUniDirectional> subject = author.getSubjectOneToManyUniDirectional();
        subject.forEach(e-> System.out.println(e.getSubjectName()));

        Set<SubjectOneToManyUniDirectional> book = author.getSubjectOneToManyUniDirectional();
        book.forEach(e-> System.out.println(e.getSubjectName()));
    }

    @Test
    public void getBookOneToManyUniDirectional(){
        BookOneToManyUniDirectional book = bookOneToManyUniDirectionalRepository.findById(1).get();
        System.out.println(book.getBookName());
    }

}
