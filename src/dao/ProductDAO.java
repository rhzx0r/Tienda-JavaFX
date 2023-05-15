package dao;

import classes.Database;
import classes.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDAO {

  private final Connection connection;

  public ProductDAO() { 
    this.connection = Database.getInstance().getConnection(); //* Obtiene una instancia de la conexión a la base de datos */
  }

  public void addProduct(Product product) throws SQLException {
    String sql = "INSERT INTO products (productName, publicPrice, providerPrice, stock) VALUES (?, ?, ?, ?)";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, product.getProductName());
    statement.setBigDecimal(2, product.getPublicPrice());
    statement.setBigDecimal(3, product.getProviderPrice());
    statement.setInt(4, product.getStock());
    statement.executeUpdate();
  }

  public void updateStockById(int id, int newStock) throws SQLException {
    String sql = "UPDATE products SET stock=? WHERE id=?";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setInt(1, newStock);
    statement.setInt(2, id);
    statement.executeUpdate();
  }

  public void updateStockByList(List<Product> products) throws SQLException { //*TODO Optimizar con una Query dinamica este metodo */
    for (Product product : products) {
      updateStockById(product.getID(), product.getStock());
    }
  }

  public Product getById(int id) throws SQLException {
    String sql = "SELECT * FROM products WHERE id=?";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setInt(1, id);
    ResultSet resultSet = statement.executeQuery();
    if (resultSet.next()) {

      Product product = new Product(
          resultSet.getString("productName"),
          resultSet.getBigDecimal("publicPrice"),
          resultSet.getBigDecimal("providerPrice"),
          resultSet.getInt("stock"));

      product.setID(resultSet.getInt("id"));
      return product;
    } else {
      return null;
    }
  }
}
