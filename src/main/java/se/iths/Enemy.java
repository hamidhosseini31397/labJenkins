package se.iths;


import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Enemy {
    Random randomgen = new Random();

    protected String name;
    protected int hitPoints;
    protected int minAttack;
    protected int maxAttack;
    protected int level;
    protected int speed;
    protected int expGiven;
    protected boolean lifesteal;
    
    public Enemy(String name, int hitPoints, int minAttack, int maxAttack, int level, int speed, int expGiven, boolean lifesteal) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.minAttack = minAttack;
        this.maxAttack = maxAttack;
        this.level = level;
        this.speed = speed;
        this.expGiven = expGiven;
        this.lifesteal = lifesteal;
    }

    Enemy(int lower, int upper) {
        List<Monster> monsterList = Arrays.asList(Monster.values());
        List<Monster> filteredMonsterList = monsterList.stream()
            .filter((monster) -> (monster.getLevel() >= lower && monster.getLevel() <= upper))
            .collect(Collectors.toList());

        Monster monster = filteredMonsterList.get(randomgen.nextInt(filteredMonsterList.size()));

        name = monster.getName();
        hitPoints = monster.getHp();
        minAttack = monster.getMinAttack();
        maxAttack = monster.getMaxAttack();
        level = monster.getLevel();
        speed = monster.getSpeed();
        expGiven = monster.getExpGiven();
        lifesteal = monster.isLifesteal();
    }

    public int getHitPoints() {
        return hitPoints;
    }
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public int getLevel() {
        return level;
    }
    public void decreaseHitPoints(int hitPoints) {
        this.hitPoints -= hitPoints;
    }
    public void attack(Player player) { 
        int attackDmg = ThreadLocalRandom.current().nextInt(minAttack, maxAttack + 1);
        System.out.println("The " + name + " attacks you for " + attackDmg);
        player.decreaseCurrentHp(attackDmg);

        if (lifesteal) {hitPoints += (attackDmg/2);
        System.out.println("It heals from your blood.");}
    }

    public void monsterDeath(Player player) {
       System.out.println("You killed the " + name + " and got " + expGiven + " experience."); 
       player.addExperience(expGiven); 
    } 

    public boolean isAlive() {
        if (hitPoints > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void introduce()  throws InterruptedException {}
}



