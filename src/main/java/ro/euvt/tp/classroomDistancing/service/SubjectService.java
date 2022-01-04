package ro.euvt.tp.classroomDistancing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.euvt.tp.classroomDistancing.exception.SubjectNotFoundException;
import ro.euvt.tp.classroomDistancing.model.Subject;
import ro.euvt.tp.classroomDistancing.repo.SubjectRepo;

import java.util.List;

@Service
public class SubjectService {

  final private SubjectRepo subjectRepo;

  @Autowired
  public SubjectService(SubjectRepo subjectRepo){
    this.subjectRepo = subjectRepo;
  }

  public Subject addSubject(Subject subject){
    return subjectRepo.save(subject);
  }

  public List<Subject> findAllSubjects(){
    return subjectRepo.findAll();
  }

  public Subject updateSubject(Subject subject){
    return subjectRepo.save(subject);
  }

  public Subject findSubjectById(Integer id){
    return subjectRepo.findSubjectById(id)
      .orElseThrow(() -> new SubjectNotFoundException("Subject with id: " + id + "has not been found"));
  }

  public void deleteSubject(Integer id){
    subjectRepo.deleteSubjectById(id);
  }


}
