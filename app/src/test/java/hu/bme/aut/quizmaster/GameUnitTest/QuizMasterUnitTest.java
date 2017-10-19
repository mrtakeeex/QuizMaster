package hu.bme.aut.quizmaster.GameUnitTest;

import org.junit.Before;

import hu.bme.aut.quizmaster.Game.QuizMaster;

import static org.mockito.Mockito.mock;

/**
 * Created by Gergő on 2017. 10. 19..
 */

public class QuizMasterUnitTest {
    QuizMaster quizMasterMock;

    @Before
    public void init() {
        quizMasterMock = mock(QuizMaster.class);
    }
}
