package rc.course_enrollment.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rc.course_enrollment.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    boolean existsByName(String name);

    UserRole findByName(String name);

}
