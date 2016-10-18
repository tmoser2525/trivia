package com.adaptionsoft.games.uglytrivia;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.containsString;

// TODO: Capture GameRunner output and compare to a golden record

/**
 * Created by clay on 10/12/16.
 */
public class GameTest {

    Game game;
    private ByteArrayOutputStream baos;
    private PrintStream oldPrintStream;

    @Before
    public void setUp() {
        game = new Game();

        // From StackOverflow code by Ernest Friedman-Hill
        // Create a stream to hold the output
        baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        // IMPORTANT: Save the old System.out!
        oldPrintStream = System.out;
        // Tell Java to use your special stream
        System.setOut(ps);
    }

    @After
    public void tearDown() {
        // Undo outstream capture in setUp
        System.setOut(oldPrintStream);
    }

    @Test
    public void constructor_byDefault_setsUpFiftyQuestionsForFourCategories() {
        assertThat(game.popQuestions.size(), is(50));
        assertThat(game.rockQuestions.size(), is(50));
        assertThat(game.scienceQuestions.size(), is(50));
        assertThat(game.sportsQuestions.size(), is(50));
    }

    @Test
    public void constructor_byDefault_createsQuestionsInExpectedFormat() {
        assertThat(game.popQuestions.get(0), is("Pop Question 0"));
        assertThat(game.rockQuestions.get(49), is("Rock Question 49"));
        assertThat(game.scienceQuestions.get(33), is("Science Question 33"));
        assertThat(game.sportsQuestions.get(21), is("Sports Question 21"));
    }
}