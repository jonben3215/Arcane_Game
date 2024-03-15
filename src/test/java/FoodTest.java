import csci.ooad.arcane.Food;
import csci.ooad.arcane.FoodFactory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FoodTest {

    @Test
    public void TestFoodDefaultConstructor () {
        Food f1 = new Food("Apple");
        assertEquals(f1.getHealAmount(), 1);
        boolean food_found = false;
        for (String food : FoodFactory.FOOD_NAMES) {
            if (food.equals(f1.getName())) {
                food_found = true;
                break;
            }
        }
        assertTrue(food_found);
    }

    @Test
    public void TestDefaultConstructorRandomFood () {
        boolean different_name = false;
        for (int i = 0; i<10; i++) {
            Food f1 = new Food("Cheese");
            Food f2 = new Food("banana");
            // If the foods are different, make different name = true
            if (!(f1.getName().equals(f2.getName()))) {
                different_name = true;
                break;
            }
        }
        assertTrue(different_name);
    }

    @Test
    public void TestFoodNameConstructor () {
        Food f2 = new Food("Cheese");
        assertEquals(f2.getName(),"Cheese");
        assertEquals(f2.getHealAmount(), 1);
    }

    @Test
    public void TestFoodNameHealNumberConstructor () {
        Food f3 = new Food("Taco", 3);
        assertEquals(f3.getName(),"Taco");
        assertEquals(f3.getHealAmount(), 3);
    }
    @Test
    public void testCreateRandomFood() {
        FoodFactory foodFactory = new FoodFactory();
        Food randomFood = foodFactory.createRandomFood();

        assertNotNull(randomFood);
        assertTrue(Arrays.asList(FoodFactory.FOOD_NAMES).contains(randomFood.getName()));
        assertTrue(randomFood.getHealAmount() >= 1); // Ensure heal amount is at least 1
    }
    @Test
    public void testCreateFoodWithValidName() {
        FoodFactory foodFactory = new FoodFactory();
        Food cheese = foodFactory.createFood("Cheese");

        assertNotNull(cheese);
        assertEquals("Cheese", cheese.getName());
        assertEquals(1, cheese.getHealAmount()); // Default heal amount
    }
    @Test
    public void testCreateFoodWithCustomName() {
        FoodFactory foodFactory = new FoodFactory();
        Food customFood = foodFactory.createFood("Custom Food");

        assertNotNull(customFood);
        assertEquals("Custom Food", customFood.getName());
        assertEquals(1, customFood.getHealAmount()); // Default heal amount
    }
    @Test
    public void testCreateFoodWithSpecialCharacters() {
        FoodFactory foodFactory = new FoodFactory();
        Food specialFood = foodFactory.createFood("!@#$%^&*()");

        assertNotNull(specialFood);
        assertEquals("!@#$%^&*()", specialFood.getName());
        assertEquals(1, specialFood.getHealAmount()); // Default heal amount
    }

    @Test
    public void testCreateFoodWithEmptyName() {
        FoodFactory foodFactory = new FoodFactory();
        Food emptyNameFood = foodFactory.createFood("");

        assertNotNull(emptyNameFood);
        assertEquals("", emptyNameFood.getName()); // Empty name
        assertEquals(1, emptyNameFood.getHealAmount()); // Default heal amount
    }

    @Test
    public void testCreateFoodWithNullName() {
        FoodFactory foodFactory = new FoodFactory();
        Food nullNameFood = foodFactory.createFood(null);

        assertNotNull(nullNameFood);
        assertNull(nullNameFood.getName()); // Null name
        assertEquals(1, nullNameFood.getHealAmount()); // Default heal amount
    }

    @Test
    public void testCreateFoodWithNegativeHealAmount() {
        FoodFactory foodFactory = new FoodFactory();
        Food negativeHealFood = foodFactory.createFood("Banana");

        assertNotNull(negativeHealFood);
        assertEquals("Banana", negativeHealFood.getName());
        assertEquals(1, negativeHealFood.getHealAmount()); // Ensure it defaults to 1
    }


    @Test
    public void testCreateFoodWithLargeHealAmount() {
        FoodFactory foodFactory = new FoodFactory();
        Food largeHealFood = foodFactory.createFood("Apple");

        assertNotNull(largeHealFood);
        assertEquals("Apple", largeHealFood.getName());
        assertTrue(largeHealFood.getHealAmount() >= 1); // Ensure it defaults to 1 or greater
    }
}
