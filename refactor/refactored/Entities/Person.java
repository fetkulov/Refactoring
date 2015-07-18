package refactored.Entities;

import java.util.Date;

/**
 * The <code>Person</code> class represents Person.
 */
public class Person {
  private long id;
  private String name;
  private PhoneNumber phoneNumber;
  private Date date;

  /**
   * Initializes a newly created {@code Person} object so that it represent Person
   *
   * @param name        The initial value of the
   * @param phoneNumber The initial value of the
   * @param date        The initial value of the
   */
  public Person(String name, PhoneNumber phoneNumber, Date date) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.date = date;
  }

  /**
   * Initializes a newly created {@code Person} object so that it represent Person
   *
   * @param id          The initial value of the
   * @param name        The initial value of the
   * @param phoneNumber The initial value of the
   * @param date        The initial value of the
   */
  public Person(long id, String name, String phoneNumber, Date date) {
    this.id = id;
    this.name = name;
    this.phoneNumber = new PhoneNumber(phoneNumber);
    this.date = date;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PhoneNumber getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(PhoneNumber phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
