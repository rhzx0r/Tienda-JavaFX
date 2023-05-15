package classes;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class AlertWindow {

  String message = "";
  
  public AlertWindow(String message) {
    this.message = message;
  }

  @FXML
  public static void InfoAlert(String message) {
    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    alerta.setHeaderText("");
    alerta.setTitle("Alerta");
    alerta.setContentText(message);
    alerta.showAndWait();
  }

  @FXML
  public static void WarningAlert(String message) {
    Alert alerta = new Alert(Alert.AlertType.WARNING);
    alerta.setHeaderText("");
    alerta.setTitle("Alerta");
    alerta.setContentText(message);
    alerta.showAndWait();
  }
}
