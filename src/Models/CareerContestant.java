package Models;

import Controllers.RNG;

public class CareerContestant extends Contestant {

    //Assign random attack/defense levels at random. Bonus to attackLevel.
    public CareerContestant() {
        attackLevel = 2 + RNG.getRandomNumber(5);
        defenseLevel = 1 + RNG.getRandomNumber(5);
    }
}
