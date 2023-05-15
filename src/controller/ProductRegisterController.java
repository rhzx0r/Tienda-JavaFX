package controller;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import classes.AlertWindow;
import classes.Product;
import dao.ProductDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProductRegisterController implements Initializable {

  @FXML
  private Button btnRegisterProduct;
  @FXML
  private Button btnCancel;
  @FXML
  private TextField Field_ID;
  @FXML
  private TextField Field_productName;
  @FXML
  private TextField Field_publicPrice;
  @FXML
  private TextField Field_providerPrice;
  @FXML
  private TextField Field_stock;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    btnRegisterProduct.setOnAction(event -> RegisterProduct(event));
    btnCancel.setOnAction(event -> Cancel(event)); // * Llama al metodo para cancelar */
  }

  ProductDAO clientDAO = new ProductDAO();

  @FXML
  private void RegisterProduct(ActionEvent event) {

    try {

      if (this.Field_productName.getText().isEmpty() || this.Field_publicPrice.getText().isEmpty()
          || this.Field_providerPrice.getText().isEmpty() || this.Field_stock.getText().isEmpty()) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setHeaderText("");
        alerta.setTitle("Aviso");
        alerta.setContentText("Todos los campos son obligatorios");
        alerta.showAndWait();
      } else {

        Product newProduct = new Product(
            this.Field_productName.getText(),
            new BigDecimal(this.Field_publicPrice.getText()),
            new BigDecimal(this.Field_providerPrice.getText()),
            Integer.parseInt(this.Field_stock.getText()));

        clientDAO.addProduct(newProduct);

        AlertWindow.InfoAlert("El producto " +  newProduct.getProductName() +  " fue agregado correctamente");

        Field_productName.setText("");
        Field_publicPrice.setText("");
        Field_providerPrice.setText("");
        Field_stock.setText("");
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
