package com.springFrameworkExercise1.springFrameworkExercise1.Question1_TightlyCoupled;

public class Library {

    public static void main(String[] args) {

        // Tightly Coupled
        AdventureStories adventureStories = new AdventureStories("Jonathan Swift","Gulliver's Travels");
        // Tightly Coupled
        Classics classics = new Classics("F. Scott Fitzgerald","The Great Gatsby");
        // Tightly Coupled
        Crime crime = new Crime("William Warwick","Next in Line");
        // Tightly Coupled
        Fantasy fantasy = new Fantasy("J. R. R. Tolkien","Lord of the Rings");

        printDetailsAdventureStories(adventureStories);
        printDetailsCrime(crime);
        printDetailsClassics(classics);
        printDetailsFantasy(fantasy);
    }

    public static void printDetailsAdventureStories(AdventureStories adventureStories){
        System.out.println("Title Name :: "+adventureStories.getTitle());
        System.out.println("Author Name :: "+adventureStories.getAuthor()+"\n");
    }

    public static void printDetailsCrime(Crime crime){
        System.out.println("Title Name :: "+crime.getTitle());
        System.out.println("Author Name :: "+crime.getAuthor()+"\n");
    }

    public static void printDetailsClassics(Classics classics){
        System.out.println("Title Name :: "+classics.getTitle());
        System.out.println("Author Name :: "+classics.getAuthor()+"\n");
    }

    public static void printDetailsFantasy(Fantasy fantasy){
        System.out.println("Title Name :: "+fantasy.getTitle());
        System.out.println("Author Name :: "+fantasy.getAuthor()+"\n");
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