package se.iths.allEvent;

import se.iths.*;


public class DragonFightEvent extends Event {

    public DragonFightEvent(){
        super();
        this.eventLevel = 20;
    }

    public void execute(Player player, InputHandler inputHandler){
        GameController gameController = new GameController(player);

        try {gameController.endStory(input);}
        catch (InterruptedException e) {/* IGNORE */}
        Battle b = new Battle(player);
                b.dragonFight(new Dragon(null),player);
                System.out.println("{THE END} \nPress ENTER to exit.");
                input.readInput(player);

    }
    
}
