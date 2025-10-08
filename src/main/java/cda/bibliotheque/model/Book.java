package cda.bibliotheque.model;
import java.sql.Date;
import java.time.LocalDate;

public class Book {
  private int id;
  private String title;
  private LocalDate release_date;
  private boolean isAvailable;


public Book(){

}

public Book(int id, String title, LocalDate release_date, boolean isAvailable){
  this.id = id;
  this.title = title;
  this.release_date = release_date;
  this.isAvailable = isAvailable;
}
public Book(int id, String title, Date release_date, boolean isAvailable){
  this.id = id;
  this.title = title;
  this.release_date = release_date.toLocalDate();
  this.isAvailable = isAvailable;
}
// Getter
public int getId(){
  return id;
}

public String getTitle(){
  return  title;
}

public LocalDate getRelease_date() {
  return release_date;
}
public Date getRelease_at_Date(){
  return Date.valueOf(release_date);
}
public boolean getIsAvailable(){
  return isAvailable;
}
// Setter
public void setTitle(String title){
  this.title = title;

}
public void setReleaseDate(Date release_date){
  this.release_date = release_date.toLocalDate();
}
public void setReleaseDate(LocalDate release_date){
  this.release_date = release_date;
}
public void setIsAvailable(boolean isAvailable){
  this.isAvailable = isAvailable;
}
}

