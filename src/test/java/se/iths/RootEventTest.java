package se.iths;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

// import se.iths.*;
import se.iths.allEvent.*;

public class RootEventTest {

    @Test
    public void playerDecresedHPWhenTrip(){
        //Setup
        Player player = new Player("foo");
        Event RootEvent = new RootEvent();
        ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
        System.setIn(in);
        InputHandler inputHandler = new InputHandler();


        //CUT
        int before = player.getCurrentHp();
        
        RootEvent.execute(player, inputHandler);
        int after = player.getCurrentHp();

        //Assertion
        boolean expected = after<before;
        assertTrue(expected);

    }
    
}
