package locations.naturel_environments;

import entities.player.Player;
import entities.character.Zombie;
import locations.BattleLoc;

public class Cave extends BattleLoc {
    public Cave(Player player) {
        super(player, "Mağara", new Zombie(), "Yemek");
    }

}
