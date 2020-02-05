package Models.Items;

import Interfaces.Special;
import Models.Contestant;

public class Storybook extends Item implements Special {
    public Storybook() {
        name = "Super Boring Storybook";
    }

    @Override
    public void specialInteraction(Contestant user, Contestant opponent) {
        System.out.println(user.getName() + " starts reading the storybook to " + opponent.getName() + ".");
        System.out.println("It's is very very long and shitty story.");
        System.out.println(opponent.getName() + " gets literally bored to death. RIP.");
        opponent.setAlive(false);
        user.setSpecialItem(null);
    }

    @Override
    public String getItemType() {
        return itemType;
    }
}
