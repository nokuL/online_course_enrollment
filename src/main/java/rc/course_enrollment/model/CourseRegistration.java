package rc.course_enrollment.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CourseRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long course_reg_id;
    long student_id;
    long course_id;
    long course_name;

}
