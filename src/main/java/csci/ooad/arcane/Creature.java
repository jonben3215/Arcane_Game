package csci.ooad.arcane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Creature extends Agent{

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
