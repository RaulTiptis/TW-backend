package ro.euvt.tp.classroomDistancing.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import ro.euvt.tp.classroomDistancing.model.UserRole;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

@Entity
public class User implements Serializable, UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String firstName;
  private String lastName;
  private String username;
  private String email;
  private String password;
  private boolean isStudent;
  private String department;
  private String year;
  @Enumerated(EnumType.STRING)
  private UserRole userRole;
  private boolean enabled;
  private boolean locked;

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

  public String getEmail(){
    return email;
  }

  public void setEmail(String email){
    this.email = email;
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

  public User(Integer id, String firstName, String lastName,String username, String email, String password, boolean isStudent, String department, String year) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.email = email;
    this.password = password;
    this.isStudent = isStudent;
    this.department = department;
    this. year = year;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
    return Collections.singletonList(authority);
  }

  @Override
  public String getPassword() {
    return password;
  }

  public void setPassword(){
    this.password = password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public void setUsername(){
    this.username = username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return !locked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }
}
