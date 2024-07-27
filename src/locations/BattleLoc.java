package locations;

import entities.player.Player;
import items.Obstacle;

public abstract class BattleLoc extends Location {
    protected Obstacle obstacle;
    protected String award;
    BattleLoc(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.name=name;
        this.obstacle= obstacle;
        this.award= award;
    }

    @Override
    public boolean getLocation() {
        int obsCount = obstacle.count();
        System.out.println("Şuan buradasınız: " + this.getName());
        System.out.println("Dikkatli ol ! Burada " + obsCount + " tane " + obstacle.getName() + " yaşıyor...");
        System.out.print("<S>avaş veya <K>aç: ");
        String selCase = input.nextLine();
        selCase = selCase.toUpperCase();
        if (selCase.equals("S")){
            if (combat(obsCount)){
                System.out.println(this.getName() + " bölgesindeki tüm düşmanları temizlediniz !!!");
                if (this.award.equals("Yemek") && player.getInventory().isFood() == false){
                    System.out.println(this.award + " kazandınız !!! ");
                    player.getInventory().setFood(true);
                }else if (this.award.equals("Odun") && player.getInventory().isFireWood() == false){
                    System.out.println(this.award + " kazandınız !!! ");
                    player.getInventory().setFireWood(true);
                }else if (this.award.equals("Su") && player.getInventory().isWater() == false){
                    System.out.println(this.award + " kazandınız !!! ");
                    player.getInventory().setWater(true);
                }
                return true;
            } if(player.getHealty() <= 0) {
                System.out.println("Öldünüz !!!");
                return false;
            }
        }
        return true;
    }
    public boolean combat(int obsCount){
        for (int i=0 ; i<obsCount ; i++){
            int defObsHealth = obstacle.getHealth();
            playerStats();
            enemyStats();
            while (player.getHealty() > 0 && obstacle.getHealth() > 0 ){
                System.out.print("<V>ur veya <K>aç: ");
                String selCase = input.nextLine();
                selCase = selCase.toUpperCase();
                if (selCase.equals("V")) {
                    System.out.println(" \nCanavara vurdunuz !!!");
                    obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                    System.out.println("Oyuncu canı: " + player.getHealty());
                    System.out.println(obstacle.getName() + " canı: " + obstacle.getHealth() + "\n");
                    if (obstacle.getHealth() > 0) {
                        System.out.println("Canavar size vurdu: ");
                        player.setHealty(player.getHealty() - (obstacle.getDamage() - player.getInventory().getArmor()));
                        System.out.println("Oyuncu canı: " + player.getHealty());
                        System.out.println(obstacle.getName() + " canı: " + obstacle.getHealth() + "\n");
                    }
                } else {
                    return false;
                }
            }
            if(obstacle.getHealth() <= 0 && player.getHealty() > 0){
                System.out.println("Düşmanı yendiniz !!!");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("Güncel paranız: " + player.getMoney());
                obstacle.setHealth(defObsHealth);
            }else {
                return false;
            }
            System.out.println("------------------------");
        }
        return true;
}
    public void playerStats(){
        System.out.println("Oyuncu değerleri \n -------------------------------");
        System.out.println("Can: " + player.getHealty());
        System.out.println("Hasar: " + player.getTotalDamage());
        System.out.println("Para: " + player.getMoney());
        if (player.getInventory().getDamage() > 0){
            System.out.println("Silah: " + player.getInventory().getwName());
        }
        if (player.getInventory().getArmor() > 0){
            System.out.println("Zırh: " + player.getInventory().getaName());
        }
    }
    public void enemyStats(){
        System.out.println("\n" + obstacle.getName() + " Değerleri \n -------------------------------");
        System.out.println("Can: " + obstacle.getHealth());
        System.out.println("Hasar: " + obstacle.getDamage());
        System.out.println("Ödül: " + obstacle.getAward());

    }
}