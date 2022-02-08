/*
package rc.course_enrollment.controller;

import org.springframework.web.bind.annotation.*;
import rc.course_enrollment.db.UserRepository;

@RestController
@RequestMapping("api/public")
@CrossOrigin
public class PublicRestApiController {
    private UserRepository userRepository;

    public PublicRestApiController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // Available to all authenticated users
    @PostMapping("registration")
    public String test1(){
        return "NEW Registration here YEAAAH !";
    }

    // Available to managers
    @GetMapping("management/reports")
    public String reports(){
        return "Some report data";
    }

    // Available to ROLE_ADMIN
    @GetMapping("admin/users")
    public String users(){
        return "@@@@@@@@@@@@@@@@@@@@@@@@";
    }
}
*/
