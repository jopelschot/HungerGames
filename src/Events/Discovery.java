package Events;

import Controllers.ItemManager;
import Controllers.RNG;
import Interfaces.BattleItem;
import Interfaces.Eatable;
import Interfaces.Special;
import Models.*;
import Models.Items.Item;


public class Discovery {

    ItemManager items = new ItemManager();

    //50% chance to find an item.
    public Discovery(Contestant x) {
        if (x.isAlive() && (RNG.getChance() >= 0.5)) {
            Item foundItem = items.returnRandomItem();
//Different kinds of items do different things.
            switch (foundItem.getItemType()) {
                case "BattleItem":
                    ((BattleItem) foundItem).equip(x);
                    foundItem.find(x);
                    break;
                case "Eatable":
                    foundItem.find(x);
                    ((Eatable) foundItem).eat(x);
                    break;
                case "Special":
                    foundItem.find(x);
                    x.setSpecialItem((Special) foundItem);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + foundItem.getItemType());
            }
        }
    }
}




