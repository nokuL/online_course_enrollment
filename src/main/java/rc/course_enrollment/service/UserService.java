package rc.course_enrollment.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rc.course_enrollment.db.UserRepository;
import rc.course_enrollment.db.UserRoleRepository;
import rc.course_enrollment.model.User;
import rc.course_enrollment.model.UserRole;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
     UserRoleRepository userRoleRepository;

    @Autowired
     PasswordEncoder passwordEncoder;

    public User createUser( User user) throws ValidationException {

        List<UserRole> userRoleList = new ArrayList<>();

        System.out.println("User sent here"+ user.toString());
        if(userRepository.existsByUsername(user.getUsername())){
            throw  new RuntimeException("User already exists by name"+ user.getUsername());
        }
        if(user.getUsername() == null){
            throw  new RuntimeException("User should have a username");
        }
        if(user.getPassword() ==  null){
            throw  new RuntimeException("User should have password");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(1);

        UserRole userRole = userRoleRepository.findByName("STUDENT");
        userRoleList.add(userRole);

        user.setRoles(userRoleList);


        return  userRepository.save(user);
    }

    public User editUser(User user){
       if(user != null){
        return  userRepository.save(user);
       }else{
            throw new IllegalArgumentException("User to edit cant be null");
       }

    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public List<User>findAllUsers(){
        return  userRepository.findAll();
    }
}
