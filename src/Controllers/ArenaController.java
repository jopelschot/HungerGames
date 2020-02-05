package Controllers;

import Events.Discovery;
import Events.Encounter;
import Events.Victory;
import Models.Contestant;

import java.util.Collections;

public class ArenaController {

    public void start() {
//Initialize all contestants
        ContestantManager contestants = new ContestantManager();
        contestants.generateContestants();
        contestants.assignDistricts();
        contestants.createContestantList();
        int day = 0;
        while (contestants.allContestants.size() != 1) {
//Start of a new day.
            day += 1;
            System.out.println("=======================================================================================");
            System.out.println("Day " + day);
            System.out.println("=======================================================================================");
//Every living contestant gets one move per day. If a contestant moves to an occupied area, an Encounter happens.
            Collections.shuffle(contestants.allContestants);
            for (Contestant currentContestant : contestants.allContestants) {
                currentContestant.move();
                Contestant foundContestant = contestants.matchArea(currentContestant);
                if (foundContestant != null) {
                    new Encounter(currentContestant, foundContestant);
                }
            }
//End of the day: Contestants search for helpful items.
            System.out.println("Everyone still alive searches for helpful items.");
            Collections.shuffle(contestants.allContestants);
            for (Contestant currentContestant : contestants.allContestants) {
                new Discovery(currentContestant);
            }
//Remove dead contestants from the field.
            contestants.removeContestants();
            if (contestants.allContestants.size() == 1) {
                break;
            }
//End of day heal for remaining contestants.
            for (Contestant currentContestant : contestants.allContestants) {
                currentContestant.rest();
            }
            System.out.println();
            System.out.println("End of day " + day + ". The remaining contestants get some rest to recover.");
            System.out.println();
        }
//Only one contestant left in the contestants ArrayList breaks the while loop.
        new Victory(contestants.allContestants.get(0));
    }
}


