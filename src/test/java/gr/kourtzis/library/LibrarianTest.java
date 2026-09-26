package gr.kourtzis.library;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import gr.kourtzis.extension.LibrarianResolver;

@ExtendWith(LibrarianResolver.class)
public class LibrarianTest {
    @Test 
    @DisplayName("Check that librarian id is 4004L")
    void checkIdIs4004(Librarian librarian) {
        long id = librarian.getId();

        Assertions.assertThat(id).isEqualTo(4004L);
    }

    @Test 
    @DisplayName("Check that the name is John Dio")
    void checkNameIsJohnDio(Librarian librarian) {
        String name = librarian.getName();

        Assertions.assertThat(name).isEqualTo("John Dio");
    }

    @Test 
    @DisplayName("Check that employee number is 222335L")
    void checkEmployeeNumberIs222335L(Librarian librarian) {
        long employeeNumber = librarian.getEmployeeNumber();

        Assertions.assertThat(employeeNumber).isEqualTo(222335L);
    }
}
