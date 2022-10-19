package com.springFrameworkExercise1.springFrameworkExercise1.Question2_LooselyCoupled;

public class Classics implements Books {
    private String author;
    private String title;

    public Classics(String author, String title) {
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
