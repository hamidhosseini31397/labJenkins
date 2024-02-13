package se.iths;


import java.util.Scanner;

public class AdventureGame {
    boolean gameOver = false;

    public static void main(String[] args) throws InterruptedException {
        MenuController menu = new MenuController();

        clearScreen();
        title();
        
        while (true) {
            mainMenu();
            menu.selectOption();
        }
    }

    public static String inputName(Scanner userInput) {
        boolean nameEmpty = true;
        String name = "";
        while (nameEmpty) {

            System.out.println("\nWhat is your name? ");
            name = userInput.nextLine();
            if (name.length() != 0) {
                nameEmpty = false;
            } else {
                System.out.println("Incorrect input, empty! Please type in a name.");
            }
        }
        return name;
    }

    public static void title() throws InterruptedException {

        System.out.print("PERFECTLY ");
        Thread.sleep(200);
        System.out.print("ACCEPTABLE ");
        Thread.sleep(200);
        System.out.print("ADVENTURE ");
        Thread.sleep(200);
        System.out.print("OF ");
        Thread.sleep(200);
        System.out.print("A ");
        Thread.sleep(250);
        System.out.print("MUNDANE ");
        Thread.sleep(200);
        System.out.print("SOMEBODY");
        Thread.sleep(200);
        System.out.print("\n                      2023 EDITION");
        clearScreen();

        for (int i = 0; i < 20; i++) {

            Thread.sleep(50);
            System.out.println("PERFECTLY ACCEPTABLE ADVENTURE OF A MUNDANE SOMEBODY\n                      2023 EDITION");
            clearScreen();
        }
    }

    public static void trueEndStory() {

        System.out.println("You win");
    }

    public static void clearScreen() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void mainMenu() throws InterruptedException {
        
        System.out.println("PERFECTLY ACCEPTABLE ADVENTURE OF A MUNDANE SOMEBODY\n                      2023 EDITION");
        Thread.sleep(600);
        System.out.println("\nPlease type the number or write one of the choices below.");
        Thread.sleep(200);
        System.out.println("[1]Start");
        Thread.sleep(200);
        System.out.println("[2]Help");
        Thread.sleep(200);
        System.out.println("[3]Quit");
    }
}
