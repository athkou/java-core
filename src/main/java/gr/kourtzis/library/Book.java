package gr.kourtzis.library;

public class Book {
    private String title;
    private String author;
    private String isbn;

    private boolean available;

    public Book(final String title, final String author, final String isbn) {
        checkAttribute(title);
        checkAttribute(author);
        checkAttribute(isbn);
        
        this.title = title;
        this.author = author;
        this.isbn = isbn;

        available = true;
    }

    public void borrow() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void printInfo() {
        System.out.println("Book[title='" + title + "', author='" + author + "', isbn='" + isbn + "']");
    }

    public void setTitle(String title) { 
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    private void checkAttribute(final String attribute) {
        if(attribute == null || attribute.isBlank()) {
            throw new IllegalArgumentException("Argument can't be null or blank!");
        }
    }
}
