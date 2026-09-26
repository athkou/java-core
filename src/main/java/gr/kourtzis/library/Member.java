package gr.kourtzis.library;

import lombok.Getter;

@Getter 
public class Member extends LibraryUser {
    private static int memberCounter;
    
    private int borrowedBooks;

    public Member(long id, final String name) {
        super(id, name);

        ++memberCounter;
    }

    public static int getMemberCounter() {
        return memberCounter;
    }

    public void borrowBook() {
        ++borrowedBooks;
    }

    public void returnBook() {
        --borrowedBooks;
    }

    public int getBorrowedBooks() {
        return borrowedBooks;
    }
}
