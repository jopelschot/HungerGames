package Events;

import Controllers.RNG;
import Models.Contestant;

public class Victory {
    //Victory output. There's a small chance that Snow's assassination fails and a revolution starts.
    public Victory(Contestant winner) {
        System.out.println();
        System.out.println("=======================================================================================");
        System.out.println("The Hunger Games have come to an end.");
        System.out.println(winner.getName() + " is the last contestant standing and will be crowned this year's winner!");
        System.out.println();
        if (RNG.getChance() < 0.2 && winner.getHealth() >= winner.getMaxHealth() * 0.5) {
            System.out.println("But then President Snow kills " + winner.getName() + "...  THE END.");
            winner.setAlive(false);
        } else {
            System.out.println("President Snow tries to assassinate " + winner.getName() + " but fails in his attempt.");
            System.out.println(winner.getName() + " becomes the face of the revolt against the oppressive government");
            System.out.println("Viva la revolution! THE END.");
        }
    }
}
