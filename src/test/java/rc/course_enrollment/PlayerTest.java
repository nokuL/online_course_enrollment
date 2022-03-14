package rc.course_enrollment;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import rc.course_enrollment.model.practice.Player;
import rc.course_enrollment.model.practice.PlayerStatistics;

public class PlayerTest {

    private Player player1;
    private Player player2;
    private  PlayerStatistics playerStatistics;
    @Before
    public void setUp(){

        player1 = new Player(10, "Noku");
        player2 = new Player(20, "Rudo");
        System.out.println(player1);
    }


    @Test
    public void playerNameEqual(){
        player1 = new Player(10, "Noku");
        player2 = new Player(20, "Noku");
        Assertions.assertEquals(player1, player2);
    }

    @Test
    public void playerNotEqual(){
        Assertions.assertNotEquals(player1, player2);

    }

    @Test
    public void getYoungerPlayerTest(){

        //asssert same checks the actual memory location
        Assertions.assertSame(player1, PlayerStatistics.getYoungerPlayer(player1, player2));
    }

    @Test
    public void testUnderThirtyTrue(){
        Player player = new Player(10, "P");
        PlayerStatistics playerStatistics = new PlayerStatistics(player, 10 , 20);
        Assertions.assertTrue(playerStatistics.underThirty());

    }

    @Test
    public void testUnderThirtyFalse(){
        Player player = new Player(45, "p");
        PlayerStatistics playerStatistics = new PlayerStatistics(player, 10 , 20);
        Assertions.assertFalse(playerStatistics.underThirty());
    }

    @Test
    public void gamesPerGoal(){
        Player player = new Player(45, "p");
        PlayerStatistics playerStatistics = new PlayerStatistics(player, 10, 20);
        Assertions.assertEquals(0.5 , playerStatistics.gamesPerGoal());
    }

    @Test
    public void testCVSNotNull(){
        Player player = new Player(45, "p");
        PlayerStatistics playerStatistics = new PlayerStatistics(player, 10, 20);
        Assertions.assertNotNull(playerStatistics.getCsvFile());

    }

    @Test
    public void  testCSVNull(){
        Player player = new Player(45, "p");
        PlayerStatistics playerStatistics = new PlayerStatistics(player, 0, 20);
        Assertions.assertNull(playerStatistics.getCsvFile());

    }

    @Test
    public void  getCSVTest(){
        Player player = new Player(45, "p");
        PlayerStatistics playerStatistics = new PlayerStatistics(player, 10, 20);
        Double[] csv = new Double[]{2.0, 0.5};
        Assertions.assertArrayEquals(csv, playerStatistics.getCsvFile());

    }




}
