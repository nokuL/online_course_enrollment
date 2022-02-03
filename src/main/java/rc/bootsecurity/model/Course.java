package rc.bootsecurity.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Course {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(mappedBy = "likedCourses", fetch = FetchType.LAZY)
    private Set<Student> studentEnrolled;

    private String description;

   @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    @OneToMany(mappedBy = "course")
    private Set<Topic>topics;



}
