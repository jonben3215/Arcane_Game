public class Player {

    private String userName;
    private int userHealth;

    public Player(String user_Name, int health)
    {
        this.userName  = user_Name;
        this.userHealth = health;
    }
    public String getName()
    {
        return userName;
    }
    public int getHealth()
    {
        return userHealth;
    }
    public void setHealth(int health)
    {
        this.userHealth = health;
    }
    public void setName(String user_Name)
    {
        this.userName = user_Name;
    }
}
