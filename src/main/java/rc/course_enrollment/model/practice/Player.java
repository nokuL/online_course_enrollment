package rc.course_enrollment.model.practice;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private int age;
    private String name;


    @Override
    public boolean equals(Object object){
        Player player = (Player) object;
        return Objects.equals(player.getName(), this.getName());
    }


}
