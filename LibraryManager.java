package manager;

import java.util.ArrayList;
import java.util.Iterator;
import model.Book;
import model.User;

public class LibraryManager {
   private ArrayList<Book> books = new ArrayList();
   private ArrayList<User> users = new ArrayList();

   public LibraryManager() {
   }

   public void addBook(Book var1) {
      this.books.add(var1);
   }

   public void addUser(User var1) {
      this.users.add(var1);
   }

   public ArrayList<User> getAllUsers() {
      return this.users;
   }

   public User getUserById(int var1) {
      Iterator var2 = this.users.iterator();

      while(var2.hasNext()) {
         User var3 = (User)var2.next();
         if (var3.getUserId() == var1) {
            return var3;
         }
      }

      return null;
   }

   public Book getBookById(int var1) {
      Iterator var2 = this.books.iterator();

      while(var2.hasNext()) {
         Book var3 = (Book)var2.next();
         if (var3.getId() == var1) {
            return var3;
         }
      }

      return null;
   }

   public void viewAllBooks() {
      if (this.books.isEmpty()) {
         System.out.println("No books available.");
      } else {
         Iterator var1 = this.books.iterator();

         while(var1.hasNext()) {
            Book var2 = (Book)var1.next();
            System.out.println(var2);
         }
      }

   }

   public void searchBookByTitle(String var1) {
      boolean var2 = false;
      Iterator var3 = this.books.iterator();

      while(var3.hasNext()) {
         Book var4 = (Book)var3.next();
         if (var4.getTitle().toLowerCase().contains(var1.toLowerCase())) {
            System.out.println(var4);
            var2 = true;
         }
      }

      if (!var2) {
         System.out.println("No matching books found.");
      }

   }

   public void borrowBook(int var1, int var2) {
      User var3 = this.getUserById(var1);
      Book var4 = this.getBookById(var2);
      if (var3 != null && var4 != null && var4.getCopies() > 0) {
         var4.decreaseCopies();
         var3.borrowBook(var2);
         System.out.println("Book borrowed successfully.");
      } else {
         System.out.println("Unable to borrow book.");
      }

   }

   public void returnBook(int var1, int var2) {
      User var3 = this.getUserById(var1);
      Book var4 = this.getBookById(var2);
      if (var3 != null && var4 != null) {
         var4.increaseCopies();
         var3.returnBook(var2);
         System.out.println("Book returned successfully.");
      } else {
         System.out.println("Unable to return book.");
      }

   }
}