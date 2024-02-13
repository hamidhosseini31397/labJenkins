package se.iths;


import java.util.Random;

public class Weapon 
{
    private String[] qualityCommon = {"Rusty","Worn-down","Weathered","Chipped","Broken","Blunt"}; 
    private String[] qualityUncommon = {"Normal","Regular","Forged","Standard","Ordinary","Simple"};
    private String[] qualityRare = {"Sharpened","Enchanted","Tempered","Fine-edge","Remarkable","Enhanced"};
    private String[] qualityEpic = {"Master","Magical","Unique","Elite","Relic","Mythic"};
    private String[] weaponType = {"Sword","Mace","Dagger","Club","Axe","Greatsword"};
    //private String[] legendaryWeapons = {"Mastersword",}
    private Random index = new Random();
    private int dropQuality;
    private int dropType;
    private int qualityIndex;

    Weapon(int quality)
    {
        dropQuality = quality;
        qualityIndex = index.nextInt(qualityCommon.length);
        dropType = index.nextInt(weaponType.length);
    } 

    @Override
    public String toString() {
        String result = "This text should never appear, scream and run if it does.";
        switch (dropQuality) {
            case 0:
                result = qualityCommon[qualityIndex];
                break;
            case 1:
                result = qualityUncommon[qualityIndex];
                break;
            case 2:
                result = qualityRare[qualityIndex];
                break;
            case 3:
                result = qualityEpic[qualityIndex];
                break;
        }
        return result + " " + weaponType[dropType];
    }
}