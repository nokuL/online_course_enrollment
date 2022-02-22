package rc.course_enrollment.convertes;


import rc.course_enrollment.model.Gender;

import javax.persistence.AttributeConverter;

public class GenderConverter implements AttributeConverter<Gender, String> {

    @Override
    public String convertToDatabaseColumn(Gender gender) {
        if(gender == null){
            throw new IllegalArgumentException("Gender cant be null");
        }else {
           return gender.toString();
        }
    }

    @Override
    public Gender convertToEntityAttribute(String s) {
        if(s == null){
            throw  new IllegalArgumentException("String cant be null");
        }else{
             return Gender.valueOf(s);
        }

    }
}
