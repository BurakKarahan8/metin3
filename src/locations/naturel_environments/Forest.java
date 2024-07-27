package locations.naturel_environments;

import entities.player.Player;
import entities.character.Vampire;
import locations.BattleLoc;

public class Forest extends BattleLoc {
    public Forest(Player player) {
        super(player, "Orman", new Vampire(), "Odun");
    }
}
