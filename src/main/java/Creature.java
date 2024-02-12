import java.util.Random;

public class Creature {
<<<<<<< HEAD
    private String CreatureName;
    private int creatureHealth;
    private int[] pos;//Position for the crature on the map

    private int roomIdx = 0;
    int number_creature = 5;
=======
    private String Name;
    private int pos[];//Position for the crature on the map
>>>>>>> largeD
    private double health;

    // On constructor, set random starting postion, name, health=5

<<<<<<< HEAD
    public Creature(String Cname, int Chealth)
    {
        this.CreatureName = Cname;
        this.creatureHealth = Chealth;
        pos = new int[number_creature];
    }
    public String getName()
    {
        return this.CreatureName;
    }
    public int getCreatureHealth()
    {
        return this.creatureHealth;
    }

    public void setCreatureHealth(int Chealth )
    {
        this.creatureHealth = Chealth;
    }

    public boolean isAlive()
    {
        return creatureHealth > 0;
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

//    public void displayCreaturePosition()
//    {
//        for (int po : pos) System.out.println(po);
//    }

    public boolean checkIfCreature(int newRoomIdx) {
        for (int existingRoomIdx : pos) {
            if (existingRoomIdx == newRoomIdx) {
                System.out.println("Creature Found");
                return true;
            }
        }
        return false;
    }



=======
    public Creature(String name)
    {
        this.Name = name;
    }
    public String getName()
    {
        return this.Name;
    }

>>>>>>> largeD
}
