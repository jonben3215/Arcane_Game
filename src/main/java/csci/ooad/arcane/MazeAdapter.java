package csci.ooad.arcane;

import csci.ooad.layout.IMaze;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MazeAdapter implements IMaze {
    private final Maze maze; // Your existing Maze class

    public MazeAdapter(Maze maze) {
        this.maze = maze;
    }

    @Override
    public List<String> getRooms() {
        // You can use Stream API for more concise code if you're using Java 8 or above
        return maze.getRooms().stream()
                .map(Room::getName)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public List<String> getNeighborsOf(String roomName) {
        Room room = maze.getRoomByName(roomName);
        if (room != null) {
            return room.getNeighbors().values().stream()
                    .map(Room::getName)
                    .collect(Collectors.collectingAndThen(Collectors.toList(),
                            Collections::unmodifiableList));
        }
        return Collections.emptyList();
    }

    @Override
    public List<String> getContents(String roomName) {
        Room room = maze.getRoomByName(roomName);
        if (room != null) {
            return room.getAdventurers().stream()
                    .map(Adventurer::getInfo)
                    .collect(Collectors.toList());
            // Add other entities like Creatures and Food if needed
        }
        return Collections.emptyList();
    }
}
