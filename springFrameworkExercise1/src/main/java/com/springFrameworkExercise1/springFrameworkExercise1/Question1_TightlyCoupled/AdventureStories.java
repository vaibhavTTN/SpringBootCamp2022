package com.springFrameworkExercise1.springFrameworkExercise1.Question1_TightlyCoupled;

public class AdventureStories {
    private String author;
    private String title;

    public AdventureStories(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}
