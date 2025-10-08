package cda.bibliotheque.dao;

import cda.bibliotheque.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class BookDAO {
  private Connection connection;

  public BookDAO(){
    this.connection = DatabaseConnection.getConnection();
  }

public List<Book> getAllBook(){
  List<Book> books = new ArrayList<>();
  String sql = "SELECT id, title, release_date, isAvailable FROM books";
  try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
      while (rs.next()) {
        books.add(new Book(
          rs.getInt("id"),
          rs.getString("title"),
          rs.getDate("release_date"),
          rs.getBoolean("isAvailable")
        ));
      }
    } catch (SQLException e) {
      System.err.println("Erreur de la récupération dans getAllBook ❌ " + e.getMessage());
    } 
     return books;
}
public void addBook(Book book){
    String sql = "INSERT INTO author(lastname, firstname, born_at) VALUES (?,?,?)";
    try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setString(1, book.getTitle());
      pstmt.setDate(2, book.getRelease_at_Date());
      pstmt.setBoolean(3, book.getIsAvailable());
      pstmt.executeUpdate();
      System.out.println("Ajout de l'auteur éffectué ✅");
    } catch (SQLException e) {
     System.err.println("Erreur lors de l'ajout de addBook ❌" + e.getMessage());
    }
  }

}
