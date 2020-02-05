package Interfaces;

import Models.Contestant;

public interface BattleItem {
    //Battle Items increase Attack or Defense when equipped.
    String itemType = "BattleItem";

    void equip(Contestant contestant);
}
