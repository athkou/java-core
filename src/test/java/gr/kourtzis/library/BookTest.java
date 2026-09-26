package gr.kourtzis.library;

import java.util.Objects;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import gr.kourtzis.extension.BookResolver;

@ExtendWith(BookResolver.class)
public class BookTest {
    @Test 
    @DisplayName("Checks that a new book is available")
    void newBookIsAvailable() {
        Book ocp = new Book(
            "Oracle Certified Professional Java SE 21 Developer", 
            "Jeanne Boyarsky,Scott Selikoff", 
            "978-1-394-28661-4");
        
        Assertions.assertThat(ocp.isAvailable()).isTrue();
    }
    @Test 
    @DisplayName("Checking if Effective Java book has the right title")
    void checkTitleToBeEffectiveJava(Book book) {
        String expectedTitle = "Effective Java";
        
        String actualTitle = book.getTitle();
       
        Assertions.assertThat(actualTitle).isEqualTo(expectedTitle);

    }

    @Test 
    @DisplayName("Checking the author of Effective Java is Joshua Bloch")
    void checkAuthorToBeJoshuaBloch(Book book) {
        String expectedAuthor = "Joshua Bloch";

        String actualAuthor = book.getAuthor();

        Assertions.assertThat(actualAuthor).isEqualTo(expectedAuthor);
    }

    @Test 
    @DisplayName("Check the isbn of Effective Java to be 978-0134686042")
    void checkCorrectIsbnOfEffectiveJava(Book book) {
        String expectedIsbn = "978-0134686042";

        String actualIsbn = book.getIsbn();

        Assertions.assertThat(actualIsbn).isEqualTo(expectedIsbn);
    } 

    @Test 
    @DisplayName("Book is not available")
    void bookIsNotAvailable(Book book) {
        book.borrow();

        Assertions.assertThat(book.isAvailable()).isFalse();
    }

    @Test 
    @DisplayName("Book is after return again available")
    void bookIsAvailable(Book book) {
        book.borrow();
        book.returnBook();

        Assertions.assertThat(book.isAvailable()).isTrue();
    }

    @Test
    @DisplayName("Checks that the constructor throws an IllegalArgumentException when title is null") 
    void throwExceptionWhenTitleIsNull() {
        final String errorMessage = "Argument can't be null or blank!";

		Assertions.assertThatThrownBy(() -> {
			new Book(null, "test", "test");
		})
		.isInstanceOf(IllegalArgumentException.class)
		.hasMessage(errorMessage);
    }

    @Test
    @DisplayName("Checks that the constructor throws an IllegalArgumentException when title is blank") 
    void throwExceptionWhenTitleIsBlank() {
        final String errorMessage = "Argument can't be null or blank!";

		Assertions.assertThatThrownBy(() -> {
			new Book("", "test", "test");
		})
		.isInstanceOf(IllegalArgumentException.class)
		.hasMessage(errorMessage);
    }

    @Test
    @DisplayName("Checks that the constructor throws an IllegalArgumentException when Author is null") 
    void throwExceptionWhenAuthorIsNull() {
        final String errorMessage = "Argument can't be null or blank!";

		Assertions.assertThatThrownBy(() -> {
			new Book("test", null, "test");
		})
		.isInstanceOf(IllegalArgumentException.class)
		.hasMessage(errorMessage);
    }

    @Test
    @DisplayName("Checks that the constructor throws an IllegalArgumentException when Author is blank") 
    void throwExceptionWhenAuthorIsBlank() {
        final String errorMessage = "Argument can't be null or blank!";

		Assertions.assertThatThrownBy(() -> {
			new Book("test", "", "test");
		})
		.isInstanceOf(IllegalArgumentException.class)
		.hasMessage(errorMessage);
    }

    @Test
    @DisplayName("Checks that the constructor throws an IllegalArgumentException when Isbn is null") 
    void throwExceptionWhenIsbnIsNull() {
        final String errorMessage = "Argument can't be null or blank!";

		Assertions.assertThatThrownBy(() -> {
			new Book("test", "test", null);
		})
		.isInstanceOf(IllegalArgumentException.class)
		.hasMessage(errorMessage);
    }

    @Test
    @DisplayName("Checks that the constructor throws an IllegalArgumentException when Isbn is blank") 
    void throwExceptionWhenIsbnIsBlank() {
        final String errorMessage = "Argument can't be null or blank!";

		Assertions.assertThatThrownBy(() -> {
			new Book("test", "test", "");
		})
		.isInstanceOf(IllegalArgumentException.class)
		.hasMessage(errorMessage);
    }

    @Test 
    @DisplayName("Check that two books with same isbn are equal")
    void twoBooksWithSameIsbnAreEqual() {
        Book book1 = new Book("a", "b", "123");
        Book book2 = new Book("b", "c", "123");

        boolean result = Objects.equals(book1, book2);

        Assertions.assertThat(result).isTrue();
    }

    @Test 
    @DisplayName("Check that two books with different isbn are not equal")
    void twoBooksWithDifferentIsbnAreNotEqual() {
        Book book1 = new Book("a", "b", "123");
        Book book2 = new Book("b", "c", "12gg3");

        boolean result = Objects.equals(book1, book2);

        Assertions.assertThat(result).isFalse();
    }

    @Test 
    @DisplayName("Check that two books with same isbn have the same hashcode")
    void booksWithSameIsbnHaveSameHashCode() {
        Book book1 = new Book("a", "b", "123");
        Book book2 = new Book("b", "c", "123");

        int hash1 = book1.hashCode();
        int hash2 = book2.hashCode();

        boolean result = Objects.equals(hash1, hash2);

        Assertions.assertThat(result).isTrue();
    }

    @Test 
    @DisplayName("Check that after one initialization of an book object the counter is 1")
    void checkBookCounterIsOne() {
        int counterBefore = Book.getBookCounter();
        new Book("ab", "bc", "12345");
        int counterAfter = Book.getBookCounter();

        Assertions.assertThat(counterAfter).isEqualTo(counterBefore + 1);
    }

    @Test 
    @DisplayName("Check that after one houndred initializations of book objects the counter is 100")
    void checkBookCounterIsOneHoundred() {
        int counterBefore = Book.getBookCounter();
        for(int i = 0; i < 100; ++i) {
            new Book("a", "b", "123" + i);
        }
        int counterAfter = Book.getBookCounter();
        
        Assertions.assertThat(counterAfter).isEqualTo(counterBefore + 100);
    }
}
