package rc.course_enrollment.model.practice;

public class InvalidAmount extends RuntimeException{

    public InvalidAmount(String s) {
        super(s);
    }
}
