import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MazeTest {
    @Test
    public void DefaultMazeCreation() {
        Maze maze = new Maze();
        assertNotNull(maze);

        // TODO Check Default Values
    }

    @Test
    public void RectangleMazeCreation() {
        Maze maze = new Maze();
        assertNotNull(maze);

        // TODO Check Default Values

        int rows = 10;
        int cols = 20;

        maze.GenerateRectangleMaze(rows,cols);

        assertNull(maze.getRoomByID(-1));

        ArrayList<Room> rectRoomArray = maze.getRooms();

        Room nwCorner = rectRoomArray.get(0);
        Room neCorner = rectRoomArray.get(cols-1);
        Room swCorner = rectRoomArray.get(rectRoomArray.size()-cols);
        Room seCorner = rectRoomArray.get(rectRoomArray.size()-1);

        System.out.println(nwCorner.neighbors);
        System.out.println(neCorner.neighbors);
        System.out.println(swCorner.neighbors);
        System.out.println(seCorner.neighbors);

        // assertEquals(nwCorner.neighbors, 0);


    }

}