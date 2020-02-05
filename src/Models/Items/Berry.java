package Models.Items;

import Controllers.RNG;
import Models.Contestant;

public class Berry extends Food {
    public Berry() {
        name = "Berry";
        healthBonus = 1;
    }

    //Berries have 50% chance to instantly kill you because they're poisonous.
    @Override
    public void eat(Contestant contestant) {
        if (RNG.getChance() < 0.5) {
            contestant.setMaxHealth(contestant.getMaxHealth() + this.healthBonus);
        } else {
            System.out.println("Oh no, the " + name + " was poisonous! " + contestant.getName() + " dies of heart failure.");
            contestant.setAlive(false);

        }
    }

}
