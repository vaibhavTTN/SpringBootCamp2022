package com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToOne;

import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.ManyToMany.Entity.AddressManyToMany;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.ManyToMany.Entity.AuthorManyToMany;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.ManyToMany.Entity.BookManyToMany;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.ManyToMany.Entity.SubjectManyToMany;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToOne.Entity.AddressOneToOne;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToOne.Entity.AuthorOneToOne;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToOne.Entity.BookOneToOne;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToOne.Entity.SubjectOneToOne;
import com.SpringDataJPAwithHibernatePart3.SpringDataJPAwithHibernatePart3.OneToOne.Repositroy.AuthorOneToOneRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class OneToOneTest {

    @Autowired
    AuthorOneToOneRepository authorOneToOneRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void createAuthorOneToOneTest(){
        AuthorOneToOne author = new AuthorOneToOne();
        Set<AuthorOneToOne> authorlist = new HashSet<>();
        author.setAuthorName("vaibhav");
        authorlist.add(author);

        AddressOneToOne address = new AddressOneToOne();
        address.setStreetNumber(142);
        address.setLocation("Kanpur");
        address.setState("U.P");

        author.setAddressOneToOne(address);

        Set<SubjectOneToOne> subjectList = new HashSet<>();
        SubjectOneToOne subject1 = new SubjectOneToOne();
        subject1.setSubjectName("English language or literature");
        subject1.setAuthor(authorlist);

        SubjectOneToOne subject2 = new SubjectOneToOne();
        subject2.setSubjectName("creative writing");
        subject2.setAuthor(authorlist);

        SubjectOneToOne subject3 = new SubjectOneToOne();
        subject3.setSubjectName("communication and media");
        subject3.setAuthor(authorlist);

        subjectList.add(subject1);
        subjectList.add(subject2);
        subjectList.add(subject3);

        author.setSubjectOneToOne(subjectList);

        BookOneToOne book = new BookOneToOne();
        book.setBookName("A.O.T");
        book.setAuthorOneToOne(author);

        author.setBookOneToOne(book);

        authorOneToOneRepository.save(author);
    }

    @Test
    @Transactional
    public void getAuthorDetails(){
        AuthorOneToOne author = authorOneToOneRepository.findById(18).get();
        System.out.println(author.getAuthorName());

        AddressOneToOne address = author.getAddressOneToOne();
        System.out.println(address.getStreetNumber());
        System.out.println(address.getLocation());
        System.out.println(address.getState());

        Set<SubjectOneToOne> subject = author.getSubjectOneToOne();
        subject.forEach(e-> System.out.println(e.getSubjectName()));

        BookOneToOne book = author.getBookOneToOne();
        System.out.println(book.getBookName());
    }
}
