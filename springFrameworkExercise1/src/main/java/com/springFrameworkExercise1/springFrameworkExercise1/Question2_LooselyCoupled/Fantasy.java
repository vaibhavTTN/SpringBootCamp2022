package com.springFrameworkExercise1.springFrameworkExercise1.Question2_LooselyCoupled;

public class Fantasy implements Books{
    private String author;
    private String title;

    public Fantasy(String author, String title) {
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
