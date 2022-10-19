package com.springFrameworkExercise1.springFrameworkExercise1;

import com.springFrameworkExercise1.springFrameworkExercise1.Questions_3_4_5_6.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.swing.*;

@SpringBootApplication
public class SpringFrameworkExercise1Application {

	public static void main(String[] args) {


		/*
			Question 3 :: Use @Component and @Autowired annotations to in Loosely Coupled code for
						  dependency management
		*/
/*
		Books fantasy = new Fantasy("J. R. R. Tolkien","Lord of the Rings");

		Books classics = new Classics("F. Scott Fitzgerald","The Great Gatsby");

		Books crime = new Crime("William Warwick","Next in Line");

		Books adventureStories = new AdventureStories("Jonathan Swift","Gulliver's Travels");

		Library libraryFantasyBook = new Library(fantasy);

		Library libraryClassicsBook = new Library(classics);

		Library libraryAdventureStoriesBook = new Library(adventureStories);

		Library libraryCrimeBook = new Library(crime);

		libraryFantasyBook.printBookDetails();
		libraryClassicsBook.printBookDetails();
		libraryCrimeBook.printBookDetails();
		libraryAdventureStoriesBook.printBookDetails();
*/

/*
	Question 4 :: Get a Spring Bean from application context and display its properties.
	Question 5 :: Demonstrate how you will resolve ambiguity while autowiring bean (Hint : @Primary)
	Question 6 ::  Perform Constructor Injection in a Spring Bean
*/
		ApplicationContext context = SpringApplication.run(SpringFrameworkExercise1Application.class, args);

		Books crime = context.getBean(Crime.class);
		Books fantasy = context.getBean(Fantasy.class);
		Books classics = context.getBean(Classics.class);
		Books adventureStories = context.getBean(AdventureStories.class);

/*
		This @Primary is being used in Fantasy Component
 */
		crime.setBook("William Warwick","Next in Line");
		fantasy.setBook("J. R. R. Tolkien","Lord of the Rings");
		classics.setBook("F. Scott Fitzgerald","The Great Gatsby");
		adventureStories.setBook("Jonathan Swift","Gulliver's Travels");

/*
     Library class is initialized by Constructor
 */
 		Library libraryCrimeBook = context.getBean(Library.class,crime);
		libraryCrimeBook.printBookDetails();
		System.out.println(libraryCrimeBook);

		Library libraryClassicBook = context.getBean(Library.class,classics);
		libraryClassicBook.printBookDetails();
		System.out.println(libraryClassicBook);


		Library libraryFantasyBook = context.getBean(Library.class,fantasy);
		libraryFantasyBook.printBookDetails();
		System.out.println(libraryFantasyBook);

		Library libraryAdventureBook = context.getBean(Library.class,adventureStories);
		libraryAdventureBook.printBookDetails();
		System.out.println(libraryAdventureBook);


	}

}
