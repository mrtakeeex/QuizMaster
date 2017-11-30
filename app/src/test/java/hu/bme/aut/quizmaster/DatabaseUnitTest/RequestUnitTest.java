package hu.bme.aut.quizmaster.DatabaseUnitTest;

import android.content.Context;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import hu.bme.aut.quizmaster.Database.Question;
import hu.bme.aut.quizmaster.Database.Request;
import hu.bme.aut.quizmaster.Database.Topic;

import static org.mockito.Mockito.mock;

public class RequestUnitTest {
    Request request;
    Question question;

    @Before
    public void init() {
        question = new Question("Question", "Answer_Good", "Answer_W1", "Answer_W2", "Answer_W3", Topic.GENERAL);
        request = Request.getInstance(mock(Context.class));
    }

    @Ignore
    @Test
    public void testGetAllAnswer(){
       // Assert.assertFalse(request.getAllAnswer(question).isEmpty());
    }


}
