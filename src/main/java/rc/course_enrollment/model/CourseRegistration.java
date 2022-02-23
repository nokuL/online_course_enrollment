package rc.course_enrollment.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseRegistration {

    Long student_id;
    Long course_id;
    Long course_name;



}
