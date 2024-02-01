import java.util.Vector;

public class Creature {
    private String Name;
    private int pos[];//Position for the crature on the map
    private double health;

    // On constructor, set random starting postion, name, health=5

    public Creature(String name)
    {
        this.Name = name;
    }
    public String getName()
    {
        return this.Name;
    }

}
