package csci.ooad.arcane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Entity {

    private static final Logger logger = LoggerFactory.getLogger(Entity.class);
    protected String name;
    protected Room room = null;

    public Room getRoom() {
        return this.room;
    }

    // TODO: IMPORTANT Solution not decoupled enough
    // TODO:need an elegant solution for room and entity bidirectional pointing
    public void setRoom(Room newRoom) {
        if(this.room == newRoom) return; // This single line of code prevents infinite recursion
        if(this.room != null) this.room.removeEntity(this);
        this.room = newRoom;
        if(newRoom != null) this.room.addEntity(this);
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
