package cda.bibliotheque.controller.Client;

import javafx.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import cda.bibliotheque.dao.ClientDAO;
import cda.bibliotheque.model.Client;
import javafx.scene.control.Button;
import cda.bibliotheque.App;
import javafx.scene.control.TextField;

public class CreateClientController {
   @FXML
    private TextField inputEmail;

    @FXML
    private TextField inputFirstName;

    @FXML
    private TextField inputLastName;

    @FXML
    private Button submitButton;

    private final ClientDAO clientDAO = new ClientDAO();

    @FXML
    void submit(ActionEvent event) throws IOException{
      Client client = new Client();
      client.setLastName(inputLastName.getText());
      client.setFirstName(inputFirstName.getText());
      client.setEmail(inputEmail.getText());
      clientDAO.addClient(client);
      App.setRoot("clients");
    }
}
