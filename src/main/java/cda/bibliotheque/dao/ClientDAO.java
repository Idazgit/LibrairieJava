package cda.bibliotheque.dao;

import cda.bibliotheque.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ClientDAO {
  private Connection connection;

  public ClientDAO(){
    this.connection = DatabaseConnection.getConnection();

  }

public List<Client> getAllClients(){
  List<Client> clients = new ArrayList<>();
  String sql = "SELECT id, lastname, firstname, email FROM client";
  try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
 while (rs.next()) {
  clients.add(new Client(
    rs.getInt("id"),
    rs.getString("lastname"),
    rs.getString("firstname"),
    rs.getString("email")
  ));
 } 
  } catch (SQLException e) {
      System.err.println("Erreur de la récupération dans getAllClients ❌ " + e.getMessage());

  }
  return clients;
}
public void addClient(Client client){
  String sql = "INSERT INTO client(lastname, firstname, email) VALUES (?,?,?)";
  try (PreparedStatement pstmt = connection.prepareStatement(sql)){
    pstmt.setString(1, client.getLastName());
    pstmt.setString(2, client.getFirstName());
    pstmt.setString(3, client.getEmail());
    pstmt.executeUpdate();
    System.out.println("Ajout du client éfféctué");
  } catch (SQLException e) {
     System.err.println("Erreur lors de l'ajout de addClient ❌" + e.getMessage());
  }
  
}
public void updateClient(Client client){
  String sql = "UPDATE client SET lastname = ?, firstname = ?, email = ? WHERE id = ?";
  try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
    pstmt.setString(1, client.getLastName());
    pstmt.setString(2, client.getFirstName());
    pstmt.setString(3, client.getEmail());
    pstmt.setInt(4, client.getId());
    int rows = pstmt.executeUpdate();
    if (rows > 0 ) {
      System.out.println("Client mis à jour ✅");
    }else {
      System.out.println("Ce client n'existe pas ❌");
    }
  } catch (SQLException e) {
    System.out.println(client.getId());
    System.err.println("Erreur lors de la modification dans updateClient ❌");
  }
}
public void deleteClient(int id){
    String sql = "DELETE FROM client WHERE id = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setInt(1, id);
      int rows = pstmt.executeUpdate();
      if (rows > 0) {
        System.out.println("Client supprimé avec succes ✅");
      }else{
        System.out.println("Le client n'existe pas ❌");
      }
    } catch (SQLException e) {
      System.err.println("Erreur lors de la suppression dans deleteClient ❌ " + e.getMessage());
    }
  }
}
