package se.iths.allEvent;

import se.iths.*;


public class RootEvent extends Event {
       
        public RootEvent() {
                super();
                this.eventLevel = 4;
}     
        @Override
        public void execute(Player player, InputHandler inputHandler) {
                        System.out.println("You trip over a tree root and land on your face.");
                        System.out.println("HP: - 5");
                        player.decreaseCurrentHp(5);
                        if (!player.isAlive()) {return;}
                        System.out.println("As you get up you realise the tree was a Golden Apple tree. You fill your pockets with fruit before you continue down the road.");
                        System.out.println("What a lucky accident!");
                        player.setApple(4);
                        System.out.println("Apples: " + player.getApple());
                        System.out.println();
                        gainEXP(player);
                        boolean apple = true;
                        while(apple) {
                        System.out.println("Press ENTER to continue.");
                        String enter = inputHandler.readInput(player);
                        if (enter.isEmpty()){
                                apple = false;
                                break;
                        }else {
                                continue;
                        }
                        
                }
        }
        
}