package com.laplace.roguelike.entity;

public class Boss extends Enemy{
    boolean isEnraged;

    public Boss(String name, int level, int hp,int atk, int def){
        super(name, level, hp, atk, def);
        isEnraged=false;
    }

    @Override
    public void takeDamage(int damage, boolean ignoreDefense) {
        // TODO Auto-generated method stub
        super.takeDamage(damage, ignoreDefense);
        if (!isEnraged && this.getHp() <= (this.getMaxHp()/2) && this.isAlive()) {
            isEnraged =true;
            int atkBoost = 2000;
            int defBoost = 300;

            addAtk(atkBoost);
            addDef(defBoost);
            System.out.println(getName() + " gains +" + atkBoost + " ATK and +" + defBoost + " DEF!");
        }
    }

    
}
