package com.laplace.roguelike.item;
import com.laplace.roguelike.Interface.Usable;
import com.laplace.roguelike.entity.Player;
import com.laplace.roguelike.enums.ItemRarity;

public class HealingPotion extends BaseItem implements Usable {
    private int healAmount;

    public HealingPotion(String name, String description, ItemRarity rarity, int price, int healAmount){
        super(name, description, rarity, price);
        this.healAmount=healAmount;
    }
    public int getHealAmount() {
        return healAmount;
    }

    @Override
    public boolean isStackable() {
        return true;
    }

    @Override
    public void use(Player player) {
        player.heal(healAmount);
        System.out.println(player.getName()+" healed"+ healAmount+" HP");
    }
}
