package csci.ooad.arcane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Entity {

    private static final Logger logger = LoggerFactory.getLogger(Entity.class);
    protected String name;
    protected Room room = null;
    private boolean isSettingRoom = false; // Flag to prevent recursive calls

    public Room getRoom() {
        return this.room;
    }

    // TODO: IMPORTANT Solution not decoupled enough
    // TODO:need an elegant solution for room and entity bidirectional pointing
    public void setRoom(Room newRoom) {
        if (this.room == newRoom) return; // If the new room is the same as the current room, do nothing
        if (isSettingRoom) return; // If already setting the room, do nothing

        isSettingRoom = true; // Set flag to true to prevent recursive calls

        // Remove from the current room
        if (this.room != null) {
            this.room.removeEntity(this);
        }

        // Update the room
        this.room = newRoom;

        // Add to the new room
        if (newRoom != null) {
            newRoom.addEntity(this);
        }

        isSettingRoom = false; // Reset flag
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getInfo() {
        return this.name;
    }
}
