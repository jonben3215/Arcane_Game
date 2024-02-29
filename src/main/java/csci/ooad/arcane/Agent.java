package csci.ooad.arcane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Agent {
    private static final Logger logger = LoggerFactory.getLogger(Agent.class);

    // ---------- Member Variables ---------- //
    protected String name;
    protected double health; // TODO: Implement max health / difference between initial and current hp
    protected Room room = null;
    protected boolean isAlive = true;
    // DefaulRt is just roll 6 sided die (min:1, max:6)
    private double minAttack = 1, maxAttack = 6;



    public String getRoomName() {
        return this.room.getName();
    }



    public Map<Direction, Room> getValidMoves()
    {
        if (this.room == null) return new HashMap<>();
        return this.room.getNeighbors();
    }





    // ---------- Constructors ---------- //

    public Agent() {
        this.name = "";
        this.health = 1;
    }
    public Agent(String name) {
        this.name = name;
    }

    public Agent(String name, double health) {
        this.name = name;
        this.health = health;
    }


    // ---------- Methods ---------- //
    public void doAction() {
        // Override for classes, TODO use behavior pattern
    }

    // Effectively same as "roll dice", gets the number of damage to deal
    public double calcDamage() {
        Random random = new Random();
        // Generate a random int-rounded value between min and max
        double calcedDamage = (double)random.nextInt(((int) maxAttack - (int) minAttack) + 1) + (int) minAttack;
        logger.debug(this.getInfo() + " calculated damage: " + calcedDamage);
        return calcedDamage;
    }
    public void takeDamage(double damage) {
        // Negative damage does nothing
        if (damage < 0) {return;}
        // Damage player with checks in setHealth
        setHealth(this.health-damage);
    }

    public void heal(double healAmt) {
        // Negative damage does nothing
        if (healAmt < 0) {return;}
        // Damage player with checks in setHealth
        setHealth(this.health+healAmt);
    }

    // TODO: These move functions should be a move behavior pattern.
    public void move(Room room) {
        this.setRoom(room);
    }

    public void move(Direction direction) {

        if (room == null) {
            logger.warn(this.getInfo() + " cannot move by direction. (Not currently in a room to move from)");
            return;
        }

        Room newRoom = this.getValidMoves().get(direction);

        if (newRoom == null) {
            logger.warn("Invalid move. Direction key resulted in null.");
            return;
        }

        setRoom(newRoom);
    }

    // ---------- Helpers ---------- //
    public boolean foodPresentInRoom() {
        return this.room.hasFood();
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    // ---------- Getters / Setters ---------- //
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return this.room;
    }
    public void setRoom(Room newRoom) {
        if(this.room != null) this.room.removeAgent(this);
        this.room = newRoom;
        if(newRoom != null) this.room.addAgent(this);
    }

    public double getHealth() {
        return health;
    }
    public void setHealth(double health) {
        // Update hp
        this.health = health;
        // Kill player if hp drops below zero, ensure hp >= 0
        if (this.health <= 0) {
            this.die();
        } else {
            isAlive = true;
        }
    }

    public void die() {
        this.health = 0;
        this.isAlive = false;
        this.setRoom(null);

        logger.info(this.getClass().getSimpleName() + ": " + this.getName() + " was killed");
    }

    public String getInfo() {
        return this.name + "(hp: " + this.health + ")";
    }
}