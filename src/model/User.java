package model;

import java.util.ArrayList;
import java.util.List;

public class User extends Person{

private double balance;

private List<Book> borrowBooks;
    public User(int id, String name,double balance) {
        super(id, name);
        this.balance=balance;
        this.borrowBooks=new ArrayList<>();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Book> getBorrowBooks() {
        return borrowBooks;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", balance=" + balance +
                ", borrowedBooks=" + borrowBooks +
                '}';
    }
}
