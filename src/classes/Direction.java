package classes;

public class Direction {
  
  private String street;
  private int number;
  private String colony;
  private int cp;
  private String city;
  private String state;
  private String phone;

  public Direction (String street, int number, String colony, int cp, String city, String state, String phone) {
    this.street = street;
    this.number = number;
    this.colony = colony;
    this.cp = cp;
    this.city = city;
    this.state = state;
    this.phone = phone;
  }

  public String getStreet() {
    return this.street;
  }

  public int getNumber() {
    return this.number;
  }

  public String getColony() {
    return this.colony;
  }

  public int getCp() {
    return this.cp;
  }

  public String getCity() {
    return this.city;
  }

  public String getState() {
    return this.state;
  }

  public String getPhone() {
    return this.phone;
  }
  
  @Override // ? Se muestra cuando la clase sea llamada sin ningun metodo *no utilizada aún*
  public String toString() {
    return "\nDireccion: " + this.street + " " + this.number + " " + this.colony + " " + this.cp + " " + this.city + " " + this.state + " " + this.phone +  "\n";
  }
}
