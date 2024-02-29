package csci.ooad.arcane;

public class Coward extends Adventurer {

    public Coward(String name) {
        super(name, 5.0);
    }

    @Override
    public void doAction() {
        // Always runs from a creature, if it can (it can't run from Demons)
        if (this.getRoom().hasCreature()) {
            this.fight();
        } else {
            this.flee();
        }
        this.takeDamage(0.5);
    }
}