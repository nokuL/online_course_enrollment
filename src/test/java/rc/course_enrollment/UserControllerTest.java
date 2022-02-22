package rc.course_enrollment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import rc.course_enrollment.controller.UserController;
import rc.course_enrollment.db.UserRepository;
import rc.course_enrollment.model.User;
import rc.course_enrollment.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
@WebMvcTest
@ContextConfiguration(classes = {UserController.class})
@AutoConfigureMockMvc(secure = false)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserRepository userRepository;

    @MockBean
    UserService userService;

    User userObject;

    Long id ;



    @BeforeEach
    public void before(){
        userObject = new User("test", "test");

    }

    @Test
    public void testFindAllUsers() throws Exception {
        List<User>userList = new ArrayList<>();
        //testing the service
        when(userService.findAllUsers()).thenReturn(userList);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/api/public/user/users");
        ResultActions perform = mockMvc.perform(mockHttpServletRequestBuilder);
        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        Assertions.assertEquals(200 , mockHttpServletResponse.getStatus());


    }


    @Test
    public void testEditUser() throws  Exception{
        when(userService.editUser(userObject)).thenReturn(userObject);

        ObjectMapper objectMapper = new ObjectMapper();
        String user_json = objectMapper.writeValueAsString(userObject);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.put("/api/public/user/edit-user").
                contentType(MediaType.APPLICATION_JSON)
                .content(user_json)
                ;

        ResultActions perform = mockMvc.perform(mockHttpServletRequestBuilder);
        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        Assertions.assertEquals(200 , mockHttpServletResponse.getStatus());


    }

    @Test
    public void testCreateUser()throws  Exception{

        when(userService.createUser(userObject)).thenReturn(userObject);
        ObjectMapper objectMapper = new ObjectMapper();
        String user_json = objectMapper.writeValueAsString(userObject);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/api/public/user/registration").
                contentType(MediaType.APPLICATION_JSON)
                .content(user_json);

        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        MvcResult mvcResult = resultActions.andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        Assertions.assertEquals(200 , mockHttpServletResponse.getStatus());
    }

    @Test
    public void deleteUserTest() throws  Exception{
        doNothing().when(userRepository).deleteById(1L);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.delete("/api/public/user/delete/user{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON);
        ResultActions perform = mockMvc.perform(mockHttpServletRequestBuilder);
        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();
        Assertions.assertEquals(200, status);
    }
}
