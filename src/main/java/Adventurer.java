import java.util.Random;

public class Adventurer {

    private String userName;
    private int userHealth;
    private int roomIdx = 0;


    // THIS IS ENCAPSULATION / INFORMATION HANDLING
    public Adventurer(String user_Name, int health)
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
        return this.roomIdx;
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
        roomIdx = position;
    }
    // THIS IS THE END OF ENCAPSULATION / INFORMATION HANDLING

    //THIS IS COHESION
    public boolean isValidPosition(Maze maze) {
        int rows = maze.getRow();
        int cols = maze.getCol();
        return roomIdx >= 0 && roomIdx < rows * cols;
    }



    public void player_Movement(Maze maze, int direction) {
        int cols = maze.getCol();

        switch (direction) {
            case 1: //North
                roomIdx -= cols;
                break;
            case 2: //East
                roomIdx += 1;
                break;
            case 3: //south
                roomIdx += cols;
                break;
            case 4: //west
                roomIdx -= 1;
                break;
            default:
                System.out.println("INVALID MOVE!");
                return;
        }

        if (!isValidPosition(maze)) {
            System.out.println("Out of bounds.");
            System.out.println("Player trying to move to room: " + roomIdx);
        } else {
            System.out.println("Moving to room: " + roomIdx);
            setPosition(roomIdx);
        }
    }

    //THIS IS THE END OF COHESION


    public int playerRoll()
    {
        Random numGenerator = new Random();

        //Generates a number from 1 to 6 similar to a die
        return numGenerator.nextInt(6)+1;
    }

    public boolean isHealthier(Adventurer p1, Adventurer p2) //For multi-Player only
    {
        return p1.getHealth()>p2.getHealth();
    }

    public boolean isAlive()
    {
        return userHealth > 0;
    }
}
