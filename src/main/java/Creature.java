import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Creature {

    private static final Logger logger = LoggerFactory.getLogger(Adventurer.class);
    private String name;

    private boolean isAlive = true;
    private Room room = null;
    private double health;
    private int[] pos;//Position for the creature on the map

    private int roomIdx = 0;
    int number_creature = 5;


    // On constructor, set random starting postion, name, health=5
    public Creature(String name, int health)
    {
        this.name = name;
        this.health = health;
        pos = new int[number_creature];
    }

    public String getName()
    {
        return this.name;
    }
    public double getHealth()
    {
        return this.health;
    }

    public void setHealth(double health) {
        // Update hp
        this.health = health;
        // Kill player if hp drops below zero, ensure hp >= 0
        if (this.health <= 0) {
            this.health = 0;
            this.isAlive = false;
            this.setRoom(null);
            logger.info("Creature " + this.getName() + " was killed");
        } else {
            this.isAlive = true;
        }
    }
    public boolean isAlive()
    {
        return health > 0;
    }

    public int Creature_Roll()
    {
        Random numGenerator = new Random();

        //Generates a number from 1 to 6 similar to a die
        return numGenerator.nextInt(6)+1;
    }

    private boolean isRoomIdxUsed(int newRoomIdx) {
        for (int existingRoomIdx : pos) {
            if (existingRoomIdx == newRoomIdx) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfCreature(int newRoomIdx)
    {
        for (int existingRoomIdx : pos) {
            if (existingRoomIdx == newRoomIdx) {
                System.out.println("Creature Found");
                return true;
            }
        }
        return false;
    }

    public void setRoom(Room room)
    {
        this.room.removeCreature(this);
        this.room = room;

        if(this.room != null) {
            this.room.addCreature(this);
        }
    }


    public Creature(String name)
    {
        this.name = name;
    }

    public void takeDamage(double damage) {
        // Negative damage does nothing
        if (damage < 0) {return;}
        // Damage player with checks in setHealth
        setHealth(this.health-damage);
    }

}
