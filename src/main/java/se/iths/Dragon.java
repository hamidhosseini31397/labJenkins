package se.iths;

public class Dragon {
    String name;
    public Dragon(String name) {
        this.name = name;
    }

    public void introduce(Player player) {
    }

    public void killsPlayer(Player player) {
    }

    public void killsDragon(Player player) {
    }
}

class MTGDragon extends Dragon {
    public MTGDragon(String name) {
        super(name);
    }
    public void introduce(Player player) {
        InputHandler input = new InputHandler();
        System.out.println("A mighty dragon rears up infront of you."); 
        System.out.println("With it's huge fangs and golden ornaments it looks absolutely dominant.");
        System.out.println("- Who do you think you are to stand before the mighty Dragonlord Silamgar?");
        System.out.println("It's hissing voice fills the air like a thousand snakes all at once.");
        System.out.println("- I have sneared countless bodies to serve me even after their life have left them!");
        System.out.println("- I tricked the fierce Khan Tasigur and made him into a pendant.");
        System.out.println("You see that he does have what seems like a withered body hanging around"); 
        System.out.println("his neck in a golden chain, with links the size of your shoes.");
        System.out.println("- I have even tricked death itself, and you think that YOU can kill me?");
        System.out.println("What's left of your body will serve me eternally");
        Boolean attack = true;
        while (attack){            
            System.out.println("\nWhat do you want to do? \n[1] Attack the Dragon! \n[2] Heal.");
            String choice = input.readInput(player);
            if(choice.equals("1")){
                attack=false;
                break;
            } else if (choice.equals("2")) {
                player.heal(player);    
            }
        }
    }


    public void killsPlayer(Player player) {
    InputHandler input = new InputHandler();
        System.out.println("The dragon laughs at your feeble attempt before it rears its neck and shoots out a spray of dark green fluid.");
        System.out.println("You cannot dodge. As it hits you your flesh begins to boil, your skin falls to the ground in big patches");
        System.out.println("and your body follows soon after. Your screams of agony echo for a long time.");
        System.out.println("You have died a horrible death. It was to be expected though.");
        System.out.println("I told you in the beginning... you are not the hero.");
        System.out.println("Press Enter to continue."); 
        input.readInput(player);     

    }

    public void killsDragon(Player player) {
        InputHandler input = new InputHandler();
        System.out.println("You brandish your magnificent sword, and with a powerfull swing create a beautiful arc.");
        System.out.println("The air warps and shoots out from where your sword swung.");
        System.out.println("The dragon's head slides of it's neck from a cut so clean that it was impossible to see.");
        System.out.println("You have slain the mighty Dragonlord Silamgar and freed the area of it's taint");
        System.out.println("Who would have known... you were a hero after all.");
        System.out.println("Press Enter to continue."); 
        input.readInput(player);

    }    
    
}

class TolkienDragon extends Dragon {
    public TolkienDragon(String name) {
        super(name);
    }
    public void introduce(Player player) {
        InputHandler input = new InputHandler();
        System.out.println("An opening that reveals a huge room you and a powerful but sly voice greets you in the doorway."); 
        System.out.println("- A little thief is it? Coming to steal what's mine?");
        System.out.println("A collosal dragon is laying ontop of a mountain of gold.");
        System.out.println("It Looks towards you and smiles.");
        System.out.println("- How nice! A little snack is coming straight to me.");
        System.out.println("- Are you perhaps hoping to get your hands upon some of my treasure? Maybe even this?");
        System.out.println("It holds a big blue-white stone that shines with an inner light."); 
        System.out.println("The dragon laughs loudly. - The Akrenstone is mine!");
        System.out.println("- You will not leave here with any gold little thief.");
        System.out.println("- Be honored. Today you'll be the meal to Smugg.");
        Boolean attack = true;
        while (attack){            
            System.out.println("\nWhat do you want to do? \n[1] Attack the Dragon! \n[2] Heal.");
            String choice = input.readInput(player);
            if(choice.equals("1")){
                attack=false;
                break;
            } else if (choice.equals("2")) {
                player.heal(player);    
            }
        }
    }

    public void killsPlayer(Player player) {
        InputHandler input = new InputHandler();
        System.out.println("Smuggs long neck snapps out and the last thing you see are rows of sharp teeth and a curling tounge.");
        System.out.println("You cannot dodge.");
        System.out.println("You have died and it was to be expected.");
        System.out.println("I told you in the beginning... you are not the hero.");
        System.out.println("Press Enter to continue."); 
        input.readInput(player);      

    }

    public void killsDragon(Player player) {
        InputHandler input = new InputHandler();
        System.out.println("You brandish your magnificent sword, and with a powerfull swing create a black spear like shape.");
        System.out.println("It shoots out and hits the dragon in its chest, right where a small scar has left the skinn exposed.");
        System.out.println("The dragon collapses and breathes its last rasping breath.");
        System.out.println("You have slain the mighty Dragon Smugg and the pile of gold can be destributed to the people.");
        System.out.println("Who would have known... you were a hero after all.");
        System.out.println("Press Enter to continue."); 
        input.readInput(player);
    } 
}

class WowDragon extends Dragon {
    public WowDragon(String name) {
        super(name);
    }

    public void introduce(Player player) {
        InputHandler input = new InputHandler();
        System.out.println("You enter a room that is dark and quiet."); 
        System.out.println("In the back you see two eyes glowing, staring at you.");
        System.out.println("It approaches you silently.");
        System.out.println("Suddenly you hear a whisper coming from nowhere. - That is Naltherion. The dragon aspect.");
        System.out.println("- He currently goes under the name Deafwing and is corrupted by the old gods.");
        System.out.println("- We, the other aspects will try to help you in your fight to kill him and cleanse his spirit.");
        System.out.println("You feel emboldened by those words, wherever they are coming from."); 
        Boolean attack = true;
        while (attack){            
            System.out.println("\nWhat do you want to do? \n[1] Attack the Dragon! \n[2] Heal.");
            String choice = input.readInput(player);
            if(choice.equals("1")){
                attack=false;
                break;
            } else if (choice.equals("2")) {
                player.heal(player);    
            }
        }
    }

    public void killsPlayer(Player player) {
        InputHandler input = new InputHandler();
        System.out.println("The dragon fills the space with fire.");
        System.out.println("Deafwing does not even utter a sound as your body becomes ash and you perish from this world.");
        System.out.println("I told you in the beginning... you are not the hero.");
        System.out.println("Press Enter to continue.");
        input.readInput(player);
    }

    public void killsDragon(Player player) {
        InputHandler input = new InputHandler();
        System.out.println("You brandish your magnificent sword, and with a powerfull swing creating the image of a golden disc.");
        System.out.println("The disc shoots out towards the dragon and mid-flight the image of four other dragons apear alongside the disc.");
        System.out.println("They all crash into the dragon, which disappears in a cloud of purple light.");
        System.out.println("You have defeated the dragon Deafwing and life will one again flurish.");
        System.out.println("Who would have known... you were a hero after all.");
        System.out.println("Press Enter to continue.");
        input.readInput(player);
    }

}

class PokeDragon extends Dragon {
    public PokeDragon(String name) {
        super(name);
    }

    public void introduce(Player player) {
        InputHandler input = new InputHandler();
        System.out.println("You see a kind of chubby and round orange dragon."); 
        System.out.println("It looks more cuddly than frightening except for the claws on it's three fingered hands");
        System.out.println("and the tail that... is on fire?");
        System.out.println("With a roaring voice it says");
        System.out.println("- Char! Char char Charizal!");
        System.out.println("...");
        System.out.println("You stand dumbfounded..."); 
        System.out.println("You try to look around to see if there is some other thing that is the real monster.");
        System.out.println("Seeing nothing you decide to move closer.");
        Boolean attack = true;
        while (attack){            
            System.out.println("\nWhat do you want to do? \n[1] Attack the Dragon! \n[2] Heal.");
            String choice = input.readInput(player);
            if(choice.equals("1")){
                attack=false;
                break;
            } else if (choice.equals("2")) {
                player.heal(player);    
            }
        }
    }

    public void killsPlayer(Player player) {
        InputHandler input = new InputHandler();
        System.out.println("You swing your weapon at the same time as the dragon swipes at you with it's tail.");
        System.out.println("The flaming tail hit your weapon that immediately begins to melt from the heat.");
        System.out.println("The dragon jumps up and slams into you, breaking several ribs and your back.");
        System.out.println("The pain is surreal and the last thing you see before eternal darkness consumes you is... the dragon dabbing?");
        System.out.println("I told you in the beginning... you are not the hero.");
        System.out.println("Press Enter to continue.");
        input.readInput(player);       
    }

    public void killsDragon(Player player) {
        InputHandler input = new InputHandler();
        System.out.println("You brandish your magnificent sword, and with a powerfull swing creating the image of a wierd looking sphere.");
        System.out.println("It has a black top with yellow marking, a black indented band around is equator and a white bottom half.");
        System.out.println("The sphere hits the dragon which seems to be sucked in to it.");
        System.out.println("All of a sudden they are both gone.");
        System.out.println("You have defeated the dragon Charizal and sent it back where it belong.");
        System.out.println("Who would have known... you were a hero after all.");
        System.out.println("Press Enter to continue.");
        input.readInput(player);
    } 
}

