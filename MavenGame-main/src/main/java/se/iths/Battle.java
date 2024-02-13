package se.iths;


import java.util.Random;
import java.util.Scanner;

public class Battle {
    Player player;
    Scanner scanner = new Scanner(System.in);
    InputHandler input = new InputHandler();

    public Dragon bossDragon = new Dragon("Dragonlord Silamgar");
    public Dragon bossDragon2 = new TolkienDragon("Smugg");
    public Dragon bossDragon3 = new WowDragon("DeafWing");
    public Dragon bossDragon4 = new PokeDragon("Charizarl");

    Dragon[] monsterEncounters = {bossDragon, bossDragon2, bossDragon3, bossDragon4};

    public Dragon getRandomBoss() {
        Dragon randomBoss = monsterEncounters[new Random().nextInt(monsterEncounters.length)];
        return randomBoss;
    }

    public void battle(Player player) {   
            Enemy currentMonster = new Enemy((player.getLevel()-1), (player.getLevel()+1));
            System.out.println("You are attacked by a vicious " + currentMonster.getName());
            while (player.isAlive()) {            
                if (player.getSpeed() >= currentMonster.getSpeed()) {
                    choosesAttackOrStats(currentMonster,player);
                    if (currentMonster.isAlive() == true) {
                        currentMonster.attack(player);
                    } else {
                        currentMonster.monsterDeath(player);
                        break;
                    }
                } else {
                    currentMonster.attack(player);
                    if(player.isAlive() == true) {
                        choosesAttackOrStats(currentMonster, player);
                    }
                    if (!currentMonster.isAlive()) {
                        currentMonster.monsterDeath(player);
                        break;
                    }                                                                          
                }
            }
    }
    
    public Battle(Player player) {  
        this.player = player;
    }

    public void choosesAttackOrStats(Enemy currentMonster, Player player) {
        String attackChoice= "";
        while (attackChoice != "1" || attackChoice != "2") {
            System.out.println("What do you want to do? \n[1] Attack the thing! \n[2] Heal. (" + player.getApple() + "/4)");
            attackChoice = input.readInput(player);
            if (attackChoice.equals("1")) {
                player.attack(currentMonster);
                System.out.println(currentMonster.getName() + " Current HP: " + currentMonster.getHitPoints());
                break;
            } else if (attackChoice.equals("2")) {
                player.heal(player);
                break;
            } else {
            }
        }
    }

    public void dragonFight(Dragon bossDragon, Player player) {
        final Dragon currentBoss = (Dragon) getRandomBoss();
        currentBoss.introduce(player);
        if (dragonKillsPlayer() == true) {
            currentBoss.killsPlayer(player);
        } else {
            currentBoss.killsDragon(player);
        }
    }

    public boolean dragonKillsPlayer() {
        if (player.excalibre == 1) {
            return false;
        } else {
            return true;
        }
    }
}
