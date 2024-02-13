package se.iths.allEvent;

import se.iths.*;


public class NoEventsLeft extends Event {

    public NoEventsLeft() {
        super();
        this.eventLevel = 1;
    }
    
    @Override
        public void execute(Player player, InputHandler inputHandler) {
            
            battle.battle(player);

            if (!player.isAlive()) {return;}
            
        }
    

}
