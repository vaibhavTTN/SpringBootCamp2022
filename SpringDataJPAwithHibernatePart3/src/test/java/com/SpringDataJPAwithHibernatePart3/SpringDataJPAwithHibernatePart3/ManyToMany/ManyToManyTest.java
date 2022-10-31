package com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.ManyToMany;

import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.ManyToMany.Entity.AddressManyToMany;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.ManyToMany.Entity.AuthorManyToMany;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.ManyToMany.Entity.BookManyToMany;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.ManyToMany.Entity.SubjectManyToMany;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.ManyToMany.Repository.AuthorManyToManyRepository;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.BiDirectional.Entity.AddressOneToManyBiDirectional;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.BiDirectional.Entity.AuthorOneToManyBiDirectional;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.BiDirectional.Entity.BookOneToManyBiDirectional;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToMany.BiDirectional.Entity.SubjectOneToManyBiDirectional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class ManyToManyTest {
    @Test
    void contextLoads() {
    }

    @Autowired
    AuthorManyToManyRepository authorManyToManyRepository;

    @Test
    public void createManyToManyAuthor(){
        AuthorManyToMany author = new AuthorManyToMany();
        Set<AuthorManyToMany> authorList = new HashSet<>();
        author.setAuthorName("vaibhav");
        authorList.add(author);

        AddressManyToMany address = new AddressManyToMany();
        address.setStreetNumber(142);
        address.setLocation("Kanpur");
        address.setState("U.P");

        author.setAddressManyToMany(address);

        Set<SubjectManyToMany> subjectList = new HashSet<>();
        SubjectManyToMany subject1 = new SubjectManyToMany();
        subject1.setSubjectName("English language or literature");
        subject1.setAuthor(authorList);

        SubjectManyToMany subject2 = new SubjectManyToMany();
        subject2.setSubjectName("creative writing");
        subject2.setAuthor(authorList);

        SubjectManyToMany subject3 = new SubjectManyToMany();
        subject3.setSubjectName("communication and media");
        subject3.setAuthor(authorList);

        subjectList.add(subject1);
        subjectList.add(subject2);
        subjectList.add(subject3);

        author.setSubjectManyToMany(subjectList);

        Set<BookManyToMany> bookList = new HashSet<>();
        BookManyToMany book = new BookManyToMany();
        book.setBookName("A.O.T");
        bookList.add(book);

        book.setAuthorManyToMany(authorList);
        author.setBookManyToMany(bookList);

        authorManyToManyRepository.save(author);
    }

    @Test
    @Transactional
    public void getauthorDetails(){
        AuthorManyToMany author = authorManyToManyRepository.findById(1).get();
        System.out.println(author.getAuthorName());

        AddressManyToMany address = author.getAddressManyToMany();
        System.out.println(address.getStreetNumber());
        System.out.println(address.getLocation());
        System.out.println(address.getState());

        Set<SubjectManyToMany> subject = author.getSubjectManyToMany();
        subject.forEach(e-> System.out.println(e.getSubjectName()));

        Set<BookManyToMany> book = author.getBookManyToMany();
        book.forEach(e-> System.out.println(e.getBookName()));
    }

}
