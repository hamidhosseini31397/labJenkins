package se.iths.allEvent;

import se.iths.*;


public class HeroDream extends Event {

    public HeroDream() {
        super();
        this.eventLevel = 20;
    }

    @Override
    public void execute(Player player, InputHandler inputHandler) {
        
        Enemy dragon = new Enemy("Dragon", 200, 30, 40, 20, 50, 300, false);
        Enemy currentMonster = dragon;

        while (player.isAlive()) 
        {
            if (player.getSpeed() >= currentMonster.getSpeed()) 
            {
                battle.choosesAttackOrStats(currentMonster, player);
                if (currentMonster.isAlive() == true) 
                {
                    currentMonster.attack(player);
                    if (!player.isAlive()) {return;}
                } 
                else 
                {
                    System.out.println("You killed the dragon!");
                    break;
                }
            } 
            else {

                currentMonster.attack(player);
                if (player.isAlive()) 
                {
                    if(player.getCurrentHp()<10){
                        System.out.println("The dragon hits hard. Eat a Golden apple to Heal.");
                    }
                    battle.choosesAttackOrStats(currentMonster, player);
                }
                if (!currentMonster.isAlive()) 
                {
                    System.out.println("You killed the dragon!");
                    break;
                }
            }


    }
    
}
}
