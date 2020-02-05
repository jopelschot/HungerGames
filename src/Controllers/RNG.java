package Controllers;

import java.util.Random;

public class RNG {
    //Class to get a random chance or number.
    public static double getChance() {
        return Math.random();
    }

    public static int getRandomNumber(int maxNumber) {
        Random random = new Random();
        return random.nextInt(maxNumber);
    }
}

