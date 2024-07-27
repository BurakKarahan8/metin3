package entities.player;

import items.Inventory;

import java.util.Scanner;

public class Player {
    private int damage, healty, money, rHealty;
    private String name, cName;
    private Inventory inventory;
    Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectCha() {
        switch (chaMenu()) {
            case 1:
                setcName("Samuray");
                setDamage(5);
                setHealty(21);
                setMoney(15);
                setrHealty(21);
                break;
            case 2:
                initPlayer("Okçu", 7, 18, 20);
                break;
            case 3:
                initPlayer("Şövalye", 8, 24, 5);
                break;
        }
        System.out.println(" \nKarakter: " + getcName() + "\t Hasar:" + getDamage() + "\t Sağlık:" + getHealty() + "\t Para:" + getMoney());
    }

    public int chaMenu() {
        System.out.println("Lütfen bir karakter seçiniz: ");
        System.out.println("1- Samuray \t Hasar:5 \t Sağlık:21 \t Para:15");
        System.out.println("2- Okçu \t Hasar:7 \t Sağlık:18 \t Para:20");
        System.out.println("3- Şövalye \t Hasar:8 \t Sağlık:24 \t Para:5");
        System.out.print("Karakter seçiminiz: ");
        int chaID = input.nextInt();
        while (chaID < 1 || chaID > 3) {
            System.out.print("yanlış sayı girdiniz tekrar giriniz: ");
            chaID = input.nextInt();
        }
        return chaID;
    }

    public void initPlayer(String cName, int damage, int healty, int money) {
        setcName(cName);
        setDamage(damage);
        setHealty(healty);
        setMoney(money);
        setrHealty(healty);
    }

    public int getTotalDamage() {
        return this.getDamage() + this.getInventory().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealty() {
        return healty;
    }

    public void setHealty(int healty) {
        this.healty = healty;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getname() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void






    setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getrHealty() {
        return rHealty;
    }

    public void setrHealty(int rHealty) {
        this.rHealty = rHealty;
    }
}
