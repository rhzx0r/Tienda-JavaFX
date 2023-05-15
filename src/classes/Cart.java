package classes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {

  private List<Product> productList;
  private BigDecimal fullImport = new BigDecimal(0);
  private BigDecimal change = new BigDecimal(0);
  
  public Cart() {
    productList = new ArrayList<Product>();
  }

  public void addProduct(Product product, int productId, int productAmount) {

    Product productFound = productList.stream() // * Obtiene el producto en el caso de ya haber sido agregado anteriormente al carrito */
        .filter(p -> p.getID() == productId)
        .findFirst()
        .orElse(null);

    int auxAmount = productFound != null ? productFound.getAmount() + productAmount : productAmount; // * Auxiliar para controlar el monto del articulo */

    if (auxAmount > product.getStock()) { // * Comprueba de que exista suficiente stock en el inventario */
      AlertWindow.WarningAlert("No hay suficiente stock!!!!");
    } else {
      if (productFound != null) { // * Si existe ya el articulo en el carrito solamente se actualiza la cantidad */
        productFound.setAmount(auxAmount);
        fullImport = fullImport.add(productFound.getPublicPrice().multiply(BigDecimal.valueOf(productAmount))); //* Actualiza el precio total del carrito */
      } else { // * En caso de no existir se actualiza el monto y se agrega al carrito */
        product.setAmount(auxAmount);
        fullImport = fullImport.add(product.getPublicPrice().multiply(BigDecimal.valueOf(product.getAmount()))); //* Actualiza el precio total del carrito */
        this.productList.add(product);
      }
    }
  }

  public void paymentProcess(BigDecimal clientMoney) { //* Actualiza el stock de todos los productos y asigna el cambio */
    
    for (Product product : productList) {
      product.setStock(product.getStock() - product.getAmount());
    }

    change = clientMoney.subtract(fullImport);
  }

  public BigDecimal getFullImport() {
    return this.fullImport;
  }

  public BigDecimal getChange() {
    return this.change;
  }

  public List<Product> getProductList() {
    return this.productList;
  }

  public boolean isEmpty() {
    return productList.isEmpty();
  }
}