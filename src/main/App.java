package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    // * Cargar el archivo FXML */
    Parent root = FXMLLoader.load(getClass().getResource("/view/AppView.fxml"));

    // * Crear la escena */
    Scene scene = new Scene(root, 600, 400);

    // * Establecer la escena en la ventana */
    primaryStage.setScene(scene);
    primaryStage.setTitle("Punto de venta 'Abarrotes Tizimin'");

    // * Mostrar la ventana */
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}