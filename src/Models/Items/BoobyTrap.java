package Models.Items;

import Interfaces.Special;
import Models.Contestant;

public class BoobyTrap extends Item implements Special {
    public BoobyTrap() {
        name = "Boobytrap";
    }

    @Override
    public void specialInteraction(Contestant user, Contestant opponent) {
        System.out.println(user.getName() + " sets the boobytrap. " + opponent.getName() + " gets caught in it and dies.");
        opponent.setAlive(false);
        user.setSpecialItem(null);
    }

    @Override
    public String getItemType() {
        return itemType;
    }
}
