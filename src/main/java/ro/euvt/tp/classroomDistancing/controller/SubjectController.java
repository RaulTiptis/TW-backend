package ro.euvt.tp.classroomDistancing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ro.euvt.tp.classroomDistancing.model.Subject;
import ro.euvt.tp.classroomDistancing.service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/Subject")
public class SubjectController {

  private final SubjectService subjectService;

  public SubjectController(SubjectService subjectService){
    this.subjectService = subjectService;
  }


  @GetMapping("/all")
  public ResponseEntity<List<Subject>> getAllSubjects(){
    List<Subject> subjects = subjectService.findAllSubjects();
    return new ResponseEntity<>(subjects, HttpStatus.OK);
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<Subject> getSubjectById(@PathVariable("id") Integer id){
    Subject subject = subjectService.findSubjectById(id);
    return new ResponseEntity<>(subject, HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<Subject> addSubject(@RequestBody Subject subject){
    Subject newSubject = subjectService.addSubject(subject);
    return new ResponseEntity<>(newSubject, HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject){
    Subject updateSubject = subjectService.updateSubject(subject);
    return new ResponseEntity<>(updateSubject, HttpStatus.OK);
  }

  @Transactional
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteUserById(@PathVariable("id") Integer id){
    subjectService.deleteSubject(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
