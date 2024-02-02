package Interface;

import Books.enums.TypeOfBooks;
import model.Book;
import model.Librarian;
import model.User;

import java.util.List;

public interface Controller {
   void addUser(User user);
   void addLibrarian(Librarian librarian);
void addBook(Book book);
void updateBook(int id, String title, String author, double price, TypeOfBooks type);

void removeBook(int id);

List<Book> listByType(TypeOfBooks type);

List<Book> listByAuthor(String author);

boolean borrowBook(int userId,int bookId);

boolean returnedBook(int userId,int bookId);

}
