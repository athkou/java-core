package gr.kourtzis.library;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import gr.kourtzis.extension.MemberResolver;

@ExtendWith(MemberResolver.class)
public class MemberTest {
    @Test 
    @DisplayName("Checks if the member id is equal to 1001")
    void checkMemberIdResultsThousandOne(Member member) {
        long expectedId = 1001;

        long actualId = member.getId();

        Assertions.assertThat(actualId).isEqualTo(expectedId);
    }

    @Test 
    @DisplayName("Checks if the member name is john")
    void checkMemberNameIsJohn(Member member) {
        String expectedName = "Homer Simson";

        String actualName = member.getName();

        Assertions.assertThat(actualName).isEqualTo(expectedName);
    }

    @Test 
    @DisplayName("Checks that the number of borrowed books is two")
    void borrowedBooksAreTwo(Member member) {
        member.borrowBook();
        member.borrowBook();

        Assertions.assertThat(member.getBorrowedBooks()).isEqualTo(2);
    }

    @Test 
    @DisplayName("Throws Exception when id is equal to 0")
    void throwExceptionWhenIdIsZero() {
        String errorMessage = "id can't be a negative number!";

        Assertions.assertThatThrownBy(() -> {
            new Member(0, "John");
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(errorMessage);
    }

    @Test 
    @DisplayName("Throws Exceptin when id is lower than 0") 
    void throwExceptionWhenIdIsLowerThanZero() {
        String errorMessage = "id can't be a negative number!";

        Assertions.assertThatThrownBy(() -> {
            new Member(-3, "John");
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(errorMessage);
    }

    @Test 
    @DisplayName("Throws Exception when name is null")
    void throwExceptionWhenNameIsNull() {
        String errorMessage = "name can't be null or blank!";

        Assertions.assertThatThrownBy(() -> {
            new Member(3L, null);
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(errorMessage);
    }

    @Test 
    @DisplayName("Throws Exception when name is blank")
    void throwExceptionWhenNameIsBlank() {
        String errorMessage = "name can't be null or blank!";

        Assertions.assertThatThrownBy(() -> {
            new Member(3L, "");
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(errorMessage);
    }

    @Test 
    @DisplayName("Check that after one initialization of a Member object the counter is 1")
    void checkBookCounterIsOne() {
        int counterBefore = Member.getMemberCounter();
        new Member(1L, "12345");
        int counterAfter = Member.getMemberCounter();

        Assertions.assertThat(counterAfter).isEqualTo(counterBefore + 1);
    }

    @Test 
    @DisplayName("Check that after one houndred initializations of Member objects the counter is 100")
    void checkBookCounterIsOneHoundred() {
        int counterBefore = Member.getMemberCounter();
        for(int i = 0; i < 100; ++i) {
            new Member(i + 3, "a");
        }
        int counterAfter = Member.getMemberCounter();
        
        Assertions.assertThat(counterAfter).isEqualTo(counterBefore + 100);
    }
}
