package com.springFrameworkExercise1.springFrameworkExercise1.Questions_3_4_5_6;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class AdventureStories implements Books {
    private String author;
    private String title;

    public void setBook(String author, String title) {
        setAuthor(author);
        setTitle(title);
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

}
