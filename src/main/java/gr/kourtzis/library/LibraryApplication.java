package gr.kourtzis.library;

public class LibraryApplication {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean Code", "Robert Martin", "978-0135398579");
        cleanCode.printInfo();

        Book effectiveJava = new Book("Effective Java", "Joshua Bloch", "978-0134686042");
        effectiveJava.printInfo();
    }
}
