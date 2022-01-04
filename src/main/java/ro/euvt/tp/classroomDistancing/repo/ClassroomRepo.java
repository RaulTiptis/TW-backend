package ro.euvt.tp.classroomDistancing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.euvt.tp.classroomDistancing.model.Classroom;

import java.util.Optional;

public interface ClassroomRepo extends JpaRepository<Classroom, Integer> {
  Optional<Classroom> findClassroomById(Integer id);

  void deleteClassroomById(Integer id);
}
