package com.laplace.roguelike.Inventory;
import com.laplace.roguelike.item.BaseItem;

public class InventoryEntry {
    private BaseItem item;
    private int quantity;
    
    public InventoryEntry(BaseItem item, int quantity){
        this.item=item;
        this.quantity=quantity;
    }  

    public BaseItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void AddQuantity(int amount){
        quantity+=amount;
    }

    public void TakeQuantity(int amount){
        quantity-=amount;
    }
}
