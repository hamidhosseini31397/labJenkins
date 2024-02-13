package se.iths.allEvent;

import se.iths.*;


public class AncientRuinsEvent extends Event {

public AncientRuinsEvent() {
    super();
    this.eventLevel = 20;
}

@Override
public void execute(Player player, InputHandler input) {
    Event dragonFight = new DragonFightEvent();
    System.out.println("The path takes you to the mighty dragons lair. As you step inside the ruins you find a mysterious altar in the first chamber.");
        System.out.println("Do you want to approach the altar? \n[1] Yes \n[2] No");
        String altarChoice = input.readInput(player);
            switch (altarChoice) {
                case "1":
                int outcome = randomgen.nextInt(3);
                if (outcome == 0) {
                    System.out.println("Approaching the altar, you feel a surge of power!");
                    System.out.println("It's time to kick ass and chew bubblegum and you're all out of gum.\nYou gain a level!");
                        player.levelUp();
                } else if (outcome == 1) {
                    System.out.println("The ancient spirits are angered!");
                    System.out.println("You take an arrow to the knee, lose some HP and your speed is reduced!\nSpeed: - 10 \n Current HP: - 5");
                        player.decreaseSpeed(10);
                        player.decreaseCurrentHp(5);
                } else {
                    System.out.println("The altar seems dormant, but you hear a faint voice echo: 'Do a barrel roll!'");
                    System.out.println("Do a barrel roll? \n[1] Yes \n[2] No");
                    String userChoice = input.readInput(player);
                        if(userChoice.equalsIgnoreCase("1")) {
                            System.out.println("Understanding and paying homage to a classic gaming advice you perform an amazing barrel roll, successfully dodging a poisonous arrow fired at you from behind!");
                            System.out.println("You feel light on your feet.");
                            player.addSpeed(10);
                        } else if(userChoice.equalsIgnoreCase("2")) {
                            System.out.println("You have no context to the expression and stand too long lost in thought and get hit in the back by a poisonus arrow!");
                            System.out.println("The posion spreads fast and you can feel all your senses numbing. While laying there you suddenly question if you remembered to lock your door before you embarked on this adventure..");
                            player.setCurrentHp(0);
                            return;
                        }
                } 
                break;
             case "2":
                System.out.println("You decide not to approach the altar and continue exploring");
            }
            System.out.println("As you explore the room you find two possible paths. One leads down to your left, to the catacombs where the mighty dragon is said to live. The other is branching off to your right. Magic seems to radiate from the passage. Which way do you want to go? \n[1] Left. To the dragon! \n[2] Right. The mystery is compelling you.");
            String dragonordream = input.readInput(player);
            if(player.getExcalibre()==1){
                dragonordream = "1";
                System.out.println("You feel the magical sword draw you towards the left stairs. You decide to go to the dragon.");
            }
            if(dragonordream.equals("1")){
                System.out.println("The moment you step down the stairs a large metal door slams shut behind you. There is no way back.");
                dragonFight.execute(player,input);
            }
            else{
                System.out.println("The right path is soon covered in luminous moss and you feel drawn towards something. The air is heavy with a sweet scent and you start to feel drowsy.");
                System.out.println("You continue forward with increasingly heavy steps until you has to sit down and rest. You can barely keep your eyes open.");
                System.out.println("Before you know it you feel your mind slipping and when you open your eyes the world has a shimmering tint and you wonder if you might be dreaming. You get up and your body feel strangely light. Something is not right but you can't put your finger on what it is.");
                input.readInput(player);
                System.out.println("The walls are covered in strange shrooms foreign to the world you know and as you keep walking they start to dance in front of your eyes.");
                System.out.println("You reach a large field of wildflowers and stop to blink. Were you not in the ruins just now?");
                System.out.println("The sky is bright with lilac swirls and you are sure you are dreaming even before you spot the enormus dragon snoozing on the blueish grass. You step back in surprise and the dragon lifts it's head.");
                System.out.println("'Who dares disturb my sleep?' the dragon growls and you turn to run but the path behind you has transformed into an endless field of flowers.");
                input.readInput(player);
                Speak(player, input);
                return;
                }
}


public void Speak(Player player, InputHandler inputHandler){
    boolean speakChoice = true;
    while(speakChoice){
        System.out.println("What do you do next? \n[1] Attack the Dragon. \n[2] Speak to the Dragon.");
        String speak = input.readInput(player);
        switch (speak){
            case "1":
            System.out.println("You raise your weapon and charge. You have nothing to lose.");
            dreamBattle(player, inputHandler);
            speakChoice = false;
            return;
            case "2":
            System.out.println("'I'm terribly sorry to have disturbed you. I am lost and only wish to ask for directions.'");
                System.out.println("The dragon huffs as it slithers closer to look at you. You should be shaking with fear but feel strangely calm.");
                System.out.println("'Lost in a dream, never to wake. I have no directions to offer a tiny human soul that have wandered into my prison.'");
                System.out.println("Dream? Prison? What is this place? Who are you?");
                System.out.println("The dream of Ataraxia. The prison that has been my home for a very long time. I no longer remember my name.");
                input.readInput(player);
                System.out.println("Is there no way out?"); 
                System.out.println("'For me? No.. Only death will release me from this place. And death comes slow to dragonkind.'");
                System.out.println("'And for me?' you ask, feeling despair growing in your chest.");
                System.out.println("The dragon looked down at you sadly. The answer in it's eyes all you needed.");
                Resign(player, inputHandler);
                speakChoice = false;
                return;
            }
    }
   
}
public void Resign(Player player, InputHandler inputHandler){
    boolean stay = true;
    while(stay){
        System.out.println("What do you do next? \n[1] Attack the Dragon. \n[2] Resign to your fate.");
        String resign = input.readInput(player);
        switch (resign){
            case "1":
            System.out.println("You raise your weapon and charge. You have nothing to lose.");
            dreamBattle(player, inputHandler);
            stay = false;
            return;
            case "2":
            System.out.println("You sigh and drop your weapon. Accepting that you never were a Hero to begin with and that you shouldn't have left your home. You trudged over to the dragon and slumped down on the blue grass.");
            System.out.println("'I guess this is my prison now too. I hope you dont mind some company.'");
            System.out.println("The dragon hummed and looked down at you.");
            System.out.println("'I don't. It is terribly lonely in this place. What is your name, mortal?'");
            System.out.println("'" + player.getName() + "'");
            System.out.println("'Welcome, " + player.getName() + ", to the end of your life.");
            stay = false;
            return;
        }
    }
}
public void dreamBattle(Player player, InputHandler inputHandler){
        Event HeroDream = new HeroDream();
        HeroDream.execute(player, inputHandler);
                if (!player.isAlive()) {
                    System.out.println("The dream endend abruptly. You found yourself rapidly bleeding out on the floor. You were not the hero. You should've known. I warned you right from the start.");
                    return;}
                System.out.println("The dream ended abruptly and you found yourself back in the ruins. You felt so shaken by your experience your whole body was trembling violently. You looked down at your hands and came to a conclusion.");
                System.out.println("One dragon was enough. You had proven yourself and now you wanted to go home. You were no hero. And that was completely fine.");
                System.out.println("The End");
                input.readInput(player);
}


}
    
    

