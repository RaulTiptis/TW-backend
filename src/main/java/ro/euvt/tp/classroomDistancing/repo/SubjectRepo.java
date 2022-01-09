package ro.euvt.tp.classroomDistancing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.euvt.tp.classroomDistancing.model.Subject;

import java.util.Optional;

public interface SubjectRepo extends JpaRepository<Subject, Integer> {


  void deleteSubjectById(Integer id);

  Optional<Subject> findSubjectById(Integer id);
}
