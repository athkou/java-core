package gr.kourtzis.library;

import java.util.Objects;

public class LibraryApplication {
    public static void main(String[] args) {
        Book book1 = new Book("Clean Code", "Robert Martin", "978-0135398579");
        Book book2 = new Book("Clean Code", "Robert Martin", "978-0135398579");

        System.out.println(Objects.equals(book1, book2));
    }
}
