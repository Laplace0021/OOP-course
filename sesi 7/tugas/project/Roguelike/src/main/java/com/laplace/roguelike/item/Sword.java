package com.laplace.roguelike.item;
import com.laplace.roguelike.Interface.Equipable;
import com.laplace.roguelike.entity.Player;
import com.laplace.roguelike.enums.ItemRarity;
public class Sword extends BaseItem implements Equipable {
    private int atk;
    public Sword(String name, String description, ItemRarity rarity, int price, int atk){
        super(name, description, rarity, price);
        this.atk=atk;
    }

    public int getAtk() {
        return atk;
    }

    @Override
    public boolean isStackable() {
        return false;
    }
    
    @Override
    public void equip(Player player) {
        player.equipSword(this);
    }
}
