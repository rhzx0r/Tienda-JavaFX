package classes;

import java.math.BigDecimal;

public class Product {
  
  private int ID;
  private String productName;
  private BigDecimal publicPrice;
  private BigDecimal providerPrice;
  private int stock;
  private int amount = 0;

  public Product(String productName, BigDecimal publicPrice, BigDecimal provider, int stock) {
    this.productName = productName;
    this.publicPrice = publicPrice;
    this.providerPrice = provider;
    this.stock = stock;
  }

  public void setID(int iD) {
    this.ID = iD;
  }

  public int getID() {
    return this.ID;
  }

  public String getProductName() {
    return this.productName;
  }

  public BigDecimal getPublicPrice() {
    return this.publicPrice;
  }

  public BigDecimal getProviderPrice() {
    return this.providerPrice;
  }

  public int getStock() {
    return this.stock;
  }

  public void setStock(int newStock) {
    this.stock = newStock;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getAmount() {
    return this.amount;
  }

  @Override // ? Se muestra cuando la clase sea llamada sin ningun metodo *no utilizada aún*
  public String toString() {
    return "\nProducto " + this.productName + " " + this.publicPrice + " " + this.providerPrice + " " + this.stock +  "\n";
  }
}