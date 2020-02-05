package Controllers;

import Interfaces.BattleItem;
import Models.Items.*;

import java.util.ArrayList;

public class ItemManager {
    public ArrayList<Item> items = new ArrayList<>();
    public ArrayList<BattleItem> startingItems = new ArrayList<>();

    //Add all items you want in the game.
    public ItemManager() {
        items.add(new Fish());
        items.add(new Berry());
        items.add(new Apple());
        items.add(new Lasagna());
        items.add(new Dagger());
        items.add(new Sword());
        items.add(new BattleAxe());
        items.add(new Helmet());
        items.add(new Shield());
        items.add(new BodyArmor());
        items.add(new Cloak());
        items.add(new BoobyTrap());
        items.add(new Storybook());

        //Make list for the career's starting items.
        for (Item item : items) {
            if (item instanceof BattleItem) {
                startingItems.add((BattleItem) item);
            }
        }

    }

    //For assigning starting weapons.
    public BattleItem returnStartingItem() {
        return startingItems.get(RNG.getRandomNumber(startingItems.size()));
    }

    //For finding random items.
    public Item returnRandomItem() {
        return items.get(RNG.getRandomNumber(items.size()));
    }
}

