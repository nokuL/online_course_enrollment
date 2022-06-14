package rc.course_enrollment.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Getter
@Setter
@ToString
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long testId;
    long studentId;
    float result;

}
