package Models.Items;

import Interfaces.Eatable;
import Models.Contestant;

public abstract class Food extends Item implements Eatable {

    int healthBonus;

    public void find(Contestant finder) {
        System.out.println(finder.getName() + " found a " + name + " and eats it to increase health.");
    }

    public void eat(Contestant contestant) {
        contestant.setMaxHealth(contestant.getMaxHealth() + healthBonus);
    }

    public String getItemType() {
        return itemType;
    }
}