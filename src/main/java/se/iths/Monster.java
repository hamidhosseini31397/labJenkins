package se.iths;


public enum Monster {
    
    GOBLIN ("Goblin", 25, 2, 5, 2, 15, 50, false),
    WOLF("Wolf", 30, 3, 4, 2, 20, 40, false),
    GNOLL("Gnoll", 20, 5, 8, 2, 20, 50, false),
    ELF("Elf", 35, 8, 12, 3, 30, 60, false),
    ORC("Orc", 50, 6, 7, 3, 25, 50, false),
    DIRE_WOLF("Dire wolf", 35, 8, 10, 3, 40, 60, false),
    GIANT_SPIDER("Giant spider", 45, 4, 14, 4, 35, 70, false),
    BEAR("Bear", 55, 8, 12, 4, 30, 70, false),
    BANDIT("Bandit", 50, 10, 15, 5,25, 50, false),
    OGRE("Ogre", 75, 14, 16, 6, 40, 50, false),
    TROLL("Troll", 95, 5, 20, 6, 25, 60, false),
    WURM("Wurm", 70, 12, 15, 6, 45, 50, false),
    VAMPIRE("Vampire", 80, 18, 24, 7, 250, 70, true),
    WEREWOLF("Werewolf", 90, 25, 35, 7, 50, 70, false),
    DEMON("Demon", 120, 20, 40, 8, 80, 80, false),
    CHIMERA("Chimera", 150, 20, 45, 9, 90, 90, false);

    String name;
    int hp;
    int minAttack;
    int maxAttack;
    int level;
    int speed;
    int expGiven;
    boolean lifesteal;

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMinAttack() {
        return minAttack;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public int getLevel() {
        return level;
    }

    public int getSpeed() {
        return speed;
    }

    public int getExpGiven() {
        return expGiven;
    }

    public boolean isLifesteal() {
        return lifesteal;
    }


    Monster(String name, int hp, int minAttack, int maxAttack, int level, int speed, int expGiven, boolean lifesteal) {
        this.name = name;
        this.hp = hp;
        this.minAttack = minAttack;
        this.maxAttack = maxAttack;
        this.level = level;
        this.speed = speed;
        this.expGiven = expGiven;
        this.lifesteal = lifesteal;
    }

}
