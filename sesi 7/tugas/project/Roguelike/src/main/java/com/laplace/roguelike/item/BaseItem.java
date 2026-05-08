package com.laplace.roguelike.item;

import com.laplace.roguelike.enums.ItemRarity;

public abstract class BaseItem  {
    protected String name;
    protected String description;
    protected ItemRarity rarity;
    protected int price;


    public BaseItem(String name, String description, ItemRarity rarity2, int price){
        this.name=name;
        this.description=description;
        this.rarity=rarity2;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public ItemRarity getRarity() {
        return rarity;
    }

    public abstract boolean isStackable();




}
