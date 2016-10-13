package com.adaptionsoft.games.uglytrivia;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by clay on 10/12/16.
 */
public class GameTest {

    Game game;

    @Before
    public void setUp()
    {
        game = new Game();
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
        assertThat(game.popQuestions.get(0).toString(), is("Pop Question 0"));
        assertThat(game.rockQuestions.get(49).toString(), is("Rock Question 49"));
        assertThat(game.scienceQuestions.get(33).toString(), is("Science Question 33"));
        assertThat(game.sportsQuestions.get(21).toString(), is("Sports Question 21"));
    }
}