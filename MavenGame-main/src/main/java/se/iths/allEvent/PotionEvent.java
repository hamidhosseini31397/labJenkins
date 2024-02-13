package se.iths.allEvent;

import se.iths.*;


public class PotionEvent extends Event {
    
    public PotionEvent() {
    super();
    this.eventLevel = 2;
    }

@Override
public void execute(Player player, InputHandler inputHandler) {

    System.out.println("In the heart of the kingdom, you stumble upon the Grand Apothecary's alchemy shop. " + 
            "The Grand Apothecary, a wise old man, said he knew about special herbs rumored to be extinct but he was convinced of the opposite. " + 
            "He tells you about a rare herb called Haloe Waera, concealed deep within a cave at the southern edge of the kingdom.");

            pressEnterToContinue(player);
            
            System.out.println("The Grand Apothecary senses your strength and determination and hands you a weathered map, pinpointing the exact location of the cave and asks you to aquire the herb for him. " +
            "He said that with this herb, he could make a potion to boost your health. " +
            "You ask if there's any dangers you should be aware of. The old man shrugs but you accept and prapare yourself accordingly before you set out.");
           
            pressEnterToContinue(player);

            System.out.println("With the map in hand you arrive at your destination. Through your efforts you establish that the cave has a labyrinth-like system. " + 
            "You enter and is taken by the illuminated soft glow of phosphorsent moss clinging to the walls. It's as if it's alive, whispering secrets to you. " + 
            "The air has a mysterious stillness to it.. It's almost intoxicating. " + 
            "You navigate through narrow passages and crystal-like chambers until you find something plant-like with luminescent, succulent green leaves arranged in a rosette. " +
            "They have sharp, pinkish spines along their edge and is quite thick, but yet soft. This must be it you think for yourself and pack as many as you can carry.");
            
            pressEnterToContinue(player);

            System.out.println("\nOnce you returned with the Haloe Waera and handed over the efforts of your gatheringexpedition, the Grand Apothecarys eyes sparkle with appreciation. " + 
            "He gives you a silent nod and begins to instruct you in the art of potion-making. Together, you brewed a concoction that held the essence of the Haloe Waera. " + 
            "Upon completion, you are presented with a bright lightgreen faintly glowing liquid in a crystal flask. Eager to experience it's effect " + 
            "you take a sip and feel an immediate surge of energy and vitality. The Grand Apothecary smiles knowingly, sharing a final piece of herbal wisdom before bidding you farewell." + 
            "\nMax HP: + 10\n");

            player.addMaxHp(10);
            player.addCurrentHp(10);
            gainEXP(player);


}


}

