package se.iths;


import java.util.Scanner;

public class InputHandler {
    Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String readInput(Player player) {
        GameController gc = new GameController(player);

        String input = scanner.nextLine();

        if ("/exit".equals(input.toLowerCase())) {
            System.out.println("Exiting the program.");
            System.exit(0);

        } else if ("/stats".equals(input.toLowerCase())) {
            player.displayPlayerStats();
            System.out.println("Press ENTER to close.");
            scanner.nextLine();

        } else if ("/help".equals(input.toLowerCase())) {
            gc.clearScreen();
            System.out.println("\n" + gc.midInstructions + "\n");
            System.out.println("Press ENTER to close.");
            scanner.nextLine();
        }
        else if ("/menu".equals(input.toLowerCase())){
            boolean menu = true;
            while (menu){
                System.out.println("Main Menu: \n(1) View Stats. \n(2) Heal.    Apples: " + player.getApple() + "/4. \n(3) View Help instructions. \n(4) Close Menu. \n(5) Exit Game.");
                String choice = scanner.nextLine();
                switch(choice){
                    case "1":
                    player.displayPlayerStats();
                    System.out.println("Press ENTER to close.");
                    scanner.nextLine();
                    break;
                    case "2":
                    player.heal(player);
                    break;
                    case "3":
                    gc.clearScreen();
                    System.out.println("\n" + gc.midInstructions + "\n");
                    System.out.println("Press ENTER to close.");
                    scanner.nextLine();
                    break;
                    case "4":
                    menu=false;
                    break;
                    case "5":
                    System.out.println("Are you sure you want to exit the game? \n(1) Yes \n(2) No, return to game.");
                    String exit = scanner.nextLine().toString();
                    if(exit.equals("1")){
                        System.out.println("Exiting the program.");
                        System.exit(0);
                    } else {}
                    default:
                }
            }
        }
        return input.toLowerCase();
    }



}