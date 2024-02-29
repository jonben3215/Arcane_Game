package csci.ooad.arcane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Creature extends Agent{

    private static final Logger logger = LoggerFactory.getLogger(Creature.class);

    // ---------- Constructors ---------- //
    public Creature() {
        super("", 3);
    }
    public Creature(String name) {
        super(name, 3);
    }
    public Creature(String name, double health) {
        super(name, health);
    }

}
