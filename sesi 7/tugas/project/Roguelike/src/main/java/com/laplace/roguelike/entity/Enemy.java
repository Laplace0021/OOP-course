package com.laplace.roguelike.entity;

public class Enemy extends Entity{
    public Enemy(String name,int level,int maxHp,int atk,int def){
        super(name, level, maxHp, atk, def);
    }
    
    @Override
    public void displayStatus() {
        System.out.println("-".repeat(50));
        System.out.println(" [ENEMY] "+ getName()+"     ("+getLevel()+")");
        System.out.println("HP: "+getHp());
        System.out.println("-".repeat(50));

    }
}
