package rc.course_enrollment.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Student extends  User{

    @ManyToMany
    @JoinTable(name = "student_courses", joinColumns = {@JoinColumn(name = "user_id") } ,
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private Set<Course> likedCourses ;


    public Student(String username, String password) {
        super(username, password);
    }
}
