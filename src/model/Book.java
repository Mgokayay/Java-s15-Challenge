package model;

import Books.enums.TypeOfBooks;

import java.util.Objects;

public class Book {

    private int id;
    private String title;
    private String author;

    private double price;
    private boolean borrow;
    private TypeOfBooks type;


    public Book(int id, String title, String author, double price, TypeOfBooks type) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.type = type;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBorrow() {
        return borrow;
    }

    public void setBorrow(boolean borrow) {
        this.borrow = borrow;
    }

    public TypeOfBooks getType() {
        return type;
    }

    public void setType(TypeOfBooks type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", borrow=" + borrow +
                ", type=" + type +
                '}';
    }
}
