package Models.Items;

import Interfaces.BattleItem;
import Models.Contestant;

public abstract class Armor extends Item implements BattleItem {
    int defenseBonus;

    public void equip(Contestant contestant) {
        if (contestant.getCurrentArmor() == null || this.defenseBonus < contestant.getCurrentArmor().defenseBonus)
            contestant.setCurrentArmor(this);
    }

    @Override
    public String getItemType() {
        return itemType;
    }

    public int getDefenseBonus() {
        return defenseBonus;
    }
}
