package ro.euvt.tp.classroomDistancing.model;

import javax.persistence.*;

@Entity
public class CourseRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Classroom course;

    public CourseRegistration() {

    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student){
        this.student = student;
    }

    public Classroom getClassroom(){
        return course;
    }

    public void setClassroom(Classroom classroom){
        this.course = classroom;
    }

    public CourseRegistration(Integer id, User student, Classroom course){
        this.id = id;
        this.student = student;
        this.course = course;
    }
}
