package ro.euvt.tp.classroomDistancing.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Subject implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String name;
  @OneToMany
  @Nullable
  private List<Classroom> classrooms;

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Classroom> getClassroom() {
    return classrooms;
  }

  public void setClassroom(List<Classroom> classrooms) {
    this.classrooms = classrooms;
  }

  public Subject(){

  }

  public Subject(Integer id, String name, List<Classroom> classrooms) {
    this.id = id;
    this.name = name;
    this.classrooms = classrooms;
  }
}
