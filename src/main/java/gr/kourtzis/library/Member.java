package gr.kourtzis.library;

import lombok.Getter;

@Getter 
public class Member extends LibraryUser implements Notifiable {
    private static int memberCounter;
    
    private int borrowedBooks;

    public Member(long id, final String name) {
        super(id, name);

        ++memberCounter;
    }

    @Override 
    public void notifyUser(final String message) {
        System.out.println("Member notified: " + message);
    }

    @Override
    public String getDescription() {
        return "Member";
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
