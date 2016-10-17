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
    public void setUp()
    {
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
    public void tearDown()
    {
        // Undo outstream capture in setUp
        System.setOut(oldPrintStream);
    }

    @Test
    public void constructor_byDefault_setsUpFiftyQuestionsForFourCategories()
    {
        assertThat(game.popQuestions.size(), is(50));
        assertThat(game.rockQuestions.size(), is(50));
        assertThat(game.scienceQuestions.size(), is(50));
        assertThat(game.sportsQuestions.size(), is(50));
    }

    @Test
    public void constructor_byDefault_createsQuestionsInExpectedFormat()
    {
        assertThat(game.popQuestions.get(0), is("Pop Question 0"));
        assertThat(game.rockQuestions.get(49), is("Rock Question 49"));
        assertThat(game.scienceQuestions.get(33), is("Science Question 33"));
        assertThat(game.sportsQuestions.get(21), is("Sports Question 21"));
    }

    private void setupTwoPlayers()
    {
        game.add("Alice");
        game.add("Bob");
    }

    @Test
    public void roll_withCurrentPlayerInPlace0_asksScienceQuestion()
    {
        setupTwoPlayers();
        game.currentPlayer = 0;
        game.places[game.currentPlayer] = 0;
        game.roll(1);
        assertThat(baos.toString(), containsString("Science Question 0") );
    }

    @Test
    public void roll_withCurrentPlayerInPlace1_asksSportsQuestion()
    {
        setupTwoPlayers();
        game.currentPlayer = 0;
        game.places[game.currentPlayer] = 1;
        game.roll(1);
        assertThat(baos.toString(), containsString("Sports Question 0") );
    }

    @Test
    public void roll_withCurrentPlayerInPlace2_asksRockQuestion()
    {
        setupTwoPlayers();
        game.currentPlayer = 0;
        game.places[game.currentPlayer] = 2;
        game.roll(1);
        assertThat(baos.toString(), containsString("Rock Question 0") );
    }

    @Test
    public void roll_withCurrentPlayerInPlace3_asksPopQuestion()
    {
        setupTwoPlayers();
        game.currentPlayer = 0;
        game.places[game.currentPlayer] = 3;
        game.roll(1);
        assertThat(baos.toString(), containsString("Pop Question 0") );
    }

    @Test
    public void roll_withCurrentPlayerInPlace4_asksScienceQuestion()
    {
        setupTwoPlayers();
        game.currentPlayer = 0;
        game.places[game.currentPlayer] = 4;
        game.roll(1);
        assertThat(baos.toString(), containsString("Science Question 0") );
    }

    @Test
    public void roll_withCurrentPlayerInPlace5_asksSportsQuestion()
    {
        setupTwoPlayers();
        game.currentPlayer = 0;
        game.places[game.currentPlayer] = 5;
        game.roll(1);
        assertThat(baos.toString(), containsString("Sports Question 0") );
    }

    @Test
    public void roll_withCurrentPlayerInPlace6_asksRockQuestion()
    {
        setupTwoPlayers();
        game.currentPlayer = 0;
        game.places[game.currentPlayer] = 6;
        game.roll(1);
        assertThat(baos.toString(), containsString("Rock Question 0") );
    }

    @Test
    public void roll_withCurrentPlayerInPlace7_asksPopQuestion()
    {
        setupTwoPlayers();
        game.currentPlayer = 0;
        game.places[game.currentPlayer] = 7;
        game.roll(1);
        assertThat(baos.toString(), containsString("Pop Question 0") );
    }

    @Test
    public void roll_withCurrentPlayerInPlace8_asksScienceQuestion()
    {
        setupTwoPlayers();
        game.currentPlayer = 0;
        game.places[game.currentPlayer] = 8;
        game.roll(1);
        assertThat(baos.toString(), containsString("Science Question 0") );
    }

    @Test
    public void roll_withCurrentPlayerInPlace9_asksSportsQuestion()
    {
        setupTwoPlayers();
        game.currentPlayer = 0;
        game.places[game.currentPlayer] = 9;
        game.roll(1);
        assertThat(baos.toString(), containsString("Sports Question 0") );
    }

    @Test
    public void roll_withCurrentPlayerInPlace10_asksRockQuestion()
    {
        setupTwoPlayers();
        game.currentPlayer = 0;
        game.places[game.currentPlayer] = 10;
        game.roll(1);
        assertThat(baos.toString(), containsString("Rock Question 0") );
    }

    @Test
    public void roll_withCurrentPlayerInPlace11_asksPopQuestion()
    {
        setupTwoPlayers();
        game.currentPlayer = 0;
        game.places[game.currentPlayer] = 11;
        game.roll(1);
        assertThat(baos.toString(), containsString("Pop Question 0") );
    }

    @Test
    public void roll_withCurrentPlayerInPlace12_asksScienceQuestion()
    {
        setupTwoPlayers();
        game.currentPlayer = 0;
        game.places[game.currentPlayer] = 12;
        game.roll(1);
        assertThat(baos.toString(), containsString("Science Question 0") );
    }

}