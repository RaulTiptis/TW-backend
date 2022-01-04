package ro.euvt.tp.classroomDistancing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.euvt.tp.classroomDistancing.exception.ClassroomNotFoundException;
import ro.euvt.tp.classroomDistancing.model.Classroom;
import ro.euvt.tp.classroomDistancing.repo.ClassroomRepo;

import java.util.List;

@Service
public class ClassroomService {

  private final ClassroomRepo classroomRepo;

  @Autowired
  public ClassroomService(ClassroomRepo classroomRepo) {
    this.classroomRepo = classroomRepo;
  }

  public Classroom addClassroom(Classroom classroom){
    return classroomRepo.save(classroom);
  }

  public List<Classroom> findAllClassrooms() {
    return classroomRepo.findAll();
  }

  public Classroom updateClassroom(Classroom classroom){
    return classroomRepo.save(classroom);
  }

  public Classroom findClassroomById(Integer id){
    return classroomRepo.findClassroomById(id)
      .orElseThrow(() -> new ClassroomNotFoundException("Classroom with id :" + id + " was not found"));
  }

  public void deleteClassroom(Integer id){
    classroomRepo.deleteClassroomById(id);
  }
}
