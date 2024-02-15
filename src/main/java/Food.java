import java.util.Random;

public class Food {
    public static String[] FOOD_NAMES = {
            "Apple", "Orange", "Poo-Sandwich", "Taco", "Cookie", "ScoobySnack", "Annie's (TM) mac & cheese"
    };
    private String name = "";
    private double healAmount = 1;

    private Room room = null;

    public Food () {
        // If no name specified, make random food name with heal amt = 1
        Random random = new Random();
        this.name = FOOD_NAMES[random.nextInt(FOOD_NAMES.length)];
    }
    public Food (String name) {
        this.name = name;
    }

    public Room getRoom() {
        return this.room;
    }

    public void setRoom(Room newRoom) {

        if(this.room != null) this.room.removeFood(this);
        this.room = newRoom;
        if(newRoom != null) this.room.addFood(this);

    }

    public Food (String name, int healAmount) {
        this.name = name;
        this.healAmount = healAmount;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealAmount() {
        return this.healAmount;
    }

    public void setHealAmount(double healAmount) {
        this.healAmount = healAmount;
    }

}
