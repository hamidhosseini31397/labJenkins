package se.iths.allEvent;

import se.iths.*;

public class TempleEvent extends Event {

    public TempleEvent() {
        super();
        this.eventLevel = 6;
    }

    @Override
    public void execute(Player player, InputHandler inputHandler) {

        boolean altar = true;
        
        while (altar) {
        System.out.println("You find yourself in a dimly lit, ancient temple filled with mysterious artifacts.\n" +
                "You notice a glimmering object on an altar. What do you want to do?\n\n" +
                "1. Approach the altar and inspect the object.\n" +
                "2. Continue exploring the temple without touching anything.");

        String choice = inputHandler.readInput(player);

            switch (choice) {
                case "1":
                    embraceOrNegotiate(player, input);
                    altar = false;
                    break;
                case "2":
                    investigateOrNo(player, input);
                    altar = false;
                    break;
                default:           
            }
    
        }   

    }

    public void embraceOrNegotiate(Player player, InputHandler inputHandler) {
    
    boolean spirit = true;

        while(spirit) {
        System.out.println("\nYou cautiously approach the altar and inspect the glimmering object.\n" +
        "It's a cursed gemstone! The moment you touch it, a mysterious guardian spirit appears.\n" +
        "The spirit reveals that the gemstone holds ancient power and offers you a choice:\n\n" +
        "1. Embrace the power and accept the consequences.\n" +
        "2. Try to negotiate with the spirit or find another solution.");

            String secondChoice = inputHandler.readInput(player);

            switch (secondChoice) {
                case "1":
                    System.out.println("\nYou decide to embrace the power of the gemstone, accepting the consequences.\n" +
                    "The guardian spirit warns you that the power comes at a great cost.\n" +
                    "As the power surges through you, your body can't handle it, and you collapse.\n" +
                    "You died.");
                    player.setCurrentHp(0);
                    if (!player.isAlive()) {return;}
                    spirit = false;
                    break;
                case "2":
                    System.out.println("\nYou attempt to negotiate with the spirit or find another solution.\n" +
                    "The spirit, however, insists that the power of the gemstone cannot be tamed.\n" +
                    "As you hesitate, the spirit becomes agitated and unleashes a terrible scream.\n" +
                    "You died.");
                    player.setCurrentHp(0);
                    if (!player.isAlive()) {return;}
                    spirit = false;
                    break;
                default:
            }
        }
    }
    
    public void investigateOrNo(Player player, InputHandler inputHandler)  {

        boolean whispering = true;

        while (whispering) {
         System.out.println("\nYou decide to continue exploring the temple without touching anything.\n" +
            "As you walk through the corridor, you hear a faint whispering sound.\n" +
            "What do you want to do?\n\n" +
            "1. Investigate the source of the whispering.\n" +
            "2. Ignore the whispering and proceed cautiously.");

            String secondChoiceExplore = inputHandler.readInput(player);

                switch (secondChoiceExplore) {
                    case "1":
                        System.out.println("\nYou follow the sound of the whispering and encounter a mysterious statue.\n" +
                        "The statue reveals itself as a helpful spirit, warning you of dangers.\n" +
                        "The spirit guides you safely out of the temple.\n");
                        gainEXP(player);
                            whispering = false;
                            break;
                    case "2":
                        randomLiveOrDie(player);
                            whispering = false;
                            break;
                    default:
                }
        }
    }

    public void randomLiveOrDie(Player player) {
    System.out.println("\nYou decide to ignore the whispering and proceed cautiously.");

    int randomOutcome = randomgen.nextInt(2);

        switch (randomOutcome) {
            case 0:
                System.out.println("\n!\n" +
                "You navigate the temple safely and find a hidden exit.\n" +
                "You survived! You gain:\nAttack: + 2\nMax HP: + 5\n");
                player.addAttack(2);
                player.addMaxHp(5);
                player.addCurrentHp(5);
                gainEXP(player);
                    break;
            case 1:
                System.out.println("\nA trap is triggered, and you fall into a pit.\n" +
                "You died.");
                player.setCurrentHp(0);
                if (!player.isAlive()) {return;}
                    break;
            default:
            
        }
    }  
}