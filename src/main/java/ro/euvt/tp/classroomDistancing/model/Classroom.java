package ro.euvt.tp.classroomDistancing.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class Classroom implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String name;
  private String location;
  private int capacity;
  private String day;
  private String hour;
  private String month;
  @OneToOne
  @Nullable
  private User teacher;
  @ManyToOne
  @Nullable
  private Subject subject;
  @OneToMany(mappedBy = "course")
  Set<CourseRegistration> registration;

  public Classroom(){

  }

  public Classroom(Integer id,String name, String location, int capacity, User teacher, Subject subject, String day, String hour, String month) {
    this.id = id;
    this.name = name;
    this.location = location;
    this.capacity = capacity;
    this.subject = subject;
    this.teacher = teacher;
    this.day = day;
    this.hour = hour;
    this.month = month;
  }

  public User getTeacher(){
    return teacher;
  }

  public void setTeacher(User teacher){
    this.teacher = teacher;
  }

  public Integer getId(){
    return id;
  }

  public void setId(Integer id){
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public Subject getSubject(){
    return subject;
  }

  public void setSubject(Subject subject){
    this.subject = subject;
  }

  public String getDay(){return day;}

  public void setDay(String day) {
    this.day = day;
  }

  public String getHour(){
    return hour;
  }

  public void setHour(String hour){
    this.hour = hour;
  }

  public String getMonth(){
    return month;
  }

  public void setMonth(String month){
    this.month = month;
  }
}
