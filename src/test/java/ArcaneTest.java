import org.junit.jupiter.api.Test;

public class ArcaneTest {

    @Test
    public void test_Fight()
    {
        Arcane arcane = new Arcane();
        Creature creature = new Creature("wolf", 10);
        Adventurer player = new Adventurer("Ben", 10);

        arcane.Fight(player,creature);

    }
}
