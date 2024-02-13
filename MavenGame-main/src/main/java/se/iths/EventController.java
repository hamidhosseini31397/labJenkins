package se.iths;

import se.iths.allEvent.*;

import java.util.*;
import java.util.stream.Collectors;


public class EventController {
    
    Random randomgen = new Random();

    public Event[] eventEncounters = {
    //level 1
    new TavernEvent(),
    new WishingStarEvent(),
    //level 2
    new TravelerEvent(), 
    new RandomChestEvent(),
    new PotionEvent(),
    //level 3
    new PuzzleBoxEvent(),
    //level 4
    new RootEvent(),  
    new FairyEvent(),
    //Level 5
    new AbandonedMinesEvent(),
    //Level 6
    new TempleEvent(),

    // Level 12
    new LulEvent()};

    ArrayList<Event> eventList = new ArrayList<>(Arrays.asList(eventEncounters)); 

    public Event generateEvent(Player player) {

        List<Event> filteredEventList = eventList.stream()
        .filter(e -> (e.eventLevel <= player.getLevel()))
        .collect(Collectors.toList());

            Event selectedEvent;
            if(filteredEventList.isEmpty()){
                 selectedEvent = new NoEventsLeft();   
            } else {
                selectedEvent = filteredEventList.get(randomgen.nextInt(filteredEventList.size()));
                eventList.remove(selectedEvent);
            }

        return selectedEvent;
    }

    public Event Level5(Player player){
        Event Level5 = new HardlyCodedEvent();
        return Level5;
    }

    public Event dragonFight(Player player, InputHandler inputHandler){
        Event dragonFight = new DragonFightEvent();
        return dragonFight;
    }
    public Event Ruins(Player player, InputHandler inputHandler){
        Event Ruins = new AncientRuinsEvent();
        return Ruins;
    }
    
  
}
