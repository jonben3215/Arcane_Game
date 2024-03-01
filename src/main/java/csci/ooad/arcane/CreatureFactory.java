package csci.ooad.arcane;

public class CreatureFactory {
    public Creature createCreature(String name) {
        return new Creature(name);
    }

    public Demon createDemon(String name) {
        return new Demon(name);
    }
}
