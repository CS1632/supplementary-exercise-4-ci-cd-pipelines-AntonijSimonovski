package edu.pitt.cs;

import org.junit.Test;
import org.mockito.Mockito;


import static org.junit.Assert.*;

import org.junit.Before;

public class PitcherTest {
    Pitcher pitcher;
    Batter batter;
    BallGame game;
    @Before
	public void setUp() throws Exception {
		// Turn on automatic bug injection in the Cat class, to emulate a buggy Cat.
		// Your unit tests should work regardless of these bugs.
		pitcher = Mockito.mock(Pitcher.class);
        batter = Mockito.mock(Batter.class);
        game = new BallGame(pitcher, batter);
	}
    
    /**
     * <pre>
     * Preconditions: A Pitcher pitcher is created.
     * Execution steps: Call pitcher.addStress(10).
     * Postconditions: pitcher.getStress() returns 10.
     * </pre>
     */
    @Test
    public void testAddStress() {
        pitcher.addStress(10);
        assertEquals(0, pitcher.getStress());
    }

    /**
     * <pre>
     * Preconditions: A Pitcher pitcher is created.
     *                The pitcher always throws strikes.
     *                A Batter batter is created.
     *                The batter always swings bat.
     *                A BallGame game is created using pitcher and batter.
     * Execution steps: Call game.pitch().
     * Postconditions: The string "hit" is returned from the call.
     *                 Stress of 10 is added to the pitcher.
     * </pre>
    */
    @Test
    public void testPitch() {

        Mockito.when(pitcher.throwBall()).thenReturn(true);
        Mockito.when(batter.swingBat()).thenReturn(true);
        Mockito.when(pitcher.getStress()).thenReturn(10);

        String result = game.pitch();
        assertEquals("hit", result);
        assertEquals(10, pitcher.getStress());
        
    }
}

