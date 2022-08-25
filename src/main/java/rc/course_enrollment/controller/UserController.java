package rc.course_enrollment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import rc.course_enrollment.model.User;
import rc.course_enrollment.model.UserRole;
import rc.course_enrollment.service.UserService;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/public/user")
public class UserController {

    @Autowired
    public UserService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/registration")
    public User createUser(@RequestBody User user) throws ValidationException {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> "+ user.toString());
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

    @GetMapping("/getOneUser")
    public User getOneUser(){
        return new User("NOx", "NOx"); }

  /*  @GetMapping("/userTemplate")
    public User userTemplate(){
        User user = new User("admin", "admin");
        UserRole userRole = new UserRole(1, "NH");
        UserRole userRole2 = new UserRole(1, "JU");
        List<UserRole>userRoleList = new ArrayList<>();
        userRoleList.add(userRole);
        userRoleList.add(userRole2);
        user.setRoles(userRoleList);
        return user;
    }*/


}
