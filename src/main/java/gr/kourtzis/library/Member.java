package gr.kourtzis.library;

public class Member {
    private long id;
    private String name;
    private int borrowedBooks;

    public Member(long id, final String name) {
        checkId(id);
        checkName(name);
        
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

    private void checkId(long id) {
        if(id <= 0) {
            throw new IllegalArgumentException("id can't be a negative number!");
        }
    }

    private void checkName(final String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("name can't be null or blank!");
        }
    }
}
