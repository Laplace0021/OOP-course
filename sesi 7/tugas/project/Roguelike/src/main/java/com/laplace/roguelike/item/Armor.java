package com.laplace.roguelike.item;

import com.laplace.roguelike.Interface.Equipable;
import com.laplace.roguelike.entity.Player;
import com.laplace.roguelike.enums.ItemRarity;

public class Armor extends BaseItem implements Equipable{
    private int def;
    public Armor(String name, String description, ItemRarity rarity,int price, int def){
        super(name, description, rarity, price);
        this.def=def;
    }

    public int getDef() {
        return def;
    }

    @Override
    public boolean isStackable() {
        return false;
    }

    @Override
    public void equip(Player player) {
        player.equipArmor(this);
    }
}
