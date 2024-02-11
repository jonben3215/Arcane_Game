public class Player {

    private String userName;
    private int userHealth;

    private int userPosition;

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
    public int getPosition()
    {
        return this.userPosition;
    }
    public void setHealth(int health)
    {
        this.userHealth = health;
    }
    public void setName(String user_Name)
    {
        this.userName = user_Name;
    }
    public void setPosition(int position)
    {
        userPosition = position;
    }

    public void player_Movement(Room room,int North, int East, int South, int West)
    {

       System.out.println(room.getID());
    }

    public boolean isAlive()
    {
        return userHealth > 0;
    }
}
