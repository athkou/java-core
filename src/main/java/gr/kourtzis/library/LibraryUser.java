package gr.kourtzis.library;

import lombok.Getter;

@Getter 
public abstract class LibraryUser {
    private long id;
    private String name;

    public LibraryUser(long id, final String name) {
        checkId(id);
        checkName(name);

        this.id = id;
        this.name = name;
    }

    public abstract String getDescription();

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
