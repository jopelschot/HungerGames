package Models.Items;

import Interfaces.BattleItem;
import Models.Contestant;

public abstract class Weapon extends Item implements BattleItem {

    int attackBonus;

    public void equip(Contestant contestant) {
        if (contestant.getCurrentWeapon() == null || this.attackBonus < contestant.getCurrentWeapon().attackBonus)
            contestant.setCurrentWeapon(this);
    }

    public String getItemType() {
        return itemType;
    }

    public int getAttackBonus() {
        return attackBonus;
    }
}

