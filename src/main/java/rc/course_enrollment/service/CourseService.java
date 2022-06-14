package rc.course_enrollment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rc.course_enrollment.db.CourseRepository;
import rc.course_enrollment.model.Course;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository repository;

    public List<Course>findAllCourses(){
        return  repository.findAll();
    }

    public Course saveCourse(Course course){
        return repository.save(course);
    }

    public Course editCourse(Course course){
        return repository.save(course);
    }

    public void deleteById(Long id){
         repository.deleteById(id);
    }

    public Course findById(long id){
      return   repository.findById(id).orElse(null);
    }
}
