import java.util.Random;

public class Creature {
    private String name;
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

    public void setHealth(double Chealth )
    {
        this.health = health;
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

    public void spawnCreature(Maze maze)
    {
        Random random = new Random();

        for (int i = 0; i < number_creature; i++)
        {
            int newRoomIdx;
            do {
                newRoomIdx = random.nextInt(9) + 1;
            } while (isRoomIdxUsed(newRoomIdx)); // Check if the new room index is already in pos array

            this.pos[i] = newRoomIdx;
        }
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

    public Creature(String name)
    {
        this.name = name;
    }

}
