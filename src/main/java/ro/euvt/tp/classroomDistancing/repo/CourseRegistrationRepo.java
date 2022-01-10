package ro.euvt.tp.classroomDistancing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.euvt.tp.classroomDistancing.model.CourseRegistration;

import java.util.Optional;

public interface CourseRegistrationRepo extends JpaRepository<CourseRegistration, Integer> {

    void deleteCourseRegistrationById(Integer id);

    Optional<CourseRegistration> findCourseRegistrationById(Integer id);
}
