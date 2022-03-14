/*
package rc.course_enrollment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import rc.course_enrollment.controller.CourseController;
import rc.course_enrollment.db.CourseRepository;
import rc.course_enrollment.model.Course;
import rc.course_enrollment.service.CourseService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = CourseController.class)
public class CourseControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CourseService courseService;

    @MockBean
    CourseRepository courseRepository;



    Course courseObj;


    @BeforeEach
    void before(){
        courseObj = new Course();


    }

    @Test
    public void testFindAllCourses() throws  Exception{
        List<Course> courseList = new ArrayList<>();
        when(courseService.findAllCourses()).thenReturn(courseList);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/api/public/course/courses");
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        MvcResult mvcResult =resultActions.andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        Assertions.assertEquals(200 , mockHttpServletResponse.getStatus());


    }
}
*/
package rc.course_enrollment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import rc.course_enrollment.controller.CourseController;
import rc.course_enrollment.db.CourseRepository;
import rc.course_enrollment.model.Course;
import rc.course_enrollment.service.CourseService;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
@WebMvcTest
@ContextConfiguration(classes = {CourseController.class})
@AutoConfigureMockMvc(secure = false)
public class CourseControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CourseService courseService;

    @MockBean
    CourseRepository courseRepository;

    Course course;

    @BeforeEach
    public void before(){
        course = new Course();

    }

    @Test
    @DisplayName("Test find all courses")
    public void testFindAllCourses() throws  Exception{
        List<Course> courseList = new ArrayList<>();
        when(courseService.findAllCourses()).thenReturn(courseList);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/api/public/course/courses");
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        MvcResult mvcResult =resultActions.andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        Assertions.assertEquals(200 , mockHttpServletResponse.getStatus());

    }

    @Test
    @DisplayName("Test create new course")
    public void testCreateCourse()throws  Exception{
        when(courseService.saveCourse(course)).thenReturn(course);
        ObjectMapper objectMapper = new ObjectMapper();
        String course_string = objectMapper.writeValueAsString(course);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/api/public/course/create-course")
                .contentType(MediaType.APPLICATION_JSON)
                .content(course_string);
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        MvcResult mvcResult = resultActions.andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        Assertions.assertEquals(200, mockHttpServletResponse.getStatus());
    }

    @Test
    @DisplayName("Test edit course")
    public void testEditCourse()throws  Exception{
        when(courseService.editCourse(course)).thenReturn(course);
        ObjectMapper objectMapper = new ObjectMapper();
        String course_string = objectMapper.writeValueAsString(course);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.put("/api/public/course/edit-course")
                .contentType(MediaType.APPLICATION_JSON)
                .content(course_string);
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        MvcResult mvcResult = resultActions.andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        Assertions.assertEquals(200 , mockHttpServletResponse.getStatus());

    }

    @Test
    @DisplayName("Test Delete course")
    public void deleteCourseTest() throws  Exception{
        doNothing().when(courseRepository).deleteById(1L);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.delete("/api/public/user/delete/user{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON);
        ResultActions perform = mockMvc.perform(mockHttpServletRequestBuilder);
        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();
        Assertions.assertEquals(200, status);
    }




}
