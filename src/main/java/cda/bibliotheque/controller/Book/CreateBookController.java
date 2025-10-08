package cda.bibliotheque.controller.Book;

import java.io.IOError;
import java.io.IOException;

import cda.bibliotheque.App;
import cda.bibliotheque.dao.BookDAO;
import cda.bibliotheque.model.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CreateBookController {
  
    @FXML
    private CheckBox inputIsAvailable;

    @FXML
    private DatePicker inputReleaseDate;

    @FXML
    private TextField inputTitle;

    @FXML
    private Button submitButton;

    private final BookDAO bookDAO = new BookDAO();

    @FXML
    void submit(ActionEvent event) throws IOException {
    Book book = new Book();
    book.setTitle(inputTitle.getText());
    book.setReleaseDate(inputReleaseDate.getValue());
    book.setIsAvailable(inputIsAvailable.isSelected());
    bookDAO.addBook(book);
    App.setRoot("books");
}


}
