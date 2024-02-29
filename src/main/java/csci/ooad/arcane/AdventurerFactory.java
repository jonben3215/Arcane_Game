package csci.ooad.arcane;

public class AdventurerFactory {


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
