package csci.ooad.arcane;

import java.util.Random;

public class AdventurerFactory {

    public Adventurer createAdventurer(String name, String type) {

        if (type == "Coward") {
            return createCoward(name);
        } else if (type == "Glutton") {
            return createGlutton(name);
        } else if (type == "Knight") {
            return createKnight(name);
        } else {
            return createAdventurer(name);
        }

    }

    public Adventurer createAdventurer(String name) {
        return new Adventurer(name);
    }

    public Knight createKnight(String name) {
        return new Knight(name);
    }

    public Coward createCoward(String name) {
        return new Coward(name);
    }

    public Glutton createGlutton(String name) {
        return new Glutton(name);
    }
}
