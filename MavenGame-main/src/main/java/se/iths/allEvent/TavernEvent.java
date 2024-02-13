package se.iths.allEvent;

import se.iths.*;

import java.util.Random;

public class TavernEvent extends Event {

    public TavernEvent(){
        super();
        this.eventLevel = 1;
    }
    
    @Override
    public void execute(Player player,InputHandler inputHandler) {
        Random random = new Random();

        boolean stew = true;
        while (stew){
        System.out.println("You come to an Inn by the road. You decide to take a rest.");
        System.out.println("The inn served a delicious hearty stew, you asked for seconds. Twice.");
        System.out.println("Current HP: + 10");
        player.addCurrentHp(10);
        System.out.println();
        System.out.println("Before you set out again you decide to play one round of dice with the men at the table next to you.");
        System.out.println("Press ENTER to continue.");
        String enter = input.readInput(player);
        if (enter.isEmpty()){
                stew = false;
                break;
        }else {
                continue;
        }
        }
        int prize = random.nextInt(3);
        if(prize == 0){
            System.out.println("Luck are on your side today. You win a new pair of gloves. They are of fine make and will protect you well.");
            player.addMaxHp(10);
            System.out.println("Hp: + 10");
            System.out.println();
        } else if (prize == 1){
            System.out.println("Lady Luck is smiling at you today. You win a new whetting stone. It will come in handy.");
            player.addAttack(3);
            System.out.println("Attack: + 3");
            System.out.println();
        } else if (prize == 2) {
            System.out.println("You are blessed with good luck today. You walk away with the ruby amulet. It was the most valuable prize, power glowing in the gem.");
            player.addMaxHp(10);
            player.addAttack(3);
            System.out.println("Hp: + 10\nAttack: + 3");
            System.out.println();
        }
        System.out.println("When you finally hit the road again you realised you ate way too much. You are sure you've gained some weight, you feel slower than before.");
        player.decreaseSpeed(1);
        System.out.println("Speed: - 1");
        System.out.println();
        gainEXP(player);
        boolean fatass = true;
        while(fatass) {
        System.out.println("Press ENTER to continue.");
        String enter = input.readInput(player);
        if (enter.isEmpty()){
                fatass = false;
                break;
        }else {
                continue;
        }
    }
    }
}