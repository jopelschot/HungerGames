package Models;

import Controllers.RNG;
import Interfaces.Special;
import Models.Items.Armor;
import Models.Items.Weapon;

public abstract class Contestant {

    String name;
    String gender;
    int district;
    int maxHealth = 10;
    int health = maxHealth;
    int attackLevel;
    int defenseLevel;
    Weapon currentWeapon = null;
    Armor currentArmor = null;
    Special specialItem = null;
    int currentArea = 0;
    boolean isAlive = true;

    //Move Contestant to a random area.
    public void move() {
        if (isAlive) {
            currentArea = RNG.getRandomNumber(10);
        }
    }

    //To attack another Contestant.
    public void attack(Contestant opponent) {
        if (health > 0) {
//Set correct att/def levels.
            int totalAttack;
            int opponentDefense;
            if (currentWeapon != null) {
                totalAttack = attackLevel + currentWeapon.getAttackBonus();
            } else {
                totalAttack = attackLevel;
            }
            if (opponent.currentArmor != null) {
                opponentDefense = opponent.defenseLevel + opponent.currentArmor.getDefenseBonus();
            } else {
                opponentDefense = opponent.defenseLevel;
            }
            double hitDamage = Math.max(1, totalAttack - (0.5 * opponentDefense));
// Different attacks based on chance. UNCOMMENT sys.outs for extended fights!!
            double chance = RNG.getChance();
            if (chance <= 0.01) {
                //System.out.println(name + " hits a vital and instantly kills " + opponent.name + "! GG RNG.");
                opponent.health = 0;
            } else if (chance <= 0.20) {
                //System.out.println(name + " misses the attack.");
            } else {
                // System.out.println(name + " hits for " + hitDamage + "!");
                opponent.health -= hitDamage;
            }
        }
    }

    //Contestant steals a Battle Item if it's weaker than current Battle Item.
    public void stealBattleItem(Contestant opponent) {
        if (opponent.currentWeapon != null && (currentWeapon == null || opponent.currentWeapon.getAttackBonus() > currentWeapon.getAttackBonus())) {
            System.out.println(name + " takes the " + opponent.currentWeapon.name + " from " + opponent.name + "'s dead body.");
            opponent.currentWeapon.equip(this);
            opponent.currentWeapon = null;

        } else if (opponent.currentArmor != null && (currentArmor == null || opponent.currentArmor.getDefenseBonus() > currentArmor.getDefenseBonus())) {
            System.out.println(name + " takes the " + opponent.currentArmor.name + " from " + opponent.name + "'s dead body.");
            opponent.currentArmor.equip(this);
            opponent.currentArmor = null;
        }
    }

    //Rest to get back to full HP.
    public void rest() {
        health = maxHealth;
    }

    //Getters Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public int getHealth() {
        return health;
    }

    public void setCurrentWeapon(Weapon equippedWeapon) {
        this.currentWeapon = equippedWeapon;
    }

    public void setCurrentArmor(Armor currentArmor) {
        this.currentArmor = currentArmor;
    }

    public int getCurrentArea() {
        return currentArea;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public Armor getCurrentArmor() {
        return currentArmor;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Special getSpecialItem() {
        return specialItem;
    }

    public void setSpecialItem(Special specialItem) {
        this.specialItem = specialItem;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
}

