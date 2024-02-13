import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Adventurer {
    private static final Logger logger = LoggerFactory.getLogger(Adventurer.class);

    private String name;
    private double health;
    private Room room = null;
    private boolean isAlive = true;

    public Adventurer() {
        this.name  = "";
        this.health = 5; // Default
    }

    public Adventurer(String user_Name, double health) {
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
    public void setHealth(double health) {
        // Update hp
        this.health = health;
        // Kill player if hp drops below zero, ensure hp >= 0
        if (this.health <= 0) {
            this.health = 0;
            isAlive = false;
            logger.info("Adventurer " + this.getName() + " was killed");
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
    public void setRoom(Room room)
    {
        this.room = room;
    }


    public void player_Movement(Maze maze, int direction) {



    }



    public int playerRoll()
    {
        Random numGenerator = new Random();

        //Generates a number from 1 to 6 similar to a die
        return numGenerator.nextInt(6)+1;
    }


    public boolean isAlive()
    {
        return this.isAlive;
    }
}
