package gr.kourtzis.library;

public class Member {
    private long id;
    private String name;
    private int borrowedBooks;

    public Member(long id, final String name) {
        this.id = id;
        this.name = name;
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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
