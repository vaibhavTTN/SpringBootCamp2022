package com.springFrameworkExercise1.springFrameworkExercise1.Questions_3_4_5_6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Library {

    @Autowired
    Books book;

    public Library(Books book) {
        this.book = book;
    }

    public void printBookDetails(){
        System.out.println("Title Name :: "+this.book.getTitle());
        System.out.println("Author Name :: "+this.book.getAuthor()+"\n");
    }
    
}

/*
    OUTPUT

    Title Name :: Gulliver's Travels
    Author Name :: Jonathan Swift

    Title Name :: Next in Line
    Author Name :: William Warwick

    Title Name :: The Great Gatsby
    Author Name :: F. Scott Fitzgerald

    Title Name :: Lord of the Rings
    Author Name :: J. R. R. Tolkien

 */