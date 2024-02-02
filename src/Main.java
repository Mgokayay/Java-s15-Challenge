import Books.enums.TypeOfBooks;
import model.Automation;
import model.Book;
import model.Librarian;
import model.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Automation library = new Automation();
       Scanner scanner =new Scanner(System.in);
        Librarian librarian = new Librarian(1,"gokay","ay");
        Librarian librarian2 = new Librarian(1,"samet","ozturk");
        Librarian librarian3 = new Librarian(1,"dogancan","kinik");
        library.addLibrarian(librarian);
        library.addLibrarian(librarian2);
        library.addLibrarian(librarian3);
        mainOptions(library,scanner);
    }

    public static void mainOptions(Automation library,Scanner scanner) {
        System.out.println("1:Librarian Options");
        System.out.println("2:User Options");
        System.out.println("3:Exit");
        System.out.println("Select An Option");

        int firstChoice =scanner.nextInt();
        scanner.nextLine();
        switch (firstChoice){
            case 1:
                System.out.print("Enter Your Name: ");
                String librarianName = scanner.nextLine();
                System.out.print("Enter Your Password: ");
                String librarianPassword = scanner.nextLine();
                try {
                    if (library.getLibrarians().get(librarianName).equals(librarianPassword)){
                        librarianOptions(library,scanner);
                    }
                }catch (NullPointerException ex){
                    System.out.println("Invalid information: "+ex.getMessage());
                }
                break;
            case 2:
                 userOptions(library,scanner);
            case 3:
                System.out.println("Exit");
                scanner.close();
                System.exit(0);

        }


    }

    public static void userOptions(Automation library,Scanner scanner) {
        System.out.println("User Id:");
        int userId=scanner.nextInt();
        scanner.nextLine();
        System.out.println("User Name:");
        String userName=scanner.nextLine();
        System.out.println("Enter Credit:");
        double credit=scanner.nextDouble();
        scanner.nextLine();
        library.addUser(new User(userId, userName, credit));
        System.out.println("Registered");

      while(true) {
          System.out.println("1:Show Books");
          System.out.println("2:Show Books by Type");
          System.out.println("3:Show Books by Author");
          System.out.println("4:Borrow Book");
          System.out.println("5:Return Book");
          System.out.println("6:Remaining Balance");
          System.out.println("7:Exit");
          System.out.println("Select Option:");
          int choise = scanner.nextInt();
          scanner.nextLine();
          switch (choise){
              case 1:
                  System.out.println(library.getBooks());
                  break;
              case 2:
                  System.out.print("Enter Category: ");
                  for (TypeOfBooks category : TypeOfBooks.values()) {
                      System.out.println(category.ordinal() + ". " + category);
                  }

                  System.out.print("Enter the category number: ");
                  int categoryIndex = scanner.nextInt();

                  TypeOfBooks selectedType = null;
                  if (categoryIndex >= 0 && categoryIndex < TypeOfBooks.values().length) {
                      selectedType = TypeOfBooks.values()[categoryIndex];
                      System.out.println("You selected: " + selectedType);
                      System.out.println(library.listByType(selectedType));

                  } else {
                      System.out.println("Invalid category number.");
                  }
                  break;
              case 3:
                  System.out.print("Enter Author: ");
                  String authorInput = scanner.nextLine();
                  System.out.println(library.listByAuthor(authorInput));
                  break;
              case 4:
                  System.out.print("Enter User ID: ");
                  int borrowUserId = scanner.nextInt();
                  scanner.nextLine();
                  System.out.print("Enter Book ID: ");
                  int borrowBookId = scanner.nextInt();
                  boolean success = library.borrowBook(borrowUserId, borrowBookId);
                  if (success) {
                      System.out.println("Book borrowed successfully.");
                  } else {
                      System.out.println("Borrowing failed. Check user's balance or book availability.");
                  }
                  break;
              case 5:
                  System.out.print("Enter User ID: ");
                  int returnUserId = scanner.nextInt();
                  scanner.nextLine();
                  System.out.print("Enter Book ID: ");
                  int returnBookId = scanner.nextInt();
                  boolean returnSuccess = library.returnedBook(returnUserId, returnBookId);
                  if (returnSuccess) {
                      System.out.println("Book returned successfully.");
                  } else {
                      System.out.println("Returning failed. Check user's borrowed books or book availability.");
                  }
                  break;
              case 6:
                  System.out.print("Enter User ID: ");
                  int purchaseUserId = scanner.nextInt();
                  scanner.nextLine();
                  System.out.print("Enter Book ID: ");
                  int purchaseBookId = scanner.nextInt();
                  boolean purchaseSuccess = library.purchaseBook(purchaseUserId, purchaseBookId);
                  if (purchaseSuccess) {
                      System.out.println("Book purchased successfully. Remaining Balance: " + library.getUsers().get(purchaseUserId).getBalance());
                  } else {
                      System.out.println("Purchase failed. Check user's balance or book availability.");
                  }
                  break;

              case 7:
                  mainOptions(library,scanner);
                  break;

              default:
                  System.out.println("Invalid choice. Please try again.");
                  break;
          }
      }

    }
    private static void librarianOptions(Automation library, Scanner scanner){
        while (true){
            System.out.println("1. Show Books");
            System.out.println("2. Add User");
            System.out.println("3. Show Users");
            System.out.println("4. Show Books as Category");
            System.out.println("5. Show Books as Author");
            System.out.println("6. Add Book");
            System.out.println("7. Remove Book");
            System.out.println("8. Update Book");
            System.out.println("9. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println(library.getBooks());
                    break;
                case 2:
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter User Name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter Balance: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();
                    library.addUser(new User(userId, userName, balance));
                    System.out.println("User added.");
                    break;
                case 3:
                    System.out.println(library.getUsers());
                    break;
                case 4:
                    System.out.print("Enter Category: ");
                    for (TypeOfBooks category : TypeOfBooks.values()) {
                        System.out.println(category.ordinal() + ". " + category);
                    }

                    System.out.print("Enter the category number: ");
                    int categoryIndex = scanner.nextInt();

                    TypeOfBooks selectedCategory = null;
                    if (categoryIndex >= 0 && categoryIndex < TypeOfBooks.values().length) {
                        selectedCategory = TypeOfBooks.values()[categoryIndex];
                        System.out.println("You selected: " + selectedCategory);
                    } else {
                        System.out.println("Invalid category number.");
                    }
                    break;
                case 5:
                    System.out.print("Enter Author: ");
                    String authorInput = scanner.nextLine();
                    System.out.println(library.listByAuthor(authorInput));
                    break;
                case 6:
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Category: ");
                    System.out.println("Available Categories:");
                    for (TypeOfBooks category : TypeOfBooks.values()) {
                        System.out.println(category.ordinal() + ". " + category);
                    }

                    System.out.print("Enter the category number: ");
                    int categoryIndex2 = scanner.nextInt();

                    TypeOfBooks selectedCategory2 = null;
                    if (categoryIndex2 >= 0 && categoryIndex2 < TypeOfBooks.values().length) {
                        selectedCategory2 = TypeOfBooks.values()[categoryIndex2];
                        System.out.println("You selected: " + selectedCategory2);
                    } else {
                        System.out.println("Invalid category number.");
                    }
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    library.addBook(new Book(bookId, title, author,price, selectedCategory2));

                    System.out.println("Book added.");
                    break;
                case 7:
                    System.out.print("Enter Book ID to Remove: ");
                    int removeBookId = scanner.nextInt();
                    library.removeBook(removeBookId);
                    System.out.println("Book removed.");
                    break;
                case 8:
                    System.out.print("Enter Book ID to Update: ");
                    int updateBookId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Updated Title: ");
                    String updatedTitle = scanner.nextLine();
                    System.out.print("Enter Updated Author: ");
                    String updatedAuthor = scanner.nextLine();
                    System.out.print("Enter Updated Category: ");
                    for (TypeOfBooks category : TypeOfBooks.values()) {
                        System.out.println(category.ordinal() + ". " + category);
                    }

                    System.out.print("Enter the category number: ");
                    int categoryIndex3 = scanner.nextInt();

                    TypeOfBooks updatedType = null;
                    if (categoryIndex3 >= 0 && categoryIndex3 < TypeOfBooks.values().length) {
                        updatedType = TypeOfBooks.values()[categoryIndex3];
                        System.out.println("You selected: " + updatedType);
                    } else {
                        System.out.println("Invalid category number.");
                    }
                    System.out.print("Enter Updated Price: ");
                    double updatedPrice = scanner.nextDouble();
                    library.updateBook(updateBookId, updatedTitle, updatedAuthor, updatedPrice, updatedType);

                    System.out.println("Book updated.");
                    break;
                case 9:
                    mainOptions(library, scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}