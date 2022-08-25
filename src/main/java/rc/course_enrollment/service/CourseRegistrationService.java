package rc.course_enrollment.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rc.course_enrollment.db.CourseRegistrationRepository;
import rc.course_enrollment.db.CourseRepository;
import rc.course_enrollment.db.UserRepository;
import rc.course_enrollment.model.CourseRegistration;

@Service
public class CourseRegistrationService {

    @Autowired
    CourseRegistrationRepository courseRegistrationRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    UserRepository userRepository;

    public CourseRegistration newCourseReg(CourseRegistration courseRegistration){
        if(!courseRepository.existsById(courseRegistration.getCourse_id())){
            throw new RuntimeException("No course found for id" + courseRegistration.getCourse_id());
        }
        if(!userRepository.existsById(courseRegistration.getStudent_id())){
            throw new RuntimeException("No student found for id"+ courseRegistration.getStudent_id());
        }

        return courseRegistrationRepository.save(courseRegistration);
    }

    public void deleteCourseRegistration(long id){
        courseRegistrationRepository.deleteById(id);
    }

    public CourseRegistration editCourse(CourseRegistration courseRegistration){
        return  courseRegistrationRepository.save(courseRegistration);
    }

    public CourseRegistration findById(long id){
        return courseRegistrationRepository.findById(id).orElse(null);
    }
}
