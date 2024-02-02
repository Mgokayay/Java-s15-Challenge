package model;

import Books.enums.TypeOfBooks;
import Interface.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Automation implements Controller {

private Map<Integer,Book> books;
private Map<Integer,User> users;
private Map<String,String> librarians;

public Automation() {
this.books=new HashMap<>();
this.users=new HashMap<>();
this.librarians=new HashMap<>();
}

    public Map<Integer, Book> getBooks() {
        return books;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public Map<String, String> getLibrarians() {
        return librarians;
    }

    @Override
    public void addUser(User user) {
       users.put(user.getId(),user);
    }

    @Override
    public void addLibrarian(Librarian librarian) {
         if(librarian != null){
          librarians.put(librarian.getName(),librarian.getPassword());
         }
    }

    @Override
    public void addBook(Book book) {
        books.put(book.getId(),book);
    }

    @Override
    public void updateBook(int id, String title, String author, double price, TypeOfBooks type) {
     Book book =books.get(id);
    if(book != null){
      book.setTitle(title);
      book.setAuthor(author);
      book.setType(type);
      book.setPrice(price);
    }
    }

    @Override
    public void removeBook(int id) {

    }

    @Override
    public List<Book> listByType(TypeOfBooks type) {
        List<Book> result =new ArrayList<>();
         for (Book book : books.values()) {
             if(book.getType().equals(type)) {
               result.add(book);
             }
         }
         return result;
    }

    @Override
    public List<Book> listByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getAuthor().toLowerCase().equals(author.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public boolean borrowBook(int userId, int bookId) {
        User user = users.get(userId);
        Book book = books.get(bookId);

        if(user == null || book == null || user.getBorrowBooks().size() >= 2 || book.isBorrow()) {
            System.out.println("this book is not available for borrowing");
            return false;
        }
         user.setBalance(user.getBalance()-book.getPrice());
         user.getBorrowBooks().add(book);
         book.setBorrow(true);
         return true;
    }

    @Override
    public boolean returnedBook(int userId, int bookId) {
          User user = users.get(userId);
          Book book = books.get(bookId);
          if(user == null || book == null || !book.isBorrow() || !user.getBorrowBooks().contains(book)) {
             return false;
          }

        user.setBalance(user.getBalance()+book.getPrice());
        user.getBorrowBooks().remove(book);
        book.setBorrow(false);
        return true;
    }

    public boolean purchaseBook(int userId, int bookId) {
        User user = users.get(userId);
        Book book = books.get(bookId);

        if (user == null || book == null || user.getBalance() < book.getPrice()) {
            System.out.println("Purchase failed. Check user's balance or book availability.");
            return false;
        }

        user.setBalance(user.getBalance() - book.getPrice());
        user.getBorrowBooks().add(book);
        book.setBorrow(true);

        System.out.println("Book purchased successfully.");
        return true;
    }


}
