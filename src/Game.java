import entities.player.Player;
import locations.*;
import locations.buildings.SafeHouse;
import locations.buildings.ToolStore;
import locations.naturel_environments.Cave;
import locations.naturel_environments.Forest;
import locations.naturel_environments.River;

import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner input = new Scanner(System.in);
    public void login() {
        Scanner input = new Scanner(System.in);
        System.out.println("Macera oyununa hoşgeldiniz!!!");
        System.out.print("Lütfen adınızı giriniz: ");
        String playerName = input.nextLine();
        player = new Player(playerName);
        player.selectCha();
        start();
    }

    public void start() {
        while (true) {
            System.err.println("\n" + "===========================================================" + "\n");
            System.out.println("Eylem gerçekleştirmek için bir yer seçiniz: ");
            System.out.println("1. Güvenli Ev --> Size ait güvenli ev, düşman yok!");
            System.out.println("2. Mağara --> Karşınıza zombi çıkabilir!");
            System.out.println("3. Orman --> Karşınıza vampir çıkabilir!");
            System.out.println("4. Nehir --> Karşınıza ayı çıkabilir!");
            System.out.println("5. Mağaza --> Silah veya zırh alabilirsiniz!");
            System.out.print("Gitmek istediğiniz yer: ");
            int selLoc = input.nextInt();
            while (selLoc < 0 || selLoc > 5) {
                System.out.print("Lütfen geçerli bir yer seçiniz: ");
                selLoc = input.nextInt();
            }
            switch (selLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
                }
                if (player.getInventory().isWater() && player.getInventory().isFood() && player.getInventory().isFireWood()){
                    System.out.println("!!!!!!!!!!!!!!Tebrikler oyunu kazandınız!!!!!!!!!!!!!!");
                    break;
                }

            if(!location.getLocation()){
                System.out.println("Oyun Bitti !");
                break;
            }
        }
    }
}
