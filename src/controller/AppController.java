package controller;

import javafx.event.ActionEvent;
// import classes.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AppController {  //* Patron de diseño mvc */

  @FXML
  private Button btnClientRegister;
  @FXML
  private Button btnProductRegister;
  @FXML
  private Button btnSalesProcess;

  @FXML
  public void initialize() {
    btnClientRegister.setOnAction(event -> ClientRegisteWindow(event));
    btnProductRegister.setOnAction(event -> ProductRegisterWindow(event));
    btnSalesProcess.setOnAction(event -> SalesProcessWindow(event));
  }

  @FXML
  public void ProductRegisterWindow(ActionEvent event) {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(this.getClass().getResource("/view/ProductRegisterView.fxml"));
      Pane clientRegisterWindow = (Pane) loader.load();
      // ClientRegisterController control = loader.getController();
      // control.Inicializar(manejoDAO);

      Scene scene = new Scene(clientRegisterWindow);
      Stage secundaryStage = new Stage();
      secundaryStage.setScene(scene);
      secundaryStage.initModality(Modality.APPLICATION_MODAL);
      secundaryStage.setTitle("Registrar Producto");
      secundaryStage.setResizable(false);
      secundaryStage.showAndWait();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @FXML
  public void ClientRegisteWindow(ActionEvent event) {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(this.getClass().getResource("/view/ClientRegisterView.fxml"));
      Pane clientRegisterWindow = (Pane) loader.load();

      Scene scene = new Scene(clientRegisterWindow);
      Stage secundaryStage = new Stage();
      secundaryStage.setScene(scene);
      secundaryStage.initModality(Modality.APPLICATION_MODAL);
      secundaryStage.setTitle("Registrar Cliente");
      secundaryStage.setResizable(false);
      secundaryStage.showAndWait();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @FXML
  public void SalesProcessWindow(ActionEvent event) {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(this.getClass().getResource("/view/SalesProcess.fxml"));
      Pane clientRegisterWindow = (Pane) loader.load();
      Scene scene = new Scene(clientRegisterWindow);
      Stage secundaryStage = new Stage();
      secundaryStage.setScene(scene);
      secundaryStage.initModality(Modality.APPLICATION_MODAL);
      secundaryStage.setTitle("Proceso de Compra");
      secundaryStage.setResizable(false);
      secundaryStage.showAndWait();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}