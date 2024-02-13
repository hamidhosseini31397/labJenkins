package se.iths.allEvent;

import se.iths.*;


public class HardlyCodedEvent extends Event {
        Player player;
        
        public HardlyCodedEvent() {
                super();
                this.eventLevel = 20;
        }     
        @Override
        public void execute(Player player, InputHandler InputHandler) {
                
                intro(player);
                boolean helpingHand = true;
                while (helpingHand){
                System.out.println("What do you want to do?? \n[1] Help the poor man. \n[2] Rob him blind. \n[3] Leave him on the road. You have important buisness to atend.");
                String giveHelpingHand = input.readInput(player);     
                switch (giveHelpingHand){
                        case "1":
                        AdventureGame.clearScreen();
                        System.out.println("Press ENTER to continue");
                        System.out.println("You decide to help him out and together you work to fix the cart.");
                        input.readInput(player);
                        System.out.println("It takes a fair bit of time and effort, but you get the work done.");
                        input.readInput(player);
                        System.out.println("The man looks at you and smiles. - Thank you young man. I thought I'ld be stuck here all night.");
                        input.readInput(player);
                        System.out.println("Well a promise is a promise. He sticks his hand into the pile of sacks.");
                        input.readInput(player);
                        int randomLoot = randomgen.nextInt(100) + 1;
                        getCaseFromRandom(randomLoot);
                        randomReward(player);
                        if (!player.isAlive()) {return;}
                        System.out.println("You gained experience.");
                        player.addExperience(100);
                        helpingHand = false;
                        break;
                        case "2":
                        AdventureGame.clearScreen();
                        System.out.println("You pull out your weapon and threaten the old man. He gives you his moneypouch while cursing you.");
                        input.readInput(player);
                        System.out.println("While walking away you feel yourself loosing strenght.");
                        player.decreaseAttack(3);
                        player.decreaseMaxHp(5);
                        player.decreaseSpeed(3);
                        System.out.println("Max HP : - 5 \nCurrent HP : - 5 \nAttack : - 3 \nSpeed : - 3 ");
                        player.decreaseCurrentHp(5);
                        if (!player.isAlive()) {return;}
                        pressEnterToContinue(player);
                        helpingHand = false;
                        player.setLevel(6);
                        break;
                        case "3":
                        AdventureGame.clearScreen();
                        System.out.println("You continue past him.");
                        helpingHand = false;
                        player.setLevel(6);
                        pressEnterToContinue(player);

                }
        
        }

                        
        }      

        public void intro(Player player){
               
                System.out.println("Press ENTER to continue");
                System.out.println("At evening you walk along the path and come across an old man with a cart laden with sacks and boxes. \nThe carts axle is broken and the man looks feeble and distraught.");
                input.readInput(player);
                System.out.println("He sees you and his face brightens.");
                input.readInput(player);
                System.out.println("- Hoy there young adventurer! Would you mind helping an old man? \nI have a new axle for the cart but my feeble arms and back \nprevents me from lifting the cart to install it.");
                input.readInput(player);
                System.out.println("I'll reward you with whatever my hand first touches when I reach inside my cart.");
        }

        public void help(Player player, InputHandler inputHandler){
                boolean helping = true;
                while (helping){

                        AdventureGame.clearScreen();
                        System.out.println("Press ENTER to continue");
                        System.out.println("You decide to help him out and together you work to fix the cart.");
                        input.readInput(player);
                        System.out.println("It takes a fair bit of time and effort, but you get the work done.");
                        input.readInput(player);
                        System.out.println("The man looks at you and smiles. - Thank you young man. I thought I'ld be stuck here all night.");
                        input.readInput(player);
                        System.out.println("Well a promise is a promise. He sticks his hand into the pile of sacks.");
                        input.readInput(player);
                        int randomLoot = randomgen.nextInt(100) + 1;
                        getCaseFromRandom(randomLoot);
                        randomReward(player);
                     
                }
        }

        

        public void randomReward(Player player){
                
                boolean loot = true;
                while (loot){
                        int randomLoot = randomgen.nextInt(100) + 1;
                        getCaseFromRandom(randomLoot);
                        if (loot == false){
                                break;
                        }

                        switch (randomLoot){
                                case 1:
                                System.out.println("He pulls out a beautiful sword and his smile immediately disappears.");
                                input.readInput(player);
                                System.out.println("- Just my luck. First my cart breaks and now I have to give away a legendary sword.");
                                input.readInput(player);
                                System.out.println("But by my honour I'll stand by my word.");
                                input.readInput(player);
                                System.out.println("You've gained: Legendary sword Excalibre \nAttack : + 100 \nSpeed : + 100 \nMax HP : + 300 \nCurrent HP : + 300");
                                player.setExcalibre(1);
                                player.addAttack(100);
                                player.addSpeed(100);
                                player.addMaxHp(300);
                                player.addCurrentHp(300);
                                boolean hero = true;
                                while (hero){
                                        System.out.println("Press ENTER to continue.");
                                        String enter = input.readInput(player);
                                        if (enter.isEmpty()){
                                                hero = false;
                                                loot = false;
                                                break;
                                        }else {
                                        }
                                }
                                break;

                                case 2:
                                System.out.println("He pulls out a sleek, curvy shortsword and hands it to you.");
                                input.readInput(player);
                                System.out.println("- Now thats a blade of marvels. It glows blue if there are orcs around.");
                                input.readInput(player);
                                System.out.println("You've gained: Stung. \nAttack : + 20 \nSpeed + 20");
                                player.addAttack(20);
                                player.addSpeed(20);
                                boolean sting = true;
                                while (sting){
                                        System.out.println("Press ENTER to continue.");
                                        String enter = input.readInput(player);
                                        if (enter.isEmpty()){
                                                sting = false;
                                                loot = false;
                                                break;
                                        }else {
                                        }                                
                                }
                                break;
                                case 3:
                                System.out.println("He pulls out a breastplate of peculiar shape. It looks almost like the gaunt chest of a burnt demon.");
                                input.readInput(player);
                                System.out.println("- Ah. This is a very effective armor, created by fusing ebony with the liver of a Deedra.");
                                input.readInput(player);
                                System.out.println("You've gained: Deedric armor. \nMax HP : + 20 \nSpeed : + 15");
                                player.addMaxHp(20);
                                player.addSpeed(15);
                                boolean armor = true;
                                while (armor){
                                        System.out.println("Press ENTER to continue.");
                                        String enter = input.readInput(player);
                                        if (enter.isEmpty()){
                                                armor = false;
                                                loot = false;
                                                break;
                                        }else {
                                        }                                
                                } 
                                break;
                                case 4:

                                System.out.println("He pulls out a branch that holds two golden apples and hands it to you.");
                                input.readInput(player);
                                System.out.println("- Oh these are very interesting. They are said to provide vitality to even those close to death.");
                                input.readInput(player);
                                System.out.println("You remove the apples from the branch and put them in your pouch.");
                                player.addApple(2);
                                System.out.println("You have " + player.getApple() + "/4 golden apples.");
                                input.readInput(player);
                                boolean apple = true;
                                while (apple) {
                                        System.out.println("Do you want to keep the branch? \n[1] Yes\n[2] No");
                                        String branch = input.readInput(player);
                                        if (branch.equals("1") || branch.equals("yes") || branch.equals("y")) {
                                                System.out.println("You keep the branch. Who knows? It could be useful.");
                                                player.setBranch(1);
                                                pressEnterToContinue(player);
                                                apple = false;
                                                loot = false;
                                                break;
                                        } else if (branch.equals("/menu")){
                                        } else if (branch.equals("2")|| branch.equals("no")||branch.equals("n")){
                                                System.out.println("You throw the branch into the ditch.");
                                                pressEnterToContinue(player);
                                                apple = false;
                                                loot = false;
                                                break;
                                        }
                                }
                                break;
                                case 5:
                                System.out.println("He pulls out a golden dagger with a ruby fitted into the hilt.");
                                input.readInput(player);
                                System.out.println("- Ooh be careful when using this one. It was found in the ruins of a once amazing city.");
                                input.readInput(player);
                                System.out.println("- It is said that a great evil sleeps there and that everything in the ruins are connected to it.");
                                input.readInput(player);
                                boolean rubyDagger = true;
                                while (rubyDagger){
                                        System.out.println("Do you want to take the dagger?\n[1] Yes\n[2] No");
                                        String dagger = input.readInput(player);
                                        if (dagger.equals("1") || dagger.equals("yes") || dagger.equals("y")) {
                                                System.out.println("You've gained: Ruby hilted dagger.\nMax HP : - 10 \nCurrent HP : - 10 \nAttack : + 15");
                                                player.decreaseMaxHp(10);
                                                player.addAttack(15);
                                                player.decreaseCurrentHp(10);
                                                if (!player.isAlive()) {return;}
                                                pressEnterToContinue(player);
                                                rubyDagger = false;
                                                loot = false;
                                                break;
                                                
                                        } else if (dagger.equals("/menu")){
                                        } else if (dagger.equals("2")|| dagger.equals("no")||dagger.equals("n")) {
                                                System.out.println("You decline the dagger and the man shrugs and puts it back into the cart.");
                                                pressEnterToContinue(player);
                                                rubyDagger = false;
                                                loot = false;
                                                break;
                                        }
                                }
                                break;
                                case 6:
                                System.out.println("He pulls out a helmet that has a faceplate fastened with a long thing spike in the front.");
                                input.readInput(player);
                                System.out.println("- This is an interesting piece. It belongs to an elite fighting group based in the desert city Astaper.");
                                input.readInput(player);
                                System.out.println("- The soldiers are all slave-eunuchs and very effective warriors.");
                                input.readInput(player);
                                System.out.println("You've gained: Helm of the unsallied. \nMax HP : + 15 \nCurrent HP : + 15");
                                player.addMaxHp(15);
                                player.addCurrentHp(15);
                                boolean helmet = true;
                                while (helmet){
                                        System.out.println("Press ENTER to continue.");
                                        String enter = input.readInput(player);
                                        if (enter.isEmpty()){
                                                helmet = false;
                                                loot = false;
                                                break;
                                        }else {
                                        }                                
                                } 
                                break;
                                case 7:
                                System.out.println("He pulls out a beautiful green cloak and hands it to you.");
                                input.readInput(player);
                                System.out.println("You've gained: Green cloak. It's pretty but not very useful.");
                                boolean cloak = true;
                                while (cloak){
                                        System.out.println("Press ENTER to continue.");
                                        String enter = input.readInput(player);
                                        if (enter.isEmpty()){
                                                cloak = false;
                                                loot = false;
                                                break;
                                        }else {
                                        }                                
                                } 
                                break;
                                case 8:
                                System.out.println("He pulls out a dirty rag.");
                                input.readInput(player);
                                System.out.println("- Whew seems to be my lucky day.");
                                input.readInput(player);
                                System.out.println("You've gained: Dirty rag.");
                                boolean rag = true;
                                while (rag){
                                        System.out.println("Press ENTER to continue.");
                                        String enter = input.readInput(player);
                                        if (enter.isEmpty()){
                                                rag = false;
                                                loot = false;
                                                break;
                                        }else {
                                        }                                
                                }
                                break;
                                default:
                        
                        }
                }
        }

        public int getCaseFromRandom(int randomLoot){

                        if (randomLoot == 100){
                                return randomLoot = 1;
                        } else if (randomLoot <= 99 && randomLoot > 90) {
                                return randomLoot = 2;
                        } else if (randomLoot <= 89 && randomLoot > 70){
                                return randomLoot = 3;
                        } else if (randomLoot <= 69 && randomLoot > 50){
                                return randomLoot = 4;
                        } else if (randomLoot <= 49 && randomLoot > 30){
                                return randomLoot = 5;
                        } else if (randomLoot <= 29 && randomLoot > 10){
                                return randomLoot = 6;
                        } else if (randomLoot <= 9 && randomLoot < 1) {
                                return randomLoot = 7;
                        } else {
                                return randomLoot = 8;
                        }

        }
}
