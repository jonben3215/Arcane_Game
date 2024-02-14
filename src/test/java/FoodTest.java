import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FoodTest {

    @Test
    public void TestFoodDefaultConstructor () {
        Food f1 = new Food();
        assertEquals(f1.getHealAmount(), 1);
        boolean food_found = false;
        for (String food : Food.FOOD_NAMES) {
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
            Food f1 = new Food();
            Food f2 = new Food();
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
}
