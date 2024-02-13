package se.iths.allEvent;

import se.iths.*;


public class TravelerEvent extends Event{

    public TravelerEvent() {
        super();
        this.eventLevel = 2;
    }
    @Override
    public void execute(Player player, InputHandler inputHandler) {


    boolean traveler = true;
    while(traveler){
    System.out.println("You meet a traveler on the road. Do you stop and chat? \n[1] Yes \n[2] No");
    String choice = input.readInput(player);

    if(choice.equalsIgnoreCase("1")){
        chat(player);
        traveler=false;
      
    } else if (choice.equalsIgnoreCase("2")) {
        System.out.println("You ingore the traveler and continue down the road.");
        battle.battle(player);
        if (!player.isAlive()) {return;}
        traveler = false;
        }
    }
}


public void chat(Player player){
    
    boolean chat = true;
    while (chat){
    System.out.println("As you converse he tells you of his quest for a Golden Apple. You remember seeing some apples in your bag earlier and says as much.");
    System.out.println("His face lights up and he offers to trade his dagger for a Golden Apple.");
    System.out.println("Do you accept? \n[1] Yes \n[2] No");
        String secondChoice = input.readInput(player);

        if(secondChoice.equalsIgnoreCase("1")) {
                
            if (player.getApple() != 0){
                    System.out.println("The traveler becomes delighted and hands you the dagger.");
                    player.addAttack(3);
                    player.addSpeed(2);
                    player.decreseApple(1);
                    System.out.println("Attack: + 3\nSpeed: + 2\n\nYou give up one Apple.\nApple: - 1\n");
                    System.out.println("The traveler seems so happy about his new apple that you start to wonder if you might have gotten the short straw.");
                    System.out.println("Oh well, at least someone got the winning hand.");
                    System.out.println();
                    gainEXP(player);
                    chat = false;
            }   else if (player.getApple() == 0) {
                        System.out.println("You look through your bag but it seems you don't have any apples to trade. The traveler sighs disappointedly and continues his hunt for a Golden apple.");
                        System.out.println();
                        gainEXP(player);
                        chat = false;
                } 

        } else if(secondChoice.equalsIgnoreCase("2"))   {
            uppedTrade(player);
            chat = false;
                
    }  else if (secondChoice.equalsIgnoreCase("2")) {    
            noTrade(player);
            chat = false;
        }   
    }
}


public void noTrade(Player player){
        System.out.println("You still dont want to trade your apples. The traveler stalks off in anger.");
        System.out.println("You shrug and continue on your way.");
        System.out.println();
        gainEXP(player);
}


public void uppedTrade(Player player){
    boolean cloak = true;
    while (cloak){
        System.out.println("You want to keep your apples and politely decline.");
        System.out.println("The travaler looks disappointed before rummaging through his backpack but finds nothing.");
        System.out.println("He looks at you desperately before frantically stripping himself of his cloak and offers it to you.");
        System.out.println("'If I give you this aswell, would you please reconsider?' he pleads desperately.");
        System.out.println("Do you accept? \n[1] Yes \n[2] No");
            String thirdChoice = input.readInput(player);

            if(thirdChoice.equalsIgnoreCase("1")) {
                    
                if ( player.getApple() != 0){
                System.out.println("You take pity on him and accept. You could always use a new cloak anyway.");
                System.out.println("You hand over the apple as he throws the dagger and cloak into your hands.");
                player.addMaxHp(10);
                player.addCurrentHp(10);
                player.addSpeed(3);
                player.addAttack(3);
                player.decreseApple(1);
                System.out.println("Max HP: + 10 \nAttack: + 3 \nSpeed: + 2\n\nApple: - 1\n");
                System.out.println("The traveler thanks you profously and rushes down the road with his precious apple.");
                System.out.println("You feel pretty good about the trade even though you lost an apple. You continue down the road.");
                System.out.println();                    
                gainEXP(player);
                cloak = false;
                }  else  {
                    System.out.println("You look through your bag but it seams you don't have any apples to trade. The traveler sighs disappointedly and continues his hunt for a Golden apple.");
                    System.out.println();
                    gainEXP(player);
                    cloak = false;
                    }
                        
                } else if (thirdChoice.equalsIgnoreCase("2")) {    
                noTrade(player);
                cloak = false;
                }
    }

}

} 