package se.iths.allEvent;

import se.iths.*;

public class AbandonedMinesEvent extends Event {
    
boolean isAlive;

    public AbandonedMinesEvent() {
    super();
    this.eventLevel = 5;
}

@Override
public void execute(Player player, InputHandler inputHandler) {

    boolean swamp = true;
    while (swamp){

    System.out.println("The path takes you through a forest and while traversing it a glint of sunlight reflecting from an unusual object catches your attention. " + 
    "\nIntrigued, you decide to investigate and discover an old, weathered compass half-buried in the ground. " + 
    "\nWith a newfound sense of direction, you follow the needle and end up at the edge of a swamp." +
    "\nYou begin to trudge through the challenging terrain, mud grabbing at every step. " + 
    "\nThe swamp has an eerie stillness over it and the heavy fog is limiting your vision." + 
    "\nAt the heart of the swamp a silhouette emerges from the mist, reavealing the entrance to an abandoned mine. " + 
    "\nGlancing at the compass, you notice it spinning uncontrollably. " + 
    "\nThe mystery has piqued your interest, you put away the compass and venture into the depths of the mine.");

    pressEnterToContinue(player);
    
    System.out.println("You slowly pace yourself down the narrow tunnel with the sound of your every footstep reverberating off the worn stone walls." + 
    "\nDim light from the entrance soon reveals a room filled with old mining equipment and abandoned tools. As you step into the room" + 
    "\nyou can feel the ground start shaking, collapsing stones and rocks seals of the entrance behind you!");

    System.out.println("\nYou take a minute to catch your breath and assess the situation.");

    System.out.println("\nPress ENTER to continue");
    inputHandler.readInput(player);

    System.out.println("You light a torch and take a look around. You notice a dusty mining cart and a lever on the wall in the corner of the room.");
    swamp = false;    
}

    boolean isLeverPulled = false;
    boolean mineCartLooted = false;

    while (!isLeverPulled) {

        System.out.println("\nWhat do you want to do?" + 
        "\n1. Examine the mining cart." + 
        "\n2. Pull the lever." + 
        "\n3. Search for another way out.");

        String choice = inputHandler.readInput(player);

        switch (choice) {

            case "1":
                if (!mineCartLooted) {
                    System.out.println("\nYou examine the mining cart and find a pair of heavy-duty gloves and a sharp mining pick." + 
                    "\nHP: + 10" + 
                    "\nAttack: + 3");
                    player.addMaxHp(10);
                    player.addCurrentHp(10);
                    player.addAttack(3);
                    mineCartLooted = true;
                } else {
                System.out.println("\nYou've already looted the mining cart.");
                }
            break;

            case "2":
                System.out.println("\nYou pull the lever but it's stuck. You're not one to be outsmarted by a lever so you summon the strength of an ox!" +
                "\n'HHNNNNNNNGG-' and the lever suddenly gives way, you faceplant the ground and lose 3 HP. Ouch.");
                player.decreaseCurrentHp(3);
                if (!player.isAlive()) {return;}
                System.out.println("\nThe collapsed entrance starts to shift as a result and a narrow passage opens. You proceed down the passage.");
                isLeverPulled = true;
                break;
            
            case "3":
                System.out.println("\nYou search for another exit but find nothing. " + 
                "It seems the mining cart or lever might be significant..");
                break;

                default:
        }
    }
    
    pressEnterToContinue(player);

    System.out.println("You follow the newly opened passage and reach a chamber partially flooded with stagnant water." + 
    "\nThere's a decaying wooden bridge spanning before you.");

    boolean bridgeCrossed = false;

    while (!bridgeCrossed)  {

        System.out.println("\nWhat do you want to do?" + 
        "\n1. Cross the bridge." + 
        "\n2. Look for another route around the water." + 
        "\n3. Assess the water for any potential hazards.");

        String choice = inputHandler.readInput(player);

        switch(choice) {

            case "1":
                System.out.println("\nYou cautiously step onto the bridge and begin to waddle across." + 
                "\nHalfway over the bridge you hear something snap and in a heartbeat you decide to make a leap of faith."); 
                    int outcome = randomgen.nextInt(3); {
                        if (outcome == 1) {
                            System.out.println("\nYou make the jump on time and successfully land on solid ground. That was close!");
                            reflect();
                        } else if (outcome == 2) {
                            System.out.println("\nAs you push away with your feet to make the jump a plank breaks." + 
                            "\nFortunately it was only the one plank and you recover, making it to the other side with minor injuries. HP: - 5");
                            player.decreaseCurrentHp(20);
                            if (!player.isAlive()) {return;}

                            reflect();
                        } else {
                            System.out.println("\nAs you make the jump, the bridge collapses underneath your feet. \nYou realize you will come up short " + 
                            "but notice a frayed rope still tied to the base of the bridge that's mounted on solid ground." + 
                            "\nWith sheer determination you manage to grab hold of the rope, fighting against the strong current." +
                            "\nStruggling against the pain, you pull yourself up, hand over hand, until you finally reach safety." + 
                            "\n\nGasping for air, you collapse onto safe terrain. You narrowly escaped a perilous fall." + 
                            "\nThe whole ordeal has taken a toll on your body. HP: - 20");
                            player.decreaseCurrentHp(20);
                            if (!player.isAlive()) {return;}
                            reflect();
                            System.out.println("You are still shaken from the previous experience: Speed -2");
                        }
                    }
                bridgeCrossed = true;
                break;
            
            case "2":
                System.out.println("\nYou search for another route and uncover a steel door." + 
                "\nYou examine the steel door but find no way to open it. No keyhole, no door handle, nothing..");
                break;

            case "3":
                System.out.println("\nYou carefully examine the water and notice a hidden current." + 
                "\nCrossing the bridge might be risky due to unseen dangers.");
                break;

            default:
        }
    }

    pressEnterToContinue(player);

    System.out.println("You come to a seemingly dead end. There are torches lit on the walls and a single large boulder in the far end of the chamber." + 
    "\nYou also notice a treasure chest sitting infront of the boulder. You approach the chest cautiously, as it might be a trap." + 
    "\n\nSomething leaps out of from behind the boulder!");

    pressEnterToContinue(player);

    battle.battle(player);

    if (!player.isAlive()) {return;}
    
    System.out.println("\nYou defeat the monster and claim the treasure! The chest contained 'Winged Boots'! Speed: + 10.");
    player.addSpeed(10);

    pressEnterToContinue(player);

    System.out.println("You're exhausted and sit down against the wall but notice a light break through a crack behind the boulder." + 
    "\nYou muster your last strength and successfully move the boulder just enough for you to slip through. Home free at last.");

    gainEXP(player);
}

private void reflect() {
    System.out.println("\nYou sit down and take a moment to reflect on how you even ended up here. After a while you stand up and continue deeper into the mine.");
}
}