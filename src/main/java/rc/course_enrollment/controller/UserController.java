package rc.course_enrollment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import rc.course_enrollment.model.User;
import rc.course_enrollment.service.UserService;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("api/public/user")
@CrossOrigin
public class UserController {

    @Autowired
    public UserService userService;


    @PostMapping("/registration")
    public User createUser(@RequestBody User user) throws ValidationException {
        return userService.createUser(user);
    }

    @PutMapping("/edit-user")
    public User editUser(@RequestBody User user){
        return userService.editUser(user);
    }

    @DeleteMapping("/delete/user/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);

    }

    @GetMapping("/users")
    public List<User>findAllUsers(){
        return userService.findAllUsers();
    }



}
