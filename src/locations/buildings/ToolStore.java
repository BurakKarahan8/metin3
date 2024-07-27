package locations.buildings;

import entities.player.Player;
import locations.NormalLoc;

public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean getLocation() {
        System.out.println("Mağazadasınız paranız: " + player.getMoney());
        System.out.println("1. Silahlar");
        System.out.println("2. Zırhlar");
        System.out.println("3. ÇIKIŞ");
        System.out.print("Seçiminiz: ");
        int selTool= input.nextInt();
        int selItemID;
        switch (selTool){
            case 1:
                selItemID = weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID = armorMenu();
                buyArmor(selItemID);
                break;
            case 3:
                System.out.println("Çıkış yapılıyor...");
                break;
            default:
                System.out.println("Geçersiz işlem !!!");
                break;
        }
        return true;
    }
    public int weaponMenu(){
        System.out.println("1. --> Tabanca \t <Para : 25 - Hasar : 2>");
        System.out.println("2. --> Kılıç \t <Para : 35 - Hasar : 3>");
        System.out.println("3. --> Tüfek \t <Para : 45 - Hasar : 7>");
        System.out.println("4. --> ÇIKIŞ");
        System.out.print("Silah seçiniz: ");
        int selWeapon = input.nextInt();
        return selWeapon;
    }
    public void buyWeapon(int itemID){
        int damage=0, price = 0;
        String wName = null;
        switch (itemID){
            case 1:
                damage=2;
                wName="Tabanca";
                price=25;
                break;
            case 2:
                damage=3;
                wName="Kılıç";
                price=35;
                break;
            case 3:
                damage=7;
                wName="tüfek";
                price=45;
                break;
            case 4:
                System.out.println("Çıkış yapılıyor...");
                break;
            default:
                System.out.println("Geçersiz işlem !!!");
                break;
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInventory().setDamage(damage);
                player.getInventory().setwName(wName);
                player.setMoney(player.getMoney() - price);
                System.out.println(wName + " Satın aldınız, Önceki hasar : " + player.getDamage() +
                        " Yeni hasar: " + player.getTotalDamage());
                System.out.println("Kalan bakiye: " + player.getMoney());
            } else {
                System.out.println("Bakiye yetersiz !!!");
            }
        }
    }
    public int armorMenu() {
        System.out.println("1. --> Hafif \t <Para : 15 - Hasar : 1>");
        System.out.println("2. --> Orta \t <Para : 25 - Hasar : 3>");
        System.out.println("3. --> Ağır \t <Para : 40 - Hasar : 5>");
        System.out.println("4. --> ÇIKIŞ");
        System.out.print("Zırh seçiniz: ");
        int selArmor = input.nextInt();
        return selArmor;
    }
    public void buyArmor(int itemID){
        int avoid=0, price = 0;
        String aName = null;
        switch (itemID){
            case 1:
                avoid=1;
                aName="Hafif Zırh";
                price=15;
                break;
            case 2:
                avoid=3;
                aName="Orta Zırh";
                price=25;
                break;
            case 3:
                avoid=5;
                aName="Ağır Zırh";
                price=40;
                break;
            case 4:
                System.out.println("Çıkış yapılıyor...");
                break;
            default:
                System.out.println("Geçersiz işlem !!!");
                break;
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInventory().setArmor(avoid);
                player.getInventory().setaName(aName);
                player.setMoney(player.getMoney() - price);
                System.out.println(aName + " Satın aldınız, Engellenen hasar : " + player.getInventory().getArmor());
                System.out.println("Kalan bakiye: " + player.getMoney());
            } else {
                System.out.println("Bakiye yetersiz !!!");
            }
        }
    }
}
