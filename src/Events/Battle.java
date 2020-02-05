package Events;

import Models.Contestant;


public class Battle {
    //Battle always ends in one contestant dying. The winner gets to loot the opponent's corpse.
    public Battle(Contestant x, Contestant y) {
        while (x.isAlive() && y.isAlive()) {
            x.attack(y);
            y.attack(x);
            if (y.getHealth() <= 0) {
                System.out.println(y.getName() + " was killed by " + x.getName() + ".");
                y.setAlive(false);
                x.stealBattleItem(y);
                System.out.println();
            } else if (x.getHealth() <= 0) {
                System.out.println(x.getName() + " was killed by " + y.getName() + ".");
                x.setAlive(false);
                y.stealBattleItem(x);
                System.out.println();
            }
        }
    }
}



