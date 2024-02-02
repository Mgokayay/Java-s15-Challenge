package model;

import java.util.Objects;

public class  Librarian extends Person {

private String password;
    public Librarian(int id, String name,String password) {
        super(id, name);
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Librarian librarian = (Librarian) o;
        return password == librarian.password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }
}
