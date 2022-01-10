package ro.euvt.tp.classroomDistancing.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

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

  @OneToMany(mappedBy = "student")
  Set<CourseRegistration> registrationSet;

//  @OneToOne
//  @JoinColumn(
//  name = "user_credentials_id")
//  private UserCredentials userCredentials;

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

//  public UserCredentials getUserCredentials(){
//    return userCredentials;
//  }
//
//  public void setUserCredentials(UserCredentials userCredentials){
//    this.userCredentials = userCredentials;
//  }

  public User(){

  }

  public User(Integer id, String firstName, String lastName, boolean isStudent, String department, String year) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.isStudent = isStudent;
    this.department = department;
    this. year = year;
//    this.userCredentials = userCredentials;
  }
}
