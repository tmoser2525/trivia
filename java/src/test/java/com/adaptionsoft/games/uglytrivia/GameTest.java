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
}