package se.iths.allEvent;

import se.iths.*;


public class FairyEvent extends Event {

public FairyEvent(){
    super();
    this.eventLevel = 4;
}
    
public void execute(Player player, InputHandler inputHandler){

    boolean voice = true;
    while(voice){
        System.out.println("As you walk along the path you hear a singing voice coming from deep within the forest. Do you check it out? \n[1] Yes \n[2] No");
        String check = input.readInput(player);  
        if(check.equals("yes")||check.equals("1")||check.equals("y")) {
            dontLeave(player);
            voice = false;
        } else if (check.equals("/menu")){
            continue;
        } else if (check.equals("no")||check.equals("2")||check.equals("n")){
            noFairy(player);
            voice = false;
        } else {
        }
    }
}

    public void dontLeave(Player player){
        boolean no = true;
        while (no) {
            System.out.println("You follow the beautiful voice until the dark trees give way to a silver pool.");
            System.out.println("Above the glittering water you see a beautiful lady dancing in the air. You get the feeling that you should not be here. \nLeave? \n[1] Yes \n[2] No");
            String leave = input.readInput(player);
            switch (leave) {
                case "1":
                    doLeave(player);
                    no = false;
                    break;
                case "2":
                    entranced(player,no);
                    if (!player.isAlive()) {return;}
                    stay(player);
                    no = false;
                    break;

                default:
            } 
        }
    }

    public void doLeave(Player player){
        boolean tryToLeave = true;
        while(tryToLeave){
            System.out.println("You decide to try to sneak back the way you came but find that your legs won't obey your wishes. Try again?\n[1] Yes \n[2] No");
            String leave = input.readInput(player);
            switch (leave){
                case "1":
                    fairyBlessing(player);
                    tryToLeave = false;
                    break;
                case "2":
                    entranced(player,tryToLeave);
                    if (!player.isAlive()) {return;}
                    stay(player);
                    tryToLeave = false;
                    break;
                default:
            }
        }    
    }
  
    public void fairyBlessing(Player player) {

        boolean feetRooted = true;
        while (feetRooted) {
            System.out.println("Your feet are firmly planted on the ground like they have taken root. What will you do? \n [1] Lift your left leg with your hands. \n [2] Lift your right leg with your hands. \n [3] Lay down and try to crawl away.");
            String blessing = input.readInput(player);
            switch (blessing){
                case "1":
                    System.out.println("Your struggle is drawing the attention of the beautiful lady and before you can take even one step she appears in front of you." + 
                    "\nWhen she speaks you feel your soul tremble but you are in luck, she is flattered that you liked her song and blesses you with a strand of her hair before she sends you on your way.");
                    player.addMaxHp(5);
                    player.addAttack(3);
                    System.out.println("Max HP: + 5 \nAttack: + 3");
                    System.out.println();
                    gainEXP(player);
                    feetRooted = false;
                    break;
                case "2":
                    System.out.println("Your struggle is drawing the attention of the beautiful lady and before you can take even one step she appears in front of you." + 
                    "\nWhen she speaks you feel your soul tremble but you are in luck, she is flattered that you liked her song and blesses you with a flower from her dress before she sends you on your way.");
                    player.addMaxHp(5);
                    player.addSpeed(5);
                    System.out.println("Max HP: + 5 \nSpeed: + 5");
                    System.out.println();
                    gainEXP(player);
                    feetRooted = false;
                    break;
                case "3":
                    System.out.println("The Fair Lady notices you prostrating and appears in your path. You are sure great missfortune will befall you now but she asks you to stand, calling you silly for bowing to her. You are not stupid enough to correct her." + 
                    " She wishes to converse with you so you answer her questions about the world and of your travels until dusk falls and she sends you on your way with the blessing of the Fairies." + 
                    " You do not know what this means but are just happy to have survived the fantasical encounter.");
                    player.addFairy(1);
                    System.out.println("You now have a Fairy's blessing, When in dire need your life might be saved. \nExperience: + 80");
                    player.addExperience(80);
                    feetRooted = false;
                    break;
                default:
            }
        }
    }

    public void entranced(Player player,boolean b){
        
        System.out.println("You are enthranced by the ethereal beauty before you and fail to notice your strenght slowly draining.");
        player.decreaseMaxHp(5);
        player.decreaseAttack(2);
        player.decreaseSpeed(1);
        System.out.println("Max HP: - 5 ");
        System.out.println("Current HP: - 5");
        System.out.println("Attack: - 2 \nSpeed: - 1");
        System.out.println();
        player.decreaseCurrentHp(10);
        if (!player.isAlive()) {b=false; return;}
        System.out.println("You should probaly leave. Will you walk away? \n[1] Yes \n[2] No");
        input.readInput(player);
    }

    public void stay(Player player){
        boolean watching = true;
        while (watching){
            System.out.println("You find it hard to move, the beautiful voice seem to draw you in and you are tempted to stay. What do you do? \n[1] Stay and watch a few more minutes. \n[2] It is time to leave.");
            String hardChoice = input.readInput(player);

            switch (hardChoice){
                case "1":
                    System.out.println("You keep watching the beautiful fairy singing and dancing long into the night. When you finally come to your senses the forest is dark and still.");
                    System.out.println("The experience leave you feeling severely weakened. A fairy's fair form is not for a mortals fragile mind to behold.");
                    player.decreaseMaxHp(5);
                    player.decreaseAttack(5);
                    player.decreaseSpeed(4);
                    System.out.println("Max HP: - 5 \nHP: - 15 ");
                    System.out.println("Attack: - 5 \nSpeed: - 4");
                    System.out.println();
                    player.decreaseCurrentHp(150);
                    if (!player.isAlive()) {return;}
                    gainEXP(player);
                    System.out.println();
                    watching = false;
                    break;
                case "2":
                    System.out.println("You fight free and back away, slowly making your way back through the trees. The experience leave you feeling weaker than before.");
                    gainEXP(player); 
                    watching = false;
                    break;
                default:   
            }          
        }   
    }

    public void noFairy(Player player){
        System.out.println("You continue down the road, the beautiful singing hauting you for a long time.");
        System.out.println("Your resolve was strengthend, you gain experience.\nExperience: + 80");
        player.addExperience(80);
    }

}