package Controllers;

import Interfaces.BattleItem;
import Models.CareerContestant;
import Models.Contestant;
import Models.DistrictContestant;

import java.util.ArrayList;

public class ContestantManager {
    ItemManager items = new ItemManager();
    ArrayList<Contestant> maleContestants = new ArrayList<>();
    ArrayList<Contestant> femaleContestants = new ArrayList<>();
    ArrayList<Contestant> allContestants = new ArrayList<>();


    //Create 24 Contestants. Half male, half female. District 1, 2 and 3 are Career contestants.
    public void generateContestants() {
        for (int i = 0; i < 6; i++) {
            Contestant careerContestant = new CareerContestant();
//Give Career Contestants a starting Battle Item.
            BattleItem startItem = items.returnStartingItem();
            startItem.equip(careerContestant);
            if (i % 2 == 0) {
                maleContestants.add(careerContestant);
            } else {
                femaleContestants.add(careerContestant);
            }
        }
        for (int i = 0; i < 18; i++) {
            Contestant districtContestant = new DistrictContestant();
            if (i % 2 == 0) {
                maleContestants.add(districtContestant);
            } else {
                femaleContestants.add(districtContestant);
            }
//Set genders.
        }
        for (Contestant contestant : maleContestants) {
            contestant.setGender("Male");
        }
        for (Contestant contestant : femaleContestants) {
            contestant.setGender("Female");
        }
    }

    //Assign Districts.
    public void assignDistricts() {
        int districtNumber = 1;
        for (Contestant contestant : maleContestants) {
            contestant.setDistrict(districtNumber);
            districtNumber += 1;
        }
        districtNumber = 1;
        for (Contestant contestant : femaleContestants) {
            contestant.setDistrict(districtNumber);
            districtNumber += 1;
        }
    }

    //Combine and name boys and girls.
    public void createContestantList() {
        allContestants.addAll(maleContestants);
        allContestants.addAll(femaleContestants);
        for (Contestant c : allContestants) {
            if (c.getGender().equals("Male")) {
                c.setName("District " + c.getDistrict() + " Guy");
            } else {
                c.setName("District " + c.getDistrict() + " Girl");
            }
        }
    }

    //For removing dead contestants from the arena.
    public void removeContestants() {
        allContestants.removeIf(c -> !c.isAlive());
    }

    //See if a contestant moves to an occupied area.
    public Contestant matchArea(Contestant currentContestant) {
        Contestant matchedContestant = null;
        for (Contestant c : allContestants) {
            if (currentContestant.getCurrentArea() == c.getCurrentArea() && currentContestant != c) {
                matchedContestant = c;
                break;
            }
        }
        return matchedContestant;
    }
}

