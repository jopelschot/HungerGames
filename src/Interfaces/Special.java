package Interfaces;

import Models.Contestant;

public interface Special {
    //Special items give a one time special interaction if a Contestant encounters an opponent.
    String itemType = "Special";

    void specialInteraction(Contestant user, Contestant opponent);
}
