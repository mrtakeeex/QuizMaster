package hu.bme.aut.quizmaster.DatabaseUnitTest;

import org.junit.Before;

import hu.bme.aut.quizmaster.Database.Question;
import hu.bme.aut.quizmaster.Database.Request;

import static org.mockito.Mockito.mock;

public class RequestUnitTest {
    Request requestMock;
    Question questionMock;

    @Before
    public void init() {
        requestMock = mock(Request.class);
        questionMock = mock(Question.class);
    }
}
