package gr.kourtzis.library;

import lombok.Getter;

@Getter 
public class Librarian extends LibraryUser {
    private long employeeNumber;

    public Librarian(long id, final String name, long employeeNumber) {
        super(id, name);
        this.employeeNumber = employeeNumber;
    }
}
