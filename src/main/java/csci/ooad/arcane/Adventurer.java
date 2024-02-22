package csci.ooad.arcane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Adventurer extends Agent{
    private static final Logger logger = LoggerFactory.getLogger(Adventurer.class);
    //private String name;
    private double health;
    private Room room = null;
    private boolean isAlive = true;


    // ---------- Constructors ---------- //
    public Adventurer() {
        super("");
        this.health = 5; // Default
    }
    public Adventurer(String name) {
        super(name);
        this.health = 5;
        this.name = name;
    }
    public Adventurer(String user_Name, double health) {
        super(user_Name);
        this.name  = user_Name;
        this.health = health;
    }
    public String getName() {
        return name;
    }
    public double getHealth()
    {
        return health;
    }
    public Room getRoom() {
        return this.room;
    }
    public String getRoomName() {
        return this.room.getName();
    }

    public boolean isHealthiestInRoom()
    {

        Adventurer healthiestInRoom = this.room.getHealthiestAdventurer();

        // This should never be true but check anyways
        if (healthiestInRoom == null) {
            logger.warn("Curious Error: No healthiest adv. in room, but there is at least one adv. in room");
            return false;
        }
        return (this == healthiestInRoom);
    }

    public boolean creaturePresentInRoom()
    {
        return this.room.hasCreature();
    }

    public boolean foodPresentInRoom()
    {
        return this.room.hasFood();
    }


    public void setHealth(double health) {
        // Update hp
        this.health = health;
        // Kill player if hp drops below zero, ensure hp >= 0
        if (this.health <= 0) {
            this.health = 0;
            isAlive = false;
            this.setRoom(null);
            logger.info("csci.ooad.arcane.Adventurer " + this.getName() + " was killed");
        } else {
            isAlive = true;
        }
    }

    public void takeDamage(double damage) {
        // Negative damage does nothing
        if (damage < 0) {return;}
        // Damage player with checks in setHealth
        setHealth(this.health-damage);
    }

    public void setName(String user_Name)
    {
        this.name = user_Name;
    }
    public void setRoom(Room newRoom)
    {
        if(this.room != null) this.room.removeAdventurer(this);

        this.room = newRoom;

        if(newRoom != null) this.room.addAdventurer(this);

    }

    public Map<Direction, Room> getValidMoves()
    {
        return this.room.getNeighbors();
    }

    public void move(Direction direction) {

    }

    public void moveTo(Room room)
    {
        this.setRoom(room);
    }

    public void flee()
    {

        List<Room> neighboringRooms = new ArrayList<>();

        // TODO Ensure that only non-null neighboring rooms are added
        for (Room neighborRoom : this.room.getNeighborRooms()) {
            if (neighborRoom != null) {
                neighboringRooms.add(neighborRoom);
            }
        }

        if(neighboringRooms.isEmpty()) {
            logger.warn("csci.ooad.arcane.Adventurer:" + this.getName() + "No neighboring rooms found to fee to.");
            return;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(neighboringRooms.size());
        Room randomRoom = neighboringRooms.get(randomIndex);
        moveTo(randomRoom);

    }


    public int playerRoll()
    {
        Random numGenerator = new Random();

        //Generates a number from 1 to 6 similar to a die
        return numGenerator.nextInt(6)+1;
    }


    public Creature getFightableCreature() {
        return this.room.getHealthiestCreature();
    }


    public boolean isAlive()
    {
        return this.isAlive;
    }


    public String getInfo() {
        return this.name + "(hp: " + this.health + ")";
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

        logger.info("csci.ooad.arcane.Adventurer " + this.getInfo() + " just ate " + foodToEat.getName());
    }
}
