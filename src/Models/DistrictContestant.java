package Models;

import Controllers.RNG;

public class DistrictContestant extends Contestant {

    //Assign random attack/defense levels at random. Bonus to defenseLevel.
    public DistrictContestant() {
        attackLevel = 1 + RNG.getRandomNumber(5);
        defenseLevel = 2 + RNG.getRandomNumber(5);
    }
}
