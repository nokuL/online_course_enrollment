package rc.course_enrollment.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rc.course_enrollment.db.CourseRegistrationRepository;
import rc.course_enrollment.model.CourseRegistration;

@Service
public class CourseRegistrationService {

    @Autowired
    CourseRegistrationRepository courseRegistrationRepository;

    public CourseRegistration newCourseReg(CourseRegistration courseRegistration){

        return courseRegistrationRepository.save(courseRegistration);
    }
}
