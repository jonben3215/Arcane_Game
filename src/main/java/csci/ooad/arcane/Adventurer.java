package csci.ooad.arcane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Adventurer extends Agent{
    private static final Logger logger = LoggerFactory.getLogger(Adventurer.class);

    // ---------- Constructors ---------- //
    public Adventurer() {
        super("", 5);
    }
    public Adventurer(String name) {
        super(name, 5);
    }
    public Adventurer(String name, double health) {
        super(name, health);
    }

    // ---------- Adventurer Helpers --------- //
    public boolean isHealthiestInRoom() {
        Adventurer healthiestInRoom = this.room.getHealthiestAdventurer();

        // This should never be true but check anyways
        if (healthiestInRoom == null) {
            logger.warn("Curious Error: No healthiest adv. in room, but there is at least one adv. in room");
            return false;
        }
        return (this == healthiestInRoom);
    }
    public boolean creaturePresentInRoom() {
        return this.room.hasCreature();
    }

    public Creature getFightableCreature() {
        return this.room.getHealthiestCreature();
    }


    // ---------- Methods ---------- //

    @Override
    public void doAction() {

        logger.info("Adventurer " + getInfo() + " is doing an action");

        // If alive
        if (!isAlive()) return;



        // Case 1.a: (Fight)
        if (isHealthiestInRoom() && creaturePresentInRoom()) {
            fight();
        } // Case 2: (Eat)
        else if (!(creaturePresentInRoom()) && foodPresentInRoom()) {
            eat();
        }// Case 1.b and 3: (Move)
        else {
            // TODO: (IMPORTANT) THIS IS THE ONE THAT IS PROBLEMATIC SEE: DELAYED UPDATE
            // todo calling this doaction funciton should completely account for the universal update
            flee();
        }
    }

    public void fight() {

        // Fight should only be called if this is not null
        Creature enemyCreature = this.getFightableCreature();

        if (enemyCreature == null) {
            logger.warn("Adventurer " + this.getName() + " has no creature to fight");
            return;
        }

        logger.info("Adventurer " + getInfo() + " just fought " + getFightableCreature().getInfo() + "\n");

        double playerAttack = this.calcDamage();
        double creatureAttack = enemyCreature.calcDamage();

        if (playerAttack > creatureAttack) {
            logger.debug("Adventurer " + this.getName() + " won the fight against " + enemyCreature.getName());
            enemyCreature.takeDamage(playerAttack);
        } else if (playerAttack < creatureAttack) {
            logger.debug("Adventurer " + this.getName() + " lost the fight against " + enemyCreature.getName());
            this.takeDamage(creatureAttack);
        } else {
            logger.debug("Adventurer " + this.getName() + " and " + enemyCreature.getName() + " tied. Both take 0.5 damage.");
            // Both take damage in confusion
            this.takeDamage(0.5);
            enemyCreature.takeDamage(0.5);
        }
    }

    public void flee()
    {
        List<Room> neighboringRooms = new ArrayList<>();

        // TODO Ensure that only non-null neighboring rooms are added
        // TODO I am dreally drunk but this seeems illogical, i can't say why though
        for (Room neighborRoom : this.room.getNeighborRooms()) {
            if (neighborRoom != null) {
                neighboringRooms.add(neighborRoom);
            }
        }

        if(neighboringRooms.isEmpty()) {
            logger.warn("Adventurer:" + this.getName() + "No neighboring rooms found to fee to.");
            return;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(neighboringRooms.size());
        Room randomRoom = neighboringRooms.get(randomIndex);
        setRoom(randomRoom);
    }


    // Only works when done in in healthiest order, the project is due soon, it gotta be this way
    public void eat() {
        List<Food> roomFoods = this.room.getFoods();
        if (roomFoods.isEmpty()) {
            return;
        }

        Food foodToEat = this.room.getFoods().get(0);
        this.room.removeFood(foodToEat);
        this.setHealth(this.health+1.0);

        logger.info("Adventurer " + this.getInfo() + " just ate " + foodToEat.getName());
    }


}
