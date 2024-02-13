package se.iths;


import java.util.*;

public class Event {

    protected int eventLevel;
    Player player;

    public Battle battle = new Battle(player);
    // public InputHandler input = new InputHandler();
    protected static Random randomgen = new Random();
    
    public Event() { }

    public int getEventLevel() {
        return eventLevel;
    }

    public void execute(Player player, InputHandler input) {
        // Override this method.
    }   

    public void gainEXP(Player player){
        System.out.println("You gained experience. \nExperience: + 35");
        player.addExperience(35);
    }

    protected void pressEnterToContinue(Player player) {
        InputHandler input = new InputHandler();

        System.out.println("\nPress ENTER to continue");
        input.readInput(player);
    }

}