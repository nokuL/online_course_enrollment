package rc.course_enrollment.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public enum UserRole {
    ADMIN,
    SUPERVISOR,
    EMPLOYEE,
    STUDENT


}
