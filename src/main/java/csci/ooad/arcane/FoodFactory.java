package csci.ooad.arcane;

import java.util.Random;

public class FoodFactory {

    public static String[] FOOD_NAMES = {
            "Apple", "Orange", "Poo-Sandwich", "Taco", "Cookie", "ScoobySnack", "Annie's (TM) mac & cheese"
    };

    public Food createRandomFood() {
        // If no name specified, make random food name with heal amt = 1
        Random random = new Random();
        String randomName = FOOD_NAMES[random.nextInt(FOOD_NAMES.length)];
        return new Food(randomName);
    }

    public Food createFood(String name) {
        return new Food(name);
    }
}
