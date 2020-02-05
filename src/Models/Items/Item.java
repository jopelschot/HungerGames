package Models.Items;

import Models.Contestant;

public abstract class Item {

    public String name;

    public void find(Contestant finder) {
        System.out.println(finder.getName() + " found a " + name + ".");
    }

    public abstract String getItemType();

    public String getName() {
        return name;
    }
}
