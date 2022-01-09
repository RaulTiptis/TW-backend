package ro.euvt.tp.classroomDistancing.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String firstName;

  private String lastName;

  private boolean isStudent;

  private String department;

  private String year;

  public Integer getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public boolean getIsStudent(){
    return isStudent;
  }

  public void setIsStudent(boolean isStudent){
    this.isStudent = isStudent;
  }

  public String getDepartment(){
    return department;
  }

  public void setDepartment(String department){
    this.department = department;
  }

  public String getYear(){
    return year;
  }

  public void setYear(String year){
    this.year = year;
  }

  public User(){

  }

  public User(Integer id, String firstName, String lastName, boolean isStudent, String department, String year, UserCredentials userCredentials) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.isStudent = isStudent;
    this.department = department;
    this. year = year;
  }
}
