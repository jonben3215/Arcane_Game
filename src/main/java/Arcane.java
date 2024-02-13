public class Arcane {


    //THIS IS COHESION
    public void Fight(Adventurer adventurer, Creature creature)
    {
        int playerNumber = adventurer.playerRoll();
        int creatureNumber = creature.Creature_Roll();

        System.out.println("Player Rolled a " + playerNumber);
        System.out.println("Creature Rolled a " + creatureNumber);
        if(playerNumber == creatureNumber)
        {
            System.out.println("Its a tie");
        }
        else if(playerNumber < creatureNumber)
        {
            System.out.println("Player lost battle.");
            double playerHealth = adventurer.getHealth() - (creatureNumber - playerNumber);
            adventurer.setHealth(playerHealth);

        }
        else{
            System.out.println("Player Won battle.");
            double creatureHealth = creature.getHealth() - (playerNumber-creatureNumber);
            adventurer.setHealth(creatureHealth);
        }
    }
}
