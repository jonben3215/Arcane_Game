public class Arcane {

    public void Fight(Player player, Creature creature)
    {
        int playerNumber = player.playerRoll();
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
            int playerHealth = player.getHealth() - (creatureNumber - playerNumber);
            player.setHealth(playerHealth);

        }
        else{
            System.out.println("Player Won battle.");
            int creatureHealth = creature.getCreatureHealth() -  (playerNumber-creatureNumber);
            player.setHealth(creatureHealth);
        }
    }
}
