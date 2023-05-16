package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database { //* Conexión a la base de datos usando singleton */

  private static Database instance;
  private Connection connection;

  private Database() {
    try {
      connection = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") + "\\db\\datos.db");
    } catch (SQLException e) {
      System.err.println("Error al obtener la conexión a la base de datos: " + e.getMessage());
    }
  }

  public static synchronized Database getInstance() {  //* Metodo para obtener una instancia, no permite que se genere una nueva instancia. En el caso de existir una anterior devolvera la misma */
    if (instance == null) 
      instance = new Database();

    return instance;
  }

  public Connection getConnection() {
    return connection;
  }
}
