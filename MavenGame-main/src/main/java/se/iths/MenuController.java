package se.iths;


public class MenuController {
    InputHandler input = new InputHandler();
    boolean storyOnce = false;
    boolean introStoryOnce = false;


    public Player selectOption() {
        String menuChoice = input.readInput(null);
        String name;
        Player player = null;

        switch (menuChoice) {
            case "start":
            case "1":
                clearScreen();
                while(!storyOnce)
                {
                    try 
                    {
                        beginStory(input);
                    }
                    catch (InterruptedException e) {/* IGNORE */}
                    storyOnce = true;
                }
                name = inputName(input);
                player = new Player(name);
                clearScreen();
                while(!introStoryOnce)
                {
                    try
                    {
                        introStory();
                    }
                    catch (InterruptedException e) {/* IGNORE */}
                    introStoryOnce = true;
                }
                IntroductionBattle introBattle = new IntroductionBattle(player);
                introBattle.introBattle(player);
                player.setApple(4);
                GameController game = new GameController(player);
                game.selectPath();
                return player;

            case "help":
            case "2":
                clearScreen();
                System.out.println(instructions);
                input.readInput(player);
                clearScreen();
                break;

            case "quit":
            case "3":
                System.out.println("Game Shutting down...");
                input.readInput(player);
                System.exit(0);
                break;

            default:
                clearScreen();
                System.out.println("Incorrect input! Please try again.");
                break;
        }
        return player;
    }
    
    String instructions =
        "In this game you will go through a series of encounters where the goal of the game is to reach the end."
        + "\nEach room will prompt you with a path of either left or right and present an event."
        + "\nThese events could either be in the form of combat against monsters or an event that will further prompt you to make a decision."
        + "\nThese events can either reward or punish the player."
        
        + "\n\nThe player character and monsters has a set of stats, these are:"
        + "\n- HP : How much health the player/monster has." 
        + "\n- Attack : How much minimum damage the player and the monster can output, the maximum output is randomized."
        + "\n- Level : What level the player is and determines their overall prowess."
        + "\n- Speed : How dexterous either one is, the one that has more than the other fights first."
        + "\n- Experience : This is received whenever a task is completed or after defeating a monster. Accumulate enough and you rise in level."
        + "\nYou as the player also has a set of apples that whenever eaten will fully rejuvenate you."
        + "\nUseful if you've taken a large amount of damage."
        
        + "\n\n Whenever in-game you can also type the following commands:"
        + "\n- /menu: Shows a menu with options.\nView Stats - Shows your character stats. \nHeal - Consumes an apple and restore health \nView help intructions - shows instructions.\nClose menu - Closes the menu. \nExit game - Will ask if you want to close the game and then Exit game at positive answer.\n"

        
        + "\n\nGood luck \"mundane somebody\"!" + "\n\nPress ENTER to return to menu.";
    
    public String inputName(InputHandler inputHandler) {
        boolean nameEmpty = true;
        String name = "";
        while (nameEmpty) {
            System.out.println("\n\nWhat is your name? ");
            name = input.readInput(null);

            if (name.length() != 0) {
                nameEmpty = false;
            }
            else {
                System.out.println("Incorrect input, empty! Please type in a name.");
            }
        }
        return name;
    }

    public void beginStory(InputHandler inputHandler) throws InterruptedException {
        System.out.println(">|GAME START|<");
        Thread.sleep(1500);
        clearScreen();
        Thread.sleep(1000);
        System.out.println("This is an era of Monsters, Beasts and Badmen.");
        Thread.sleep(2000);
        System.out.println("Aswell as Great Magic and Mighty Steel.");
        Thread.sleep(2000);
        System.out.println("These lands are ridden with fear and strife.");
        Thread.sleep(2000);
        System.out.println("In these times a great warrior is needed, a saviour of true heroism.");
        Thread.sleep(2000);
        System.out.print("This \"warrior\"... ");
        Thread.sleep(2000);
        System.out.print("is not you.");
        Thread.sleep(500);
        System.out.print("\nInstead you are; ");
        Thread.sleep(600);
        System.out.print("average joe, ");
        Thread.sleep(600);
        System.out.print("mundane, ");
        Thread.sleep(600);
        System.out.print("milquetoast.");
        Thread.sleep(1500);
        System.out.println("\nYou decided however that your current occupation wasn't worth your time anymore.");
        Thread.sleep(2000);
        System.out.println("You then made the decision that adventuring was a bigger endavour worthy of your commitment");
        Thread.sleep(2000);
        System.out.println("You ready up, equip whatever you have in your possession.");
        Thread.sleep(2000);
        System.out.println("You also grab your grandfathers rare \"Holy Golden Apples\", said to have the ability to heal any wound.");
        Thread.sleep(2000);
        System.out.println("You leave and never look behind back at your old life...");
        Thread.sleep(2000);
        System.out.println("Press ENTER to begin your adventure.");
        input.readInput(null);

    }

    public static void introStory() throws InterruptedException 
    {
        System.out.println("After hearing a commotion of a giant beast nearby your village, you ask the men if you could hear more about this. One of them tells you:");
        Thread.sleep(3000);
        System.out.print("\n -That damned bleeding monstrosity is holding us at standstill!");
        Thread.sleep(3000);
        System.out.print(" I've needed to deliver this shipment for the past 2 weeks!");
        Thread.sleep(3000);
        System.out.println("\n Matter of fact, everyone in this village here has some deliveries to be made but can't, in fear of the beast.");
        Thread.sleep(3000);
        System.out.println("\nYou then tell the man that you think you could handle the monster.");
        Thread.sleep(3000);
        System.out.print("\n -You?");
        Thread.sleep(1500);
        System.out.print(" You want to take care of it?");
        Thread.sleep(2500);
        System.out.print(" You look like nuthin' but a milksop!");
        Thread.sleep(3000);
        System.out.print(" A run-of-the-mill farmer!");
        Thread.sleep(3000);
        System.out.println("\n What could you possibly offer rather than what hero or knight could?");
        Thread.sleep(3000);
        System.out.println("\nYou blankly stare at the man and simply tell them: \"I'll do it for free.\"");
        Thread.sleep(3000);
        System.out.println("The man raises one eyebrow, visibly confused by your words but simply shrugs and says: ");
        Thread.sleep(3000);
        System.out.print("\n -well if it is a deathwish you want then so be it.");
        Thread.sleep(3000);
        System.out.print(" At least we won't have to pay for your failures.");
        Thread.sleep(3000);
        System.out.print("\n Alright if you want to take this one then I'll at the very least guide you to the path.");
        Thread.sleep(3000);
        System.out.print("\n\nThe man shows you to the path and lets you off,");
        Thread.sleep(3000);
        System.out.print(" you venture forth the path leading towards the catacombs.");
        Thread.sleep(3000);
        System.out.print("\nYou've tread for some time now and suddenly hear something.");
        Thread.sleep(1500);
        System.out.print(".");
        Thread.sleep(1500);
        System.out.print(".");
        Thread.sleep(2000);
        System.out.print(" Tis a slime that appears! Draw your weapon and ready yourself for battle!\n");
        Thread.sleep(3000);
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}