package cda.bibliotheque.controller.Client;



import java.io.IOException;

import cda.bibliotheque.App;
import cda.bibliotheque.model.Client;
import cda.bibliotheque.dao.ClientDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

public class ClientController {
   @FXML
    private TableView<Client> clientTable;

    @FXML
    private TableColumn<Client, String> colEmail;

    @FXML
    private TableColumn<Client, String> colFirstName;

    @FXML
    private TableColumn<Client, String> colLastName;

    @FXML 
    private TableColumn<Client, Void> colActions;

    private final ObservableList<Client> clientList = FXCollections.observableArrayList();
    private final ClientDAO clientDAO = new ClientDAO();

    @FXML 
    public void initialize(){
    colLastName.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getLastName()));
    colFirstName.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getFirstName()));
    colEmail.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getEmail()));
    colActions.setCellFactory(cell -> new TableCell<>(){
    private final Button buttonEdit = new Button("Modfifier");
    private final Button buttonDelete = new Button("Supprimer");
    private final HBox box = new HBox(10, buttonEdit,buttonDelete);
    
    {
      buttonEdit.setOnAction(event -> {
        int index = getIndex();
        Client clientToEdit = clientTable.getItems().get(index);
        try {
              FXMLLoader loader = new FXMLLoader(App.class.getResource("edit-client.fxml"));
              Parent parent = loader.load();
              
              EditClientController editClientcontroller = loader.getController();
              editClientcontroller.setClient(clientToEdit);
              App.getScene().setRoot(parent);
            } catch (IOException e) {
              System.out.println("Erreur lors de la création d'un bouton d'édit -> " + e.getMessage());
            }
      });
      buttonDelete.setOnAction(event -> {
            int index = getIndex();
            Client clientToDelete = clientTable.getItems().get(index);
            clientDAO.deleteClient(clientToDelete.getId());
            loadClients();
          });
    }
    @Override
          protected void updateItem(Void item, boolean empty){
            super.updateItem(item, empty);
            if (empty) {
              setGraphic(null);
            } else {
              setGraphic(box);
            }
          }     
   });
    loadClients();
    }
    private void loadClients() {
    clientList.setAll(clientDAO.getAllClients());
     clientTable.setItems(clientList); 
}

    @FXML 
    private void switchToCreate()throws IOException{
      App.setRoot("create-client");
    }
}
