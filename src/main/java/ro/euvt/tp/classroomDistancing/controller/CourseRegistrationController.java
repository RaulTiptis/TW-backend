package ro.euvt.tp.classroomDistancing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ro.euvt.tp.classroomDistancing.model.CourseRegistration;
import ro.euvt.tp.classroomDistancing.service.ClassroomService;
import ro.euvt.tp.classroomDistancing.service.CourseRegistrationService;

import java.util.List;

@RestController
@RequestMapping("/CourseReg")
public class CourseRegistrationController {

    private final CourseRegistrationService courseRegistrationService;
    private final ClassroomService classroomService;

    public CourseRegistrationController(CourseRegistrationService courseRegistrationService, ClassroomService classroomService) {
        this.courseRegistrationService = courseRegistrationService;
        this.classroomService = classroomService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CourseRegistration>> getAllCourseRegistrations(){
        List<CourseRegistration> courseRegistrations = courseRegistrationService.findAllCourseRegistrations();
        return new ResponseEntity<>(courseRegistrations, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CourseRegistration> getCourseRegistrationsById(@PathVariable("id") Integer id){
        CourseRegistration courseRegistration = courseRegistrationService.findCourseRegistrationById(id);
        return new ResponseEntity<>(courseRegistration, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<CourseRegistration> addCourseRegistration(@RequestBody List<String> list){
        CourseRegistration courseRegistration1 = new CourseRegistration();
        courseRegistration1.setClassroom(classroomService.findClassroomById(Integer.parseInt(list.get(0))));
        CourseRegistration newCourseRegistration = courseRegistrationService.addCourseRegistration(courseRegistration1);
        return new ResponseEntity<>(newCourseRegistration, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CourseRegistration> updateCourseRegistration(@RequestBody CourseRegistration courseRegistration){
        CourseRegistration updateCourseRegistration = courseRegistrationService.updateCourseRegistration(courseRegistration);
        return new ResponseEntity<>(updateCourseRegistration, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourseRegistration(@PathVariable("id") Integer id){
        courseRegistrationService.deleteCourseRegistration(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
