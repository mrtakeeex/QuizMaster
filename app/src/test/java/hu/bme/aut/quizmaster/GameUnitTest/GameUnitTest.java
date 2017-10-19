package hu.bme.aut.quizmaster.GameUnitTest;

import org.junit.Before;

import hu.bme.aut.quizmaster.Game.Game;

import static org.mockito.Mockito.mock;

public class GameUnitTest {
    Game gameMock;

    @Before
    public void init() {
        gameMock = mock(Game.class);
    }
}
