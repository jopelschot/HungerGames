package Events;

import Controllers.RNG;
import Models.Contestant;

public class Encounter {
    // Meeting a living contestant results in an interaction.
    public Encounter(Contestant x, Contestant y) {
        if (x.isAlive()) {
            if (y.isAlive()) {
                System.out.println(x.getName() + " encounters " + y.getName() + ".");
                if (x.getDistrict() == y.getDistrict() && RNG.getChance() < 0.50) {
                    System.out.println("Because they are from the same District, they agree to a truce and won't harm each other. For now...");
                    System.out.println();
                } else if (x.getSpecialItem() != null) {
                    x.getSpecialItem().specialInteraction(x, y);
                    System.out.println();
                } else {
                    new Battle(x, y);
                }
            } else {
// Finding a dead guy results in free loot!
                System.out.println(x.getName() + " finds " + y.getName() + "'s dead body.");
                x.stealBattleItem(y);
                System.out.println();
            }
        }
    }
}
