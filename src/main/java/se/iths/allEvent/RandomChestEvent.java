package se.iths.allEvent;

import se.iths.*;


public class RandomChestEvent extends Event {

    public RandomChestEvent(){
        super();
        this.eventLevel = 2;
    }

 @Override
    public void execute(Player player, InputHandler inputHandler) {

        System.out.println("While stopping by in a small town one day you wander through the market on a busy street when a peculiarly dressed man catches your eye. " +
         "Your feet seem to live their own life and before you know it you find yourself in front of his stand, curiousity piqued. " + 
         "\nWelcome Traveler, care to play a game of mysteries? He says, gesturing the woven mat in front of him with an enigmatic smile. " + 
         "\nYou eye the three chests on the mat with interest, finding yourself asking what you have to do. " + 
         "\nIn one of these chests there is a valuable tresure. You get to choose only one to open and you gain whatever is inside. " + 
         "But beware, only one is a lucky choice, the others only contains missfortune. " + 
         "\nYou cannot resist and against your better judgement you agree to the game. \nYou have trouble deciding so you fish a die from your pocket to help you out.");

        boolean chestPicked = true;

        while(chestPicked){
         int chest = randomgen.nextInt(4);

            switch(chest){

            case 0: {
                pressEnterToContinue(player);
                System.out.println("You roll the die but at the result you still go with gutfeeling and pick the sturdy chest to the left. " + 
                "\nYou lift the lid and find a golden amulet with a glowing orb of lapis lazuli in the center. Surely this must be the treasure.");
                player.addMaxHp(10);
                player.addAttack(5);
                System.out.println("You take the amulet from the chest and put it around your neck. You feel stronger already.");
                System.out.println("Max HP: + 10 \nAttack: + 5");
                System.out.println();
                chestPicked = false;
                pressEnterToContinue(player);
                break;
            }
            case 1: {
                pressEnterToContinue(player);
                System.out.println("The die rolled a three. After careful consideration you choose to open the wooden chest in the center instead. This felt like a test of your greed and you would not fail." + 
                "\nYour modesty paid off. The chest contained a ruby ring that glittered in the sunlight. A valuable tresure indeed.");
                player.addSpeed(5);
                player.addAttack(5);
                System.out.println("Attack: + 5 \nSpeed: +5");
                System.out.println();
                chestPicked = false;
                pressEnterToContinue(player);
                break;
            }
            case 2: {
                pressEnterToContinue(player);
                System.out.println("You ignore the dieroll and decide to pick the golden chest of fine make and when you lift the lid you are met with a golden armcuff with inlaid emmeralds. " + 
                "\nAs you slip it around your wrist you feel a surge of power through your arm. This was a great treasure.");
                player.addAttack(10);
                System.out.println("Attack: + 10");
                System.out.println();
                chestPicked = false;
                pressEnterToContinue(player);
                break;
            }
            case 3: {
                pressEnterToContinue(player);
                System.out.println("The die rolled a two, you pick the wooden chest in the center and open the lid. " + 
                "\nYou are met with a foul stench and instinctively take a step back.");
                System.out.println("The peculiarly dressed man seems delighted at the sight of the content of the chest." + 
                "\n'I've been looking everywhere for this! The rules state it's yours now but would you trade your prize for this magical cloak instead?' he says. " + 
                "\nYou have no reason to refuse the offer. The stinky content in the chest doesn't seem to do you any good. You accept." + 
                " The cloak feels like water in your hands and the light material is shimmering in the sunlight. You pull it on and your body feel light. ");
                player.addSpeed(10);
                System.out.println("Speed: + 10");
                System.out.println();
                chestPicked = false;
                pressEnterToContinue(player);
                break;
            }
            default:
        }

        System.out.println("You leave the merchant feeling like luck is smiling at you today. \nWhen you reach the end of the street you turn back and notices the strange man and his chests is nowhere to be seen. " + 
        "\nIn the spot where you just won your prize is only an empty space between some stalls and you rub your eyes and blink in confusion. Looking at your newly aquired prize you shake your head in disbelief. " + 
        "\nSome mysteries are not meant to be understood but maybe playing games with shady merchants is a lesson to be learned another day.");
        System.out.println();
        gainEXP(player);
        }

    }
    
}