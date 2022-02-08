package rc.course_enrollment.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rc.course_enrollment.db.UserRepository;
import rc.course_enrollment.model.User;

import javax.xml.bind.ValidationException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser( User user) throws ValidationException {
        System.out.println("User sent here"+ user.toString());
        if(userRepository.existsByUsername(user.getUsername())){
            throw  new ValidationException("User already exists by name"+ user.getUsername());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(1);
        return  userRepository.save(user);
    }
}
