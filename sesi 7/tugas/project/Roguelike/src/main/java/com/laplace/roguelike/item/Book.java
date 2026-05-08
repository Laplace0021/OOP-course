package com.laplace.roguelike.item;

import com.laplace.roguelike.entity.Player;
import com.laplace.roguelike.enums.ItemRarity;

public class Book extends BaseItem{
    private int hp;
    private int atk;
    private int def;

    public Book(String name, 
                String description, 
                ItemRarity rarity, 
                int price, 
                int hp, 
                int atk, 
                int def){
        super(name, description, rarity, price);
        this.hp=hp;
        this.atk=atk;
        this.def=def;
    }

    @Override
    public boolean isStackable() {
        return false;
    }

    public void apply(Player player){
        player.addMaxHp(hp);
        player.addAtk(atk);
        player.addDef(def);

        System.out.println(player.getName()+" learned from "+getName());
    }
}
