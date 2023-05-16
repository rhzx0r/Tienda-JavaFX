package controller;

import java.net.URL;
import java.util.ResourceBundle;
import classes.AlertWindow;
import classes.Client;
import classes.Direction;
import dao.ClientDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 */
public class ClientRegisterController implements Initializable {

  @FXML
  private Button btnRegisterClient, btnCancel;
  @FXML //*TODO provar inicializarlos con new TextField("initial text"); */
  private TextField Field_ID, Field_fistName, Field_lastName, Field_street, Field_number, Field_colony, Field_cp, Field_city, Field_state, Field_phone;
  
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    btnRegisterClient.setOnAction(event -> RegisterClient(event)); // * Llama al metodo para registrar el cliente */
    btnCancel.setOnAction(event -> Cancel(event)); // * Llama al metodo para cancelar */
  }

  ClientDAO clientDAO = new ClientDAO();

  @FXML
  private void RegisterClient(ActionEvent event) {

    try {

      if (this.Field_fistName.getText().isEmpty() || this.Field_lastName.getText().isEmpty()
          || this.Field_street.getText().isEmpty() || this.Field_number.getText().isEmpty()
          || this.Field_colony.getText().isEmpty() || this.Field_cp.getText().isEmpty()
          || this.Field_city.getText().isEmpty() || this.Field_state.getText().isEmpty()
          || this.Field_phone.getText().isEmpty()) {
        AlertWindow.WarningAlert("Todos los campos son obligatorios");
      } else {

        // * Creación del objeto Dirección */
        Direction newClientDirection = new Direction(this.Field_street.getText(),
            Integer.parseInt(this.Field_number.getText()),
            this.Field_colony.getText(),
            Integer.parseInt(this.Field_cp.getText()),
            this.Field_city.getText(),
            this.Field_state.getText(),
            this.Field_phone.getText());

        // * Creación del objeto Cliente */
        Client newClient = new Client( 
            this.Field_fistName.getText(),
            this.Field_lastName.getText(),
            newClientDirection);

        clientDAO.addClient(newClient);

        AlertWindow.InfoAlert("El cliente " + newClient.getFirstName() + " " + newClient.getLastName() + " ha sido agregado correctamente");

        Field_fistName.setText("");
        Field_lastName.setText("");
        Field_street.setText("");
        Field_number.setText("");
        Field_colony.setText("");
        Field_cp.setText("");
        Field_city.setText("");
        Field_state.setText("");
        Field_phone.setText("");
      }
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println(e.getMessage());
    }
  }

  @FXML
  private void Cancel(ActionEvent event) {
    Stage stage = (Stage) this.btnCancel.getScene().getWindow();
    stage.close();
  }
}
