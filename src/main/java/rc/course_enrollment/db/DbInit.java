package rc.course_enrollment.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rc.course_enrollment.model.User;
import rc.course_enrollment.model.UserRole;

import java.util.*;

@Service
public class DbInit implements CommandLineRunner {

    private UserRepository userRepository;

    private UserRoleRepository userRoleRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        //create Roles
      List<UserRole>useRoleList = new ArrayList<>();
      if(!userRoleRepository.existsByName("ADMIN")){
          UserRole userRole = new UserRole("ADMIN");
          useRoleList.add(userRole);
      }
      if(!userRoleRepository.existsByName("STUDENT")){
          UserRole userRole1 = new UserRole("STUDENT");
          useRoleList.add(userRole1);
      }

      if(!userRoleRepository.existsByName("TUTOR")){
          UserRole userRole2 = new UserRole("TUTOR");
          useRoleList.add(userRole2);
      }
        userRoleRepository.saveAll(useRoleList);


      //create admin users
        if(!userRepository.existsByUsername("admin")){
            List<UserRole>userRoles = new ArrayList<>();
            UserRole userRole = userRoleRepository.findByName("ADMIN");
            userRoles.add(userRole);

            User user = new User("admin", passwordEncoder.encode("admin"));
            user.setRoles(userRoles);
            user.setActive(1);

            this.userRepository.save(user);
        }



    }
}
