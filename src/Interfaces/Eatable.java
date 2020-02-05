package Interfaces;

import Models.Contestant;

public interface Eatable {
    // Eatables increase max HP.
    String itemType = "Eatable";

    void eat(Contestant contestant);
}

