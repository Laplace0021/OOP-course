package com.laplace.roguelike.entity;

import com.laplace.roguelike.Inventory.Inventory;
import com.laplace.roguelike.item.Armor;
import com.laplace.roguelike.item.Sword;

public class Player extends Entity {
    private int gold;
    private int exp;
    private int RequiredExp;
    private Inventory inventory;
    private Sword equippedSword;
    private Armor equippedArmor;
    public Player(String name){
        super(name, 1, 10000, 1000, 100);
        gold =0;
        exp=0;
        RequiredExp = 1000;
        inventory = new Inventory();
    }

    public void addExp(int amount){
        exp += amount;

        while (exp>= RequiredExp) {
            levelUp();
        }
    }

    public void addGold(int amount){
        gold+=amount;
    }

    @Override
    public void displayStatus() {
        System.out.println("-".repeat(50));
        System.out.println(getName()+"     ("+getLevel()+")");
        System.out.println("HP: "+getHp());
        System.out.println("-".repeat(50));
    }
    @Override
    public void levelUp() {
        exp -= RequiredExp;
        level++;
        RequiredExp = 1000 + (getLevel() *250);
        newStat();
        heal(getMaxHp() / 4);
    }
    public void getStats(){
        System.out.println("Name    : "+getName());
        System.out.println("Level   : "+getLevel());
        System.out.println("Exp     : "+ exp+"/"+RequiredExp);
        System.out.println("Health  : "+getHp()+"/" +getMaxHp());
        System.out.println("Attack  : "+getAtk());
        System.out.println("Defense : "+getDef());
        System.out.println("Gold    : "+getGold());
    }

    public void newStat(){
        maxHp = (int)(maxHp * 1.04);
        atk = (int)(atk * 1.03);
        def = (int)(def * 1.02);
    }

    public boolean spendGold(int amount){
        if (gold>=amount) {
            gold-=amount;
            return true;
        }
        return false;
    }
    public int getGold(){
        return gold;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    public Sword getEquippedSword() {
        return equippedSword;
    }

    public void equipSword(Sword sword) {

    if(equippedSword != null) {
        addAtk(-equippedSword.getAtk());
    }

    equippedSword = sword;

    addAtk(sword.getAtk());

    System.out.println(
        getName() +
        " equipped " +
        sword.getName()
    );
    }
    public void equipArmor(Armor armor) {

    if(equippedArmor != null) {
        addDef(-equippedArmor.getDef());
    }

    equippedArmor = armor;

    addDef(armor.getDef());

    System.out.println(
        getName() +
        " equipped " +
        armor.getName()
    );
    }
}
