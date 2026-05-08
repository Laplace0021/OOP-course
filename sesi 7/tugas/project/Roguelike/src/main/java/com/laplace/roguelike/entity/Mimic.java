package com.laplace.roguelike.entity;

public class Mimic extends Enemy {
    private boolean isHidden;

    public Mimic(int level, int hp,int atk, int def){
        super("Treasure Chess...?", level, hp, atk, def);
        this.isHidden=true;
    }
    
    @Override
    public void attackTarget(Entity target) {
        if (isHidden) {
            System.out.println("The chest suddenly moves... IT'S A MIMIC!");
            target.takeDamage(getAtk(),true);
            this.isHidden=false;
        }else{
            super.attackTarget(target);
        }
    }
    
}
