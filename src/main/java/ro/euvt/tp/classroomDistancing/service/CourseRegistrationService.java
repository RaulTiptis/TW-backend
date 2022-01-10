package ro.euvt.tp.classroomDistancing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.euvt.tp.classroomDistancing.exception.UserNotFoundException;
import ro.euvt.tp.classroomDistancing.model.CourseRegistration;
import ro.euvt.tp.classroomDistancing.repo.CourseRegistrationRepo;

import java.util.List;

@Service
public class CourseRegistrationService {

    private final CourseRegistrationRepo courseRegistrationRepo;

    @Autowired
    public CourseRegistrationService(CourseRegistrationRepo courseRegistrationRepo){
        this.courseRegistrationRepo = courseRegistrationRepo;
    }

    public CourseRegistration addCourseRegistration(CourseRegistration courseRegistration){
        return courseRegistrationRepo.save(courseRegistration);
    }

    public List<CourseRegistration> findAllCourseRegistrations() {
        return courseRegistrationRepo.findAll();
    }

    public CourseRegistration updateCourseRegistration(CourseRegistration courseRegistration){
        return courseRegistrationRepo.save(courseRegistration);
    }

    public CourseRegistration findCourseRegistrationById(Integer id){
        return courseRegistrationRepo.findCourseRegistrationById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id :" + id + " was not found"));
    }

    public void deleteCourseRegistration(Integer id){
        courseRegistrationRepo.deleteCourseRegistrationById(id);
    }
}
