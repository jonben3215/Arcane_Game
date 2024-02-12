import org.junit.jupiter.api.Test;

public class ArcaneTest {

    @Test
    public void test_Fight()
    {
        Arcane arcane = new Arcane();
        Creature creature = new Creature("wolf", 10);
        Player player = new Player("Ben", 10);

        arcane.Fight(player,creature);

    }
}
