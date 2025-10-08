package cda.bibliotheque.controller;

import cda.bibliotheque.dao.AuthorDAO;
import cda.bibliotheque.model.Author;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class EditAuthorController {

  private final ObjectProperty<Author> author = new SimpleObjectProperty<>(); 
  private final AuthorDAO authorDAO = new AuthorDAO();
  @FXML
    private DatePicker inputBornDate;

    @FXML
    private TextField inputFirstName;

    @FXML
    private TextField inputLastName;

    @FXML
    private Button submitButton;
  
    @FXML
    void submit(ActionEvent event) {

    }
   
     @FXML
    public void initialize(){
      author.addListener((obs, oldAuthor, newAuthor) -> {
        if (newAuthor != null) {
        inputBornDate.setValue(author.getBorn_at());
        inputFirstName.setText(author.getFirstname());
        inputLastName.setText(author.getLastname());
        }
      });
     
    }

  public EditAuthorController(){
    
  }

    public void setAuthor(Author author) {
        this.author.set(author);
        
    }
    
  
}
