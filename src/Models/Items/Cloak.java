package Models.Items;

import Interfaces.Special;
import Models.Contestant;

public class Cloak extends Item implements Special {
    public Cloak() {
        name = "Cloak";
    }

    @Override
    public void specialInteraction(Contestant user, Contestant opponent) {
        System.out.println(user.getName() + " uses the cloak to hide from " + opponent.getName() + " and avoids the battle.");
        user.setSpecialItem(null);
    }

    @Override
    public String getItemType() {
        return itemType;
    }
}
