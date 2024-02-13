package se.iths.allEvent;

import se.iths.*;

public class PuzzleBoxEvent extends Event {
    
    public PuzzleBoxEvent() {
        super();
        this.eventLevel = 3;
    }
    
    @Override
    public void execute(Player player, InputHandler inputHandler) {
        
    System.out.println("While exploring the outskirts of a smaller town of god knows where, the local merchant notices your curiousity as you inspect his wares" + 
    "\nWith a discerning smile, he approaches and says 'Ah, I see you have an eye for the peculiar. It's this puzzle box i presume?'" + 
    "\nHe presents it to you, adding 'I've had this in my posession for as long as I can remember. It's secrets elude me.." + 
    "\nPerhaps a fresh perpective is what it needs. Take it, and if your crack it's mystery, consider it your reward.");
  
        String correctAnswer = "river";
        int attempts = 0;

        while (attempts < 10) {
            System.out.println("\nRiddle: What runs but never walks, murmurs but never talks, has a bed but never sleeps and has a mouth but never eats?");
            String userGuess = input.readInput(player);

            if (checkGuess(userGuess, correctAnswer)) {
                System.out.println("\nCongratulations! You've successfully solved the riddle and obtained a locket with an old picture of a unknow lady from the box." + 
                "\nIt turns out to be the merchant's grandmother, and he offers to trade it for anything in his shop. Since it's worthless to you, you accept." + 
                "\n\nYou pick out a few items to aid you on your journey.\nHP: + 10\nAttack: + 2\nSpeed: + 3");
                player.addMaxHp(10);
                player.addCurrentHp(10);
                player.addAttack(2);
                player.addSpeed(3);
                gainEXP(player);
                break;
            } else if (userGuess.equals("/stats")){
                    continue;
            } else if (userGuess.equals("/menu")){
                    continue;
            } else {
                System.out.println("Nothing happens. Try again.");
                attempts++;
                }   
             
            if (attempts == 5) {
                System.out.println("HINT: It's a five letter word.");
            } else if (attempts == 8) {
                System.out.println("HINT2: It also contains water.");
                }
            
        }
            if (attempts >= 10) {
            System.out.println("Unfortunately, you give up and were not able to solve the riddle, so you handed back the box to the merchant. Disappointing.");
            gainEXP(player);
            }
    }
    
    private static boolean checkGuess(String userGuess, String correctAnswer) {
        return userGuess.equals(correctAnswer);
    }
    
}