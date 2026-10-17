package gr.kourtzis.library;

import lombok.Getter;

@Getter 
public class Librarian extends LibraryUser implements Notifiable {
    private long employeeNumber;

    public Librarian(long id, final String name, long employeeNumber) {
        super(id, name);
        this.employeeNumber = employeeNumber;
    }

    @Override 
    public String getDescription() {
        return "Librarian";
    }

    @Override 
    public void notifyUser(final String message) {
        System.out.println("Librarian notified: " + message);
    }
}
