package hu.bme.aut.quizmaster.GameUnitTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import hu.bme.aut.quizmaster.Game.Game;
import hu.bme.aut.quizmaster.Game.Player;

public class GameUnitTest {
    Game gameSpy;

    @Before
    public void init()  {
        gameSpy = Mockito.spy(new Game());
    }

    @Test
    public void testSetPlayers() {
        gameSpy.setPlayers(Arrays.asList(new Player("player_one")));
        Assert.assertFalse(gameSpy.getPlayers().isEmpty());
    }

    @Test
    public void testStopGame(){
        gameSpy.stopGame();
        Assert.assertEquals(0, gameSpy.getElapsedQuestionNum());
    }


}
