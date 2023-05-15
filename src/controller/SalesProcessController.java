package controller;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import classes.AlertWindow;
import classes.Cart;
import classes.Product;
import dao.ClientDAO;
import dao.ProductDAO;
import dao.TicketDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SalesProcessController implements Initializable {

  ClientDAO clientDAO = new ClientDAO(); // * Nueva instancia del manejador de cliente */
  ProductDAO productDAO = new ProductDAO(); // * Nueva instancia del manejador de producto */
  TicketDAO ticketDAO = new TicketDAO(); // * Nueva instancia del manejador de tickets */

  @FXML
  private Button btnAddToCart, btnConfirmPurchase, btnCancel;
  @FXML
  private TextField Field_idProduct, Field_amountProduct, Field_idClient, Field_money;

  @FXML // * Tabla del carrito de compras */
  private TableView<Product> tableViewCart;
  @FXML
  private TableColumn<Product, String> columnProductId;
  @FXML
  private TableColumn<Product, String> columnProductName;
  @FXML
  private TableColumn<Product, BigDecimal> columnProductPrice;
  @FXML
  private TableColumn<Product, Integer> columnProductAmount;
  @FXML
  private Label labelTotal = new Label("");

  private Cart cart = new Cart(); //* Instancia un nuevo carrito de compras */
  private ObservableList<Product> oCart; //* Crea una variable de tipo Observable para actualizar la ventana del carrito de compras */
  private BigDecimal totalCartPrice = BigDecimal.ZERO; //* Inicializa el precio total del carrito en cero */ 

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {

    this.oCart = FXCollections.observableArrayList();
    tableViewCart.setItems(oCart);

    columnProductId.setCellValueFactory(new PropertyValueFactory<>("ID")); //* Establece la forma en que se va a mostrar la información de las columnas */
    columnProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
    columnProductPrice.setCellValueFactory(new PropertyValueFactory<>("publicPrice"));
    columnProductAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));

    btnAddToCart.setOnAction(event -> AddToCart(event)); //* Llama al metodo para agregar un producto al carrito */
    btnConfirmPurchase.setOnAction(event -> PurchasingProcess(event)); // * Llama al metodo para realizar una compra */
    btnCancel.setOnAction(event -> Cancel(event)); // * Llama al metodo para cancelar */
  }

  @FXML
  private void AddToCart(ActionEvent event) {
    String productIdString = Field_idProduct.getText();
    String productAmountString = Field_amountProduct.getText();

    if (this.Field_idProduct.getText().isEmpty() || this.Field_amountProduct.getText().isEmpty()) { //* Comprueba que los campos no esten vacios */
      AlertWindow.WarningAlert("Todos los campos son necesarios");
    } else {

      try {

        int productId = Integer.parseInt(productIdString);
        int productAmount = Integer.parseInt(productAmountString);

        Product product = productDAO.getById(productId); //* Obtiene el objeto del producto de la base de datos */

        if (product == null) { //* Comprueba de que el producto exista en el inventario */
          AlertWindow.WarningAlert("No se encontro el producto!!!");
        } else {

          cart.addProduct(product, productId, productAmount); //* Agrega el producto al carrito */
          tableViewCart.getItems().setAll(cart.getProductList()); //* Actualiza la tabla del carrito de compras */
          totalCartPrice = cart.getFullImport(); //* obtiene el costo total del carrito */
          labelTotal.setText("Precio total: $" + totalCartPrice.toString()); //* Actualiza el label del precio total */
          Field_idProduct.setText(""); //* Resetea los campos */
          Field_amountProduct.setText("");
        }
      } catch (Exception e) {
        AlertWindow.InfoAlert("Introduzca valores validos por favor");
      }
    }
  }

  @FXML
  private void PurchasingProcess(ActionEvent event) {

    try {
      
      BigDecimal money = Field_money.getText().isEmpty() ? BigDecimal.ZERO : new BigDecimal(this.Field_money.getText()); //* Inicializa la variable del importe del cliente */
      boolean isOverPrice = totalCartPrice.compareTo(money) == 1; //* Verifica si el precio total del carrito es mayor al importe */

      if (Field_idClient.getText().isEmpty() || Field_money.getText().isEmpty() || cart.isEmpty() || isOverPrice) {
        AlertWindow.WarningAlert("Error en el proceso de compra verifique sus campos por favor!");
      } else {

        String clientName = clientDAO.getNameById(Integer.parseInt(Field_idClient.getText()));

        if (clientName == null) {
          AlertWindow.WarningAlert("No se encuentra el cliente, verifique los datos ");
        } else {

          cart.paymentProcess(money); //* Realiza el proceso de pago y actualiza el nuevo inventario */
          productDAO.updateStockByList(cart.getProductList()); //* Actualiza el inventario en la base de datos */
          ticketDAO.saveTicket(Integer.parseInt(Field_idClient.getText()), clientName, cart.getProductList(), money, cart.getFullImport(), cart.getChange()); //* Genera el ticket */
          AlertWindow.InfoAlert("Compra realizada correctamente!!!");

          tableViewCart.getItems().clear(); //* Resetea todos los campos y variables */
          cart = new Cart();
          labelTotal.setText("Precio total: $");
          Field_idClient.setText("");
          Field_money.setText("");
        }
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
