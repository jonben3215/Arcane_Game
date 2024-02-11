import org.junit.jupiter.api.Test;

public class DiceTest {

    @Test
    public void Test_DiceRoll()
    {
        Dice die = new Dice();
        int number = die.roll();

        System.out.print(number);

        //Making sure the Generated number is within 1 and 6
        if(number >= 1 && number <= 6)
            assert true;
        else
            assert false;
    }

}
