package gr.kourtzis.library;

public class LibraryApplication {
    public static void main(String[] args) {
        Book cleanCode = new Book();
        cleanCode.setTitle("Clean Code");
        cleanCode.setAuthor("Robert Martin");
        cleanCode.setIsbn("978-0135398579");
        cleanCode.printInfo();

        Book effectiveJava = new Book();
        effectiveJava.setTitle("Effective Java");
        effectiveJava.setAuthor("Joshua Bloch");
        effectiveJava.setIsbn("978-0134686042");
        effectiveJava.printInfo();
    }
}
