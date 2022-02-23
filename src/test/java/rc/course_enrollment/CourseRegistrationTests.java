package rc.course_enrollment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import rc.course_enrollment.controller.CourseRegistrationController;
import rc.course_enrollment.db.CourseRegistrationRepository;
import rc.course_enrollment.model.CourseRegistration;
import rc.course_enrollment.service.CourseRegistrationService;

import static org.mockito.Mockito.when;

@WebMvcTest
@ContextConfiguration(classes = CourseRegistrationController.class)
@AutoConfigureMockMvc(secure = false)
public class CourseRegistrationTests {

    @MockBean
    MockMvc mockMvc;

    @MockBean
    CourseRegistrationService courseRegistrationService;

    @MockBean
    CourseRegistrationRepository courseRegistrationRepository;

    CourseRegistration courseRegistration;


    @BeforeEach
    public void before(){
        courseRegistration = new CourseRegistration();
    }

    @Test
    public void createRegistration() throws Exception {
        when(courseRegistrationService.newCourseReg(courseRegistration)).thenReturn(courseRegistration);
        ObjectMapper objectMapper = new ObjectMapper();
        String reg_string = objectMapper.writeValueAsString(courseRegistration);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/api/public/course-reg/newCourse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(reg_string);
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        MockMvcR




    }
}
