package org.springdev.guides.helloworld;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ratpack.http.Status;
import ratpack.test.MainClassApplicationUnderTest;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MainTest {
    MainClassApplicationUnderTest aut;

    @Before
    public void setup() {
        aut = new MainClassApplicationUnderTest(Main.class);
    }

    @After
    public void tearDown() {
        aut.close();
    }

    @Test
    public void hello() {
        assertEquals(Status.OK, aut.getHttpClient().get("hello").getStatus());

        assertEquals("Hello, World!", aut.getHttpClient().get("hello").getBody().getText());
    }
}
