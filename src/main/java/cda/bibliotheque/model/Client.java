package cda.bibliotheque.model;


public class Client {
  private int id;
  private String lastname;
  private String firstname;
  private String email;


  public Client(){

  }

  public Client(int id, String lastname, String firstname, String email){
    this.id = id;
    this.lastname = lastname;
    this.firstname = firstname;
    this.email = email;
  }

  // Getter 
  public int getId(){
    return id;
  }

  public String getLastName(){
    return lastname;
  }

  public String getFirstName(){
    return firstname;
  }
  
  public String getEmail(){
    return email;
  }

  // Setter 
  public void setLastName(String lastname){
    this.lastname = lastname;
  }
  public void setFirstName(String firstname){
    this.firstname = firstname;
  }
  public void setEmail(String email){
    this.email = email;
  }
}
