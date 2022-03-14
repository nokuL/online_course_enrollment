package rc.course_enrollment;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import rc.course_enrollment.db.UserRepository;
import rc.course_enrollment.model.User;
import rc.course_enrollment.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;




   /* @Test
    public void testGetAllUsers(){
        List<User> userList = new ArrayList<>();
        when(userService.findAllUsers()).thenReturn(userList);
        verify()

    }*/
}
