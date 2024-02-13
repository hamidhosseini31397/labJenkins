package se.iths.allEvent;

import se.iths.*;


public class LulEvent extends Event {
       
        public LulEvent() {
                super();
                this.eventLevel = 12;
}     
        @Override
        public void execute(Player player, InputHandler inputHandler) {
                System.out.println("Lul");
                }
        
        }
