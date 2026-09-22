package gr.kourtzis.library;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import gr.kourtzis.extension.BookResolver;

@ExtendWith(BookResolver.class)
public class BookTest {
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
}
