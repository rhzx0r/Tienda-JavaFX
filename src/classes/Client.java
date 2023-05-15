package classes;

public class Client { //* Patron de diseño Agregación */
  
  private int ID;
  private String firstName;
  private String lastName;
  private Direction direction;

  public Client(String firstName, String lastName, Direction direction) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.direction = direction;
  }

  public void setID(int id) {
    this.ID = id;
  }

  public int getID() {
    return ID;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public Direction getDirection() {
    return direction;
  }
}
