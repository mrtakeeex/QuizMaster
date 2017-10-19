package hu.bme.aut.quizmaster.GameUnitTest;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import hu.bme.aut.quizmaster.Game.Player;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class PlayerUnitTest {
    final String NAME = "name";
    Player playerMock;

    @Before
    public void init() {
        playerMock = mock(Player.class);

        when(playerMock.getName()).thenReturn(NAME);
    }

    @Test
    public void testSetName() {
        playerMock.setName(NAME);
        Assert.assertEquals(playerMock.getName(), NAME);
    }
}
