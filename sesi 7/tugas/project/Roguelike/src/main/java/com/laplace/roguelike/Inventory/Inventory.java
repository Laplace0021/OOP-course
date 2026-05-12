package com.laplace.roguelike.Inventory;

import java.util.ArrayList;

import com.laplace.roguelike.entity.Player;
import com.laplace.roguelike.item.BaseItem;
import com.laplace.roguelike.item.Book;

public class Inventory {
   private ArrayList<InventoryEntry> items;

   public Inventory(){
    items = new ArrayList<>();
   }

   public void addItem(BaseItem item,int amount, Player player){
    
    
    //Item stackable
    if(item.isStackable()){
        for (InventoryEntry entry : items) {
            if (entry.getItem().getName().equals(item.getName())) {
                entry.AddQuantity(amount);
                System.out.println(item.getName()+ " quantity increased by "+amount);
                return;
            }
        }
        items.add(new InventoryEntry(item, amount));
        System.out.println(item.getName()+" added to inventory");
        return;
    } 
    //Item notStackable
    for (InventoryEntry entry : items) {
       //Duplicate Item
        if (entry.getItem().getName().equals(item.getName())) {
            
            player.addGold(item.getPrice());
            System.out.println(item.getName()+" is already on inventory, you got "+item.getPrice()+" gold instead");
            return;
        }  
    }
    
    items.add(new InventoryEntry(item, amount));
    System.out.println(item.getName()+" added to inventory");
    //Item is Book
    if (item instanceof Book book) {
        book.apply(player);
    }
    
   }

   public void removeItem(BaseItem item){
    items.removeIf(entry ->
        entry.getItem().getName().equals(item.getName())
    );
   }

   public void reduceItem(BaseItem item){
    for (InventoryEntry entry : items) {
        if (entry.getItem().getName().equals(item.getName())) {
            entry.TakeQuantity(1);

            if (entry.getQuantity()<=0) {
                items.remove(entry);
            }
        return;
        }
    }
   }
   public void showInventory(){
    if(items.isEmpty()){
        System.out.println("Inventory is empty!");
        return;
    }

    System.out.println("=== INVENTORY ===");
    for (int i = 0; i < items.size(); i++) {
        InventoryEntry entry = items.get(i);
        System.out.println(
            (i+1)+". "+ entry.getItem().getName()+" x"+ entry.getQuantity()
        );
    }
   }
   public int size(){
    return items.size();
   }

   public InventoryEntry getEntry(int index){
    if (index< 0 || index>=items.size()) {
        return null;
    }
    return items.get(index);
   }

   public boolean hasItem(String itemName){

    for (InventoryEntry entry : items) {

        if(entry.getItem().getName().equalsIgnoreCase(itemName)){
            return true;
        }
    }

    return false;
    }
    
}
