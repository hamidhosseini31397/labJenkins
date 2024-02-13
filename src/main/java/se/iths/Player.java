package se.iths;


import java.util.concurrent.ThreadLocalRandom;


public class Player {

String name;
int currentHp;
int maxHp;
int attack;
int speed;
int level;
int experience;
int apple;
int fairy;
int excalibre;
int branch; 




Player(String name) {
this.name = name;
this.currentHp = 20;
this.maxHp = 20;
this.attack = 7;
this.speed = 10;
this.level = 1;
this.experience = 0;
this.apple = 3;
this.fairy = 0;
this.excalibre = 0;
this.branch = 0;
}


public boolean isAlive() {
    if (this.currentHp > 0) return true;
    else return false;
}

public void displayPlayerStats() {
    System.out.println("\nHP: " + currentHp + "/" + maxHp);
    System.out.println("Attack: " + attack);
    System.out.println("Speed: " + speed);
    System.out.println("Level: " + level);
    System.out.println("Current EXP: " + getExperience());
    System.out.println("Amount of Golden Apples: " + getApple() + "/4");
    if(excalibre==1){System.out.println("You possess the magical sword Excalibre.");}
    if (fairy==1){System.out.println("You have recieved the blessing of the Fairy Lady");}
    if(branch==1){System.out.println("You are carrying a branch, maybe it will come in handy.. Or maybe it wont.");}
    System.out.println();
}

public void attack(Enemy currentMonster) {

    double maxDamage = (attack*1.2);

    double calculateDamage = ThreadLocalRandom.current().nextDouble(attack, maxDamage);
    long roundedResult = Math.round(calculateDamage);
    int outgoingDmg = (int) roundedResult;

    currentMonster.decreaseHitPoints(outgoingDmg);

    System.out.println("You swing your weapon for " + outgoingDmg + " damage!");
}

public void heal(Player player){
    if(currentHp < maxHp && getApple() > 0) {
        eatApple();
        System.out.println("\nYou consumed a Golden Apple and restored your HP to max! HP: " + getCurrentHp() +"/" + getMaxHp() + "\n");
    } else if (currentHp == maxHp){
        System.out.println("\nYou are already at max health.\n");
    } else if (getApple() == 0) {
            System.out.println("\nYou are out of Golden Apples!\n");
    } else {
        return;
    }
}

public void levelUp() {
    level++;
    maxHp += 10;
    attack += 2;
    speed += 5;
    setCurrentHp(maxHp);
    System.out.println("Congratulations! You leveled up to level " + getLevel() + "!");
    reduceExperience(100);
}

//Attribute controllers:

public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}

public int getCurrentHp() {
    return currentHp;
}
public void setCurrentHp(int currentHp) {
    this.currentHp = currentHp;
}
public void addCurrentHp(int currentHp) {
    this.currentHp += currentHp;
    if (this.currentHp > maxHp){
        this.currentHp = maxHp;
        System.out.println("You are at full health.");
    }
}
public void decreaseCurrentHp(int currentHp) {
    this.currentHp -= currentHp;
    System.out.println(getName() + " HP: " + this.currentHp + "/" + this.maxHp + "\n");
}

public int getMaxHp() {
    return maxHp;
}
public void setMaxHp(int maxHp) {
    this.maxHp = maxHp;
}
public void addMaxHp(int maxHp) {
    this.maxHp += maxHp;
}
public void decreaseMaxHp(int maxHp) {
    this.maxHp -= maxHp;
}

public int getAttack() {
    return attack;
}
public void setAttack(int attack) {
    this.attack = attack;
}
public void addAttack(int attack) {
    this.attack += attack; 
}
public void decreaseAttack(int attack) {
    this.attack -= attack;
}

public int getSpeed() {
    return speed;
}
public void setSpeed(int speed) {
    this.speed = speed;
}
public void addSpeed(int speed) {
    this.speed += speed;
}
public void decreaseSpeed(int speed) {
    this.speed -= speed;
}
    
public int getLevel() {
    return level;
}
public void setLevel(int level) {
    this.level = level;
}

public int getExperience() {
    return experience;
}
public void setExperience(int experience) {
    this.experience = experience;
}
public void addExperience(int experience) {
    this.experience += experience;
    if(this.experience >= 100){
        levelUp();
    }  
}
public void reduceExperience(int experience){
    this.experience -= experience;
}

public int getApple() {
    return apple;
}
public void setApple(int apple) {
    this.apple = apple;
}
public void addApple(int apple) {
    this.apple += apple;
    if(this.apple > 4){
        this.apple = 4;
        System.out.println("You can only carry four apples. Your bag is full.");
    }
}
public void decreseApple(int apple){
    this.apple -= apple;
}
public void eatApple() {
    currentHp = maxHp;
    apple--;
}

public int getFairy() {
    return fairy;
}
public void setFairy(int fairy) {
    this.fairy = fairy;
}
public void addFairy(int fairy) {
    this.fairy += fairy;
}

public int getExcalibre() {
    return excalibre;
}
public void setExcalibre(int excalibre) {
    this.excalibre = excalibre;
}
public int getBranch() {
    return branch;
}
public void setBranch(int branch) {
    this.branch = branch;
}


}