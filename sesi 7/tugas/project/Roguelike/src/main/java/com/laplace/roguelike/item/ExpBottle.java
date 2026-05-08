package com.laplace.roguelike.item;

import com.laplace.roguelike.Interface.Usable;
import com.laplace.roguelike.entity.Player;
import com.laplace.roguelike.enums.ItemRarity;

public class ExpBottle extends BaseItem implements Usable{
    private int expAmount;

    public ExpBottle(String name, String description, ItemRarity rarity, int price, int expAmount){
        super(name, description, rarity, price);
        this.expAmount=expAmount;
    }

    @Override
    public void use(Player player) {
        player.addExp(expAmount);
        System.out.println(player.getName()+" gained "+ expAmount+ " EXP");
    }

    @Override
    public boolean isStackable() {
        return true;
    }
}
