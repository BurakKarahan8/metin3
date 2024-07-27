package locations.buildings;

import entities.player.Player;
import locations.NormalLoc;

public class SafeHouse extends NormalLoc {
    public SafeHouse(Player player) {
        super(player,"Güvenli Ev");
    }

    @Override
    public boolean getLocation() {
        player.setHealty(player.getrHealty());
        System.out.println("İyileştiniz! Canınız:" + player.getrHealty() );
        System.out.println("Şuan güvenli ev adlı yerdesiniz");
        return true;
    }
}
