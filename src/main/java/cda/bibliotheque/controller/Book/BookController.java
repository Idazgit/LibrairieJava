package cda.bibliotheque.controller.Book;


import java.time.LocalDate;

import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import cda.bibliotheque.dao.AuthorDAO;
import cda.bibliotheque.dao.BookDAO;
import cda.bibliotheque.model.Author;
import cda.bibliotheque.model.Book;
import javafx.fxml.FXML;


public class BookController {
  @FXML
    private TableView<Book> bookTable;

    @FXML
    private TableColumn<Book, Void> colActions;

    @FXML
    private TableColumn<Book, Boolean> colAvailable;

    @FXML
    private TableColumn<Book, LocalDate> colReleaseDate;

    @FXML
    private TableColumn<Book, String> colTitle;

    private final ObservableList<Book> booklist = FXCollections.observableArrayList();
    private final BookDAO bookDAO = new BookDAO();

   // src/main/java/cda/bibliotheque/controller/Book/BookController.java
@FXML
public void initialize() {
    colTitle.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTitle()));
    colReleaseDate.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getRelease_date()));

    
    colAvailable.setCellValueFactory(cell ->
        new SimpleStringProperty(cell.getValue().getIsAvailable() ? "Oui" : "Non"));

    bookTable.setItems(bookList); 
}


    @FXML
    void switchToCreate(ActionEvent event) {
      
    }
}
