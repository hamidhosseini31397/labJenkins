package se.iths.allEvent;

import se.iths.*;


public class WishingStarEvent extends Event {
    
public WishingStarEvent(){
    super();
    this.eventLevel = 1;
}

@Override
public void execute(Player player, InputHandler inputHandler){
    boolean wishChoice = true;
    while(wishChoice){
    System.out.println("After a few hours of walking the sun rolls down under the horizon and you decide to stop for some rest.");
    System.out.println("When you are about to tuck in for the night you witness a meteor shower and have the opportunity to wish upon a falling star");
    System.out.println("Do you make a wish? \n[1] Yes \n[2] No");
    String choice = input.readInput(player);
        if(choice.equalsIgnoreCase("1")) {
            Wish(player, input);
             wishChoice=false;
        } else if (choice.equalsIgnoreCase("2")) {
            boolean sure = true;
            while (sure){
            System.out.println("Are you sure? Opportunities like this don't come often!\nMake a wish? \n[1] Yes \n[2] No");
                choice = input.readInput(player);
                    if(choice.equalsIgnoreCase("1")) {
                        Wish(player, input);
                         wishChoice=false;
                         sure = false;
                    } else if (choice.equalsIgnoreCase("2")) {
                        noWish(player);
                         wishChoice=false;
                         sure = false;
                         if (!player.isAlive()) {return;}
                    } else if(choice.equalsIgnoreCase("/menu")){}
                    else{
                        System.out.println("wrong input");
                    }
                }
        } else if (choice.equalsIgnoreCase("2")) {
            noWish(player);
             wishChoice=false;
             if (!player.isAlive()) {return;}
        } else {
        }
    }      
}

private void Wish(Player player, InputHandler inputHandler) {

    boolean wishChoice = true;
    System.out.println("\nYou clasp you hands and turn your gaze towards the stars and decide to wish for:"); 
    while (wishChoice){
    System.out.println("1. Vigorous health\n2. Incredible power\n3. Exceptional speed");
    String wish = input.readInput(player);
        if(wish.equals("1")) {
            player.addMaxHp(20);
            System.out.println("\nA wave of vitality washes over your body, enhancing your resilience!\nMax HP: + 15\n");
            System.out.println("You sleep like a baby and wake up the next day feeling rejuvenated and ready to set out.");
            wishChoice=false;
        } else if (wish.equals("2")) {
            player.addAttack(10);
            System.out.println("\nYou can feel the power surging inside!\nAttack: + 5\n");
            System.out.println("You eventually fall asleep. You wake up well rested and ready to set out.");
            wishChoice=false;
        } else if (wish.equals("3")) {
            player.addSpeed(20);
                System.out.println("\nYou experience a burst of energy, feeling light on your feet!\nSpeed: + 10\n");
                System.out.println("At the break of dawn you waste no time and set out immediately."); 
                wishChoice=false;
        }
    }

    gainEXP(player);
}        

private void noWish(Player player) {
            
    System.out.println("You decide to just admire the beautiful natural occurance of possible impending doom " +
    "and suddenly can't seem to get the 'impending doom'-part out of your mind.\nYou have trouble falling asleep.\nHP: - 5\n");
        player.decreaseCurrentHp(5);
        if (!player.isAlive()) {return;}
    System.out.println("You wake up at dawn of the next day and feel like shit. Despite that you know you have to " + 
    "continue your journey.");

    gainEXP(player);


}

}