import java.util.Vector;

public class Creature {
    private String CreatureName;
    private int creatureHealth;
    private int pos[];//Position for the crature on the map
    private double health;

    // On constructor, set random starting postion, name, health=5

    public Creature(String Cname, int Chealth)
    {
        this.CreatureName = Cname;
        this.creatureHealth = Chealth;
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

    public void creatureMovement(int x, int y)
    {

    }
}
