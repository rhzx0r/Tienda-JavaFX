package dao;

import classes.Client;
import classes.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO { //* Patron de diseño DAO */

  private final Connection connection;

  public ClientDAO() {
    this.connection = Database.getInstance().getConnection(); //* Obtiene una instancia de la conexión a la base de datos */
  }

  public void addClient(Client client) throws SQLException {

    String sql = "INSERT INTO clients (firstName, lastName, street, number, colony, cp, city, state, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"; //* Construye un string sql */
    PreparedStatement statement = connection.prepareStatement(sql); //*  Prepara una sentencia SQL para su ejecución utilizando un objeto PreparedStatement */
    statement.setString(1, client.getFirstName()); //* Setea todos los campos de la base de datos con los correspondientes en el objeto cliente */
    statement.setString(2, client.getLastName());
    statement.setString(3, client.getDirection().getStreet());
    statement.setInt(4, client.getDirection().getNumber());
    statement.setString(5, client.getDirection().getColony());
    statement.setInt(6, client.getDirection().getCp());
    statement.setString(7, client.getDirection().getCity());
    statement.setString(8, client.getDirection().getState());
    statement.setString(9, client.getDirection().getPhone());
    statement.executeUpdate(); //* Ejecuta la query */
  }

  public String getNameById(int id) throws SQLException {

    String sql = "SELECT * FROM clients WHERE id=?";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setInt(1, id);
    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {
      String clientName = resultSet.getString("firstName") + " " + resultSet.getString("lastname");
      return clientName;
    } else {
      return null;
    }
  }
}
