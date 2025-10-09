package cda.bibliotheque.controller.Client;

import javafx.event.ActionEvent;
import java.io.IOException;

import cda.bibliotheque.App;
import cda.bibliotheque.dao.ClientDAO;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import cda.bibliotheque.model.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditClientController {
    private final ObjectProperty<Client> client = new SimpleObjectProperty<>();
    private final ClientDAO clientDAO = new ClientDAO();
    
    @FXML 
    private TextField inputLastName;

    @FXML 
    private TextField inputFirstName;

    @FXML
    private TextField inputEmail;

    @FXML 
    private Button submitButton;

    @FXML
    void submit(ActionEvent event) throws IOException {
      Client newClient = client.get();
      newClient.setLastName(inputLastName.getText());
      newClient.setFirstName(inputFirstName.getText());
      newClient.setEmail(inputEmail.getText());
      clientDAO.updateClient(newClient);
      App.setRoot("clients");
    }

    @FXML 
    public void initialize(){
      client.addListener((obs, oldclient, newClient) -> {
        if (newClient != null) {
          inputLastName.setText(newClient.getLastName());
          inputFirstName.setText(newClient.getFirstName());
          inputEmail.setText(newClient.getEmail());
        }
    });
  }
    public EditClientController(){

    }
    public void setClient(Client client){
      this.client.set(client);
    }
}
