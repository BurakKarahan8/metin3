package locations.naturel_environments;

import entities.character.Bear;
import entities.player.Player;
import locations.BattleLoc;

public class River extends BattleLoc {
    public River(Player player) {
        super(player, "Nehir", new Bear(), "Su");
    }
}
