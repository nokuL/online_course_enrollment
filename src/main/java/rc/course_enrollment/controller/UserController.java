package rc.course_enrollment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import rc.course_enrollment.model.User;
import rc.course_enrollment.service.UserService;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("api/public")
@CrossOrigin
public class UserController {

    @Autowired
    public UserService userService;

    private PasswordEncoder passwordEncoder;


    @PostMapping("/registration")
    private User createUser(@RequestBody User user) throws ValidationException {
        return userService.createUser(user);
    }



}
