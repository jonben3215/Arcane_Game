package csci.ooad.arcane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demon extends Creature {
    private static final Logger logger = LoggerFactory.getLogger(Demon.class);


    public Demon(String Name) {
        super("Demon", 15);
    }
}