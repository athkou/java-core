package gr.kourtzis.library;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import gr.kourtzis.extension.BookResolver;

@ExtendWith(BookResolver.class)
public class BookTest {
    @Test 
    @DisplayName("Checking if Effective Java book has the right title, author and isbn")
    void checkBook(Book book) {
        String expectedTitle = "Effective Java";
        String expectedAuthor = "Joshua Bloch";
        String expectedIsbn = "978-0134686042";

        book.setTitle("Effective Java");
        book.setAuthor("Joshua Bloch");
        book.setIsbn("978-0134686042");

        String actualTitle = book.getTitle();
        String actualAuthor = book.getAuthor();
        String actualIsbn = book.getIsbn();

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualTitle).isEqualTo(expectedTitle);
            softly.assertThat(actualAuthor).isEqualTo(expectedAuthor);
            softly.assertThat(actualIsbn).isEqualTo(expectedIsbn);
        });
    }
}
