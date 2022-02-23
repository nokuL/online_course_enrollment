package rc.course_enrollment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rc.course_enrollment.model.CourseRegistration;
import rc.course_enrollment.service.CourseRegistrationService;

@RestController
@RequestMapping("/api/public/course-reg")
public class CourseRegistrationController {

    @Autowired
    CourseRegistrationService courseRegistrationService;

    @PostMapping("/newCourse")
    public CourseRegistration newRegistration(@RequestBody CourseRegistration courseRegistration){
        return courseRegistrationService.newCourseReg(courseRegistration);

    }
}
