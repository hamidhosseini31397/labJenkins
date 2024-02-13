package se.iths;


import java.util.Random;

public class GameController {
    Player player;
    Random random = new Random();
    InputHandler input = new InputHandler();
    String roomChoice;
    EventController eventControl = new EventController();

    public String midInstructions = "You have the choices of going left or right, you also have the option to consume an apple in these sections."
    +"\nThese choices dictate whichever encounter you as the player chooses."
    +"\nFor instance; the right path is combat focused and will always lead to a monster of similar level to the player."
    +"\nWhilst the left path will lead to events/encounters that could benefit or harm you."
    
    +"\n\nYou have the following options and their meaning:"
    +"\n- [1]Left (Go the left path for encounters.)"
    +"\n- [2]Right (Go the right path for combat.)"
    +"\n- [3]Eat Apple (Regenerate your health, it will consume one of your apples.)"
    
    +"\n\nYou also have the follow unlisted commands"
    +"\n- /help (For instructions, Duh! You're already here.)"
    +"\n- /stats (To display your current stats and decide whether you also want to consume an apple if you're wounded)"
    +"\n      HP : How much health the player/monster has."
    +"\n      Attack : How much minimum damage the player and the monster can output, the maximum output is randomized."
    +"\n      Speed : How dexterous the player/monster is, this determines who fights first."
    +"\n      Level : What level the player is and determines their overall prowess."
    +"\n      Experience : The amount of exp the player has accumelated, if the player reaches."
    +"\n- /exit (To quit the game)"
    +"\n- /menu (BATTLE/EVENT ONLY) type this command to display the following options:"
    +"\n      (1)View Stats."
    +"\n      (2)Heal."
    +"\n      (3)View Help instructions."
    +"\n      (4)Close menu."
    +"\n      (5)Exit Game."
    
    +"\n\nYour goal is to reach a certain level, when you do you are granted to fight the final boss."
    +"\nBe careful now! For if you ever reach your health down to 0, you are dead and have to restart all the way from the beginning."
    +"\nThere is only one way to cheat death and that is the usage of a fairy that you can only obtain from one event.";

    public GameController(Player player) {
        this.player = player;
    }

    
    public void selectPath() {
        while (player.isAlive()) {

            System.out.println("\nWhich path do you want to take?\n[1]Left?\n[2]Right? \n[3]Eat a Golden Apple (" + player.getApple() + "/4)");
            roomChoice = input.readInput(player);
            
        switch (roomChoice) {
            case "left":
            case "1":

                crossroads();
            if (player.getLevel() >= 10) {
            
                player.setFairy(0);
                clearScreen();
                Event e = eventControl.Ruins(player,input);
                e.execute(player, input);
                return;}
            
                break;

            case "right":
            case "2":

                crossroads();
            if (player.getLevel() >= 10) { 
            
                player.setFairy(0);
                clearScreen();
                Event e = eventControl.Ruins(player,input);
                e.execute(player, input);
                return; } 
            break;
            case "eat apple":
            case "3":
                clearScreen();
                player.heal(player);
                break;

            case "/stats":
                clearScreen();
                player.displayPlayerStats();
                break;
                
            case "/help":
                clearScreen();
                System.out.println(midInstructions);
                break;

            case "/exit":
                clearScreen();
                System.out.println("Game Shutting down...");
                System.exit(0);
                break;

            default:
                clearScreen();
                break;
            }


            if (!player.isAlive()) {
                if (player.getFairy() > 0) 
                {
                    clearScreen();
                    System.out.println("You died! But the fairy's blessing takes effect and restores you to maximum.");
                    player.setCurrentHp(player.maxHp);
                    player.setFairy(0);
                } else {
                    try
                    {
                        gameOver();
                    }
                    catch (InterruptedException e) {/* IGNORE */}
                    return;
                }
            }
        }
    }
    
    public void crossroads(){
        int randompath = random.nextInt(3);
        if(randompath == 1){
                if (player.getLevel() == 5) {
                clearScreen();
                Event e = eventControl.Level5(player);
                e.execute(player, input);
                } else if (player.getLevel() >= 10){
                    player.setFairy(0);
                clearScreen();
                Event e = eventControl.dragonFight(player,input);
                e.execute(player, input);
                return;
                }
                else {
                    clearScreen();
                    Event e = eventControl.generateEvent(player);
                    e.execute(player, input);
                }

        } else {
                if (player.getLevel() == 5) {
                clearScreen();
                Event e = eventControl.Level5(player);
                e.execute(player, input);
                } else if (player.getLevel() >= 10){
                    player.setFairy(0);
                clearScreen();
                Event e = eventControl.dragonFight(player,input);
                e.execute(player, input);
                return;
                }
                else {
                clearScreen();
                Battle battle = new Battle(player);
                battle.battle(player);
                }
        } 
    }
    
    public void gameOver() throws InterruptedException {
        System.out.println("You've died!");
        System.out.println("\nThis poor soul has perished, may darkness overtake them and drift away to the afterlife.");
        System.out.println("\nDo you want to retry? Press ENTER to exit to menu, type \"No\" to quit.");
        String playAgain = input.readInput(player);
        
        if (playAgain.equals("no") || playAgain.equals("n")) {
            clearScreen();
            System.out.println("|GAME OVER|");
            System.out.println("Game Shutting down...");
            System.exit(0);
        }
        clearScreen();
        }
    

    public void theEnd() {
        System.out.println("You've Reached the end!");
        System.out.println("\nDo you want to play again? Press ENTER to exit to menu, type \"No\" to quit.");
        String playAgain = input.readInput(player);

        if (playAgain.equals("no") || playAgain.equals("n")) {
            clearScreen();
            System.out.println("|GAME OVER|");
            System.out.println("Game Shutting down...");
            System.exit(0);
        }
        clearScreen();
    }

    public void endStory(InputHandler inputHandler) throws InterruptedException {
        System.out.println("You've reached the ancient ruins where the mighty dragon lives.");
        System.out.print("As you keep pacing towards the catacombs ");
        System.out.print("you start to feel immense dread as you get closer and closer.");
        System.out.print("\nThe despair you're feeling grows intensely, your legs shakes in fear.");
        System.out.println("\nPress Enter to Continue");
        input.readInput(player);
        System.out.println("As you approach the last room of the catacombs, the remains of an ancient altar.");
        System.out.print("You hear the foreboding bellows from the monster.");
        System.out.print(" The horror of it is immense, you stand hopeless.");
        System.out.println("\nPress Enter to Continue");
        input.readInput(player);  
        System.out.println("You make a feeble attempt to regain control of yourself.");
        System.out.print("Drawing your weapon and readying yourself for the beasts incoming attack.\n");
        System.out.print(".");
        System.out.print(".");
    }

    public void clearScreen() 
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    protected void pressEnterToContinue(Player player) {

        InputHandler input = new InputHandler();

        System.out.println("\nPress ENTER to continue");
        input.readInput(player);
    
    }
}
