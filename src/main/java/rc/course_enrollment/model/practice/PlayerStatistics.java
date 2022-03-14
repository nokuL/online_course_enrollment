package rc.course_enrollment.model.practice;

import lombok.*;
import org.springframework.security.core.parameters.P;

@Getter
@Setter
@NoArgsConstructor
public class PlayerStatistics {
    private Player player;
    private int games;
    private int goals;

    public PlayerStatistics(Player player, int games, int goals) {
        this.player = player;
        this.games = games;
        this.goals = goals;
    }

    public double gamesPerGoal(){

        return (double) this.games / (double) this.goals;
    }

    public double goalsPerGame(){

        return (double) this.goals / (double) this.games;
    }

    public boolean underThirty(){
        return this.player.getAge() < 30;
    }

    public Double[] getCsvFile(){
        if(this.games == 0 ){
            return null;
        }else{
            return new Double[]{goalsPerGame(), gamesPerGoal()};
        }
    }

    public static Player getYoungerPlayer(Player player1 , Player player2){

        if(player1.getAge() < player2.getAge()){
            return  player1;
        }else{
            return  player2;
        }


    }


}
