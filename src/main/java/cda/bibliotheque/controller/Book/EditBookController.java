package cda.bibliotheque.controller.Book;

import java.io.IOException;

import cda.bibliotheque.App;
import cda.bibliotheque.dao.BookDAO;
import cda.bibliotheque.model.Book;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


public class EditBookController {

  private final ObjectProperty<Book> book = new SimpleObjectProperty<>(); 
  private final BookDAO bookDAO = new BookDAO();

  
    @FXML
    private CheckBox inputIsAvailable;

    @FXML
    private DatePicker inputReleaseDate;

    @FXML
    private TextField inputTitle;

    @FXML
    private Button submitButton;
  
    @FXML
    void submit(ActionEvent event) throws IOException {
      Book newBook = book.get();
      newBook.setIsAvailable(inputIsAvailable.isSelected());
      newBook.setReleaseDate(inputReleaseDate.getValue());
      newBook.setTitle(inputTitle.getText());
      bookDAO.updateBook(newBook);
      App.setRoot("books");
    }
   
     @FXML
    public void initialize(){
      book.addListener((obs, oldBook, newBook) -> {
        if (newBook != null) {
        inputIsAvailable.setSelected(newBook.getIsAvailable());
        inputReleaseDate.setValue(newBook.getRelease_date());
        inputTitle.setText(newBook.getTitle());
        }
      });
     
    }

  public EditBookController(){
    
  }

    public void setBook(Book book) {
        this.book.set(book);
        
    }
    
  
}
