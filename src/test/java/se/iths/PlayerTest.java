package se.iths;

import org.junit.jupiter.api.*;


public class PlayerTest {

    @Test
    public void playerHPIncreaseOnLevelUp(){
        //Setup
        Player foo = new Player("foo");

        //CUT
        int before = foo.getCurrentHp();
        foo.levelUp();
        int actual = foo.getCurrentHp();

        //Assertions
        // int after = foo.getCurrentHp();
        int expected = 30;
        Assertions.assertEquals(expected, actual);
        // boolean expected = after>before;
        // Assertions.assertTrue(expected);

    }
    
}
