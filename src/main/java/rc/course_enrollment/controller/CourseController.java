package rc.course_enrollment.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rc.course_enrollment.model.Course;
import rc.course_enrollment.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("api/public/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courseService.findAllCourses();

    }

    @GetMapping("/newCourse")
    public Course getNewCourse(){
        return  new Course();
    }

    @PostMapping("/create-course")
    public Course createCourse(@RequestBody Course course){
        return courseService.saveCourse(course);
    }

    @PutMapping("/edit-course")
    public Course editCourse(@RequestBody Course course){
        return  courseService.editCourse(course);
    }

    @DeleteMapping("/delete/course/{id}")
    public void deleteCourse(@PathVariable Long id){
         courseService.deleteById(id);
    }

}
