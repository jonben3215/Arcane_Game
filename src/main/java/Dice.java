import java.util.Random;

public class Dice {
    private int numSides;

    public int roll () {
        // random from 1 to num sides inclusive
       Random numGenerator = new Random();

        //Generates a number from 1 to 6 similar to a die
       return numGenerator.nextInt(6)+1;

    }
}
