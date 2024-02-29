package csci.ooad.arcane;

public class Glutton extends Adventurer {

    public Glutton(String name) {
        super(name, 3.0);
    }

    @Override
    public void doAction() {
        // Always eats if food is available unless a Demon is in the room, then it must fight
        if (this.getRoom().hasCreature()) {
            this.fight();
        } else if (this.getRoom().hasFood()) {
            this.eat();
        }
    }
}