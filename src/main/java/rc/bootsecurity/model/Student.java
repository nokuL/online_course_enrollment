package rc.bootsecurity.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Student extends  User{

    @ManyToMany
    @JoinTable(name = "student_courses", joinColumns = {@JoinColumn(name = "user_id") } ,
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private Set<Course> likedCourses ;



}
