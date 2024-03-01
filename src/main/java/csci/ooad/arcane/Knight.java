package csci.ooad.arcane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Knight extends Adventurer {
    private static final Logger logger = LoggerFactory.getLogger(Knight.class);

    public Knight(String name) {
        super(name, 8.0);
    }

    @Override
    public void doAction() {
        // Always fights any creature in the room
        Creature enemy = this.getFightableCreature();
        if(enemy == null) {
            logger.warn("Curious Error: No fightable creature in room, but there is at least one creature in room");
            return;
        }
        this.fight(enemy);
    }
}