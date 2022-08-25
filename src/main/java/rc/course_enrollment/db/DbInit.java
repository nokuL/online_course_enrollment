package rc.course_enrollment.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rc.course_enrollment.model.User;
import rc.course_enrollment.model.UserRole;

import java.util.*;

@Service
@ComponentScan(basePackages = "rc.course_enrollment.db")
public class DbInit implements CommandLineRunner {
   @Autowired
   UserRepository userRepository;
   @Autowired
   PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) {

      //create admin users
        if(!userRepository.existsByUsername("admin")){
            User user = new User("admin", passwordEncoder.encode("admin"), UserRole.ADMIN);
            user.setActive(1);

            this.userRepository.save(user);
        }



    }
}
