package se.iths;


import java.util.Scanner;

public class IntroductionBattle {
    Player player;
    InputHandler input = new InputHandler();
    Scanner userInput = new Scanner(System.in);

    Enemy slime = new Enemy("Slime", 20, 6, 7, 1, 20, 100, false);

    public IntroductionBattle(Player player) {
        this.player = player;
    }

    public void introBattle(Player player) {
        Enemy currentMonster = slime;
        System.out.println("\nThe slime sludges towards you. It looks just like a blob of goo and you wonder why everyone seems so afraid of such a harmless looking thing. \n\nLost in your thoughts you fail to be vigilant and quickly have to pay the price. ");

        while (player.isAlive()) 
        {
            if (player.getSpeed() >= currentMonster.getSpeed()) 
            {
                choosesAttackOrStats(currentMonster, player);
                if (currentMonster.isAlive() == true) 
                {
                    currentMonster.attack(player);
                    if (!player.isAlive()) {return;}
                } 
                else 
                {
                    currentMonster.monsterDeath(player);
                    break;
                }
            } 
            else {

                currentMonster.attack(player);
                if (player.isAlive()) 
                {
                    if(player.getCurrentHp()<10){
                        System.out.println("The monster hits hard. Eat a Golden apple to Heal.");
                    }
                    choosesAttackOrStats(currentMonster, player);
                }
                if (!currentMonster.isAlive()) 
                {
                    currentMonster.monsterDeath(player);
                    System.out.println(midStory);
                    break;
                }
            }

            if (!player.isAlive()) 
            {
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

    void choosesAttackOrStats(Enemy currentMonster, Player player) {
        String attackChoice = "";
        while (attackChoice != "1" || attackChoice != "2") {
            System.out.println("\nWhat do you want to do? \n[1] Attack! \n[2] Heal. ( " + player.getApple() + "/4)");
            attackChoice = userInput.nextLine();
            if (attackChoice.equals("1")) {
                player.attack(currentMonster);
                System.out.println(currentMonster.getName() + ":  HP: " + currentMonster.getHitPoints());
                break;
            }
            else if (attackChoice.equals("2")) {
                player.heal(player);
                break;
            }
            else {
                System.out.println("Incorrect input.");
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

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    String midStory = "\nAfter your valiant victory against the slime you come across two paths."
            + "\nYou feel confident in your adventure, ready to take on any challenge ahead."
            + "\nOne path leading to the left, another leading to the right." + "\n\nWhich path do you take?";

   
}
