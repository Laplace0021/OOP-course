package com.laplace.roguelike.room;

import java.util.ArrayList;

import com.laplace.roguelike.Inventory.InventoryEntry;
import com.laplace.roguelike.entity.Player;
import com.laplace.roguelike.item.BaseItem;
import com.laplace.roguelike.item.ItemPool;
import com.laplace.roguelike.utils.InputUtils;

public class ShopRoom extends Room{
    private ArrayList<BaseItem> shopItems;
    public ShopRoom(){
        super("Shop");
        shopItems = new ArrayList<>();
    }

    private void generateShopItems(int floor){
        shopItems.clear();
        switch (floor) {
            case 1 -> {
                shopItems.add(ItemPool.randomItem(floor, 50, 35, 10, 4, 1));
                shopItems.add(ItemPool.randomItem(floor, 50, 35, 10, 4, 1));
                shopItems.add(ItemPool.randomItem(floor, 45, 35, 15, 4, 1));
                shopItems.add(ItemPool.randomItem(floor, 40, 40, 15, 4, 1));
                shopItems.add(ItemPool.randomItem(floor, 35, 40, 20, 4, 1));
            }

            case 2 -> {
                shopItems.add(ItemPool.randomItem(floor, 40, 35, 15, 7, 3));
                shopItems.add(ItemPool.randomItem(floor, 40, 35, 15, 7, 3));
                shopItems.add(ItemPool.randomItem(floor, 35, 35, 20, 7, 3));
                shopItems.add(ItemPool.randomItem(floor, 30, 40, 20, 7, 3));
                shopItems.add(ItemPool.randomItem(floor, 25, 40, 25, 7, 3));
            }

            case 3 -> {
                shopItems.add(ItemPool.randomItem(floor, 30, 35, 20, 10, 5));
                shopItems.add(ItemPool.randomItem(floor, 30, 35, 20, 10, 5));
                shopItems.add(ItemPool.randomItem(floor, 25, 35, 25, 10, 5));
                shopItems.add(ItemPool.randomItem(floor, 20, 35, 30, 10, 5));
                shopItems.add(ItemPool.randomItem(floor, 15, 35, 35, 10, 5));
            }
        }
    }

    private void showShopItem(){
        System.out.println("=== SHOP ===");
        for (int i = 0; i < shopItems.size(); i++) {
            BaseItem item = shopItems.get(i);
            System.out.println((i+1)+". "+ item.getName()+" | "+ item.getRarity()+" | "+item.getPrice()+" Gold");
        }
        System.out.println("0. Back");
    }

    private void buyItem(Player player, int index){
        if (index<0 || index>=shopItems.size()) {
            System.out.println("Invalid choice");
            return;
        }

        BaseItem item = shopItems.get(index);

        if (!item.isStackable() && player.getInventory().hasItem(item.getName())) {
            System.out.println("You already own this item.");
            return;
        }
        if (player.getGold() < item.getPrice()) {

            System.out.println("You don't have enough gold.");
            return;
        }
        player.addGold(-item.getPrice());

        player.getInventory().addItem(item, 1, player);

        shopItems.remove(index);

        System.out.println(
                "Successfully bought "
                + item.getName()
        );
    }
    

    private void sellMenu(Player player) {

        if (player.getInventory().size() == 0) {

            System.out.println("Inventory is empty.");
            return;
        }

        player.getInventory().showInventory();

        System.out.println("0. Back");

        int choice = InputUtils.getInt("Choose item to sell >> ");

        if (choice == 0) {
            return;
        }

        InventoryEntry entry = player.getInventory().getEntry(choice - 1);

        if (entry == null) {

            System.out.println("Invalid choice.");
            return;
        }

        BaseItem item = entry.getItem();

        int sellPrice = item.getPrice() / 2;

        player.addGold(sellPrice);

        player.getInventory().reduceItem(item);

        System.out.println("Sold "+ item.getName()+ " for "+ sellPrice+ " gold");
    }

    @Override
    public void enter(Player player,int clearance ,int floor) {
        System.out.println("You found a merchant");
        generateShopItems(floor);
        while (true) {
            System.out.println("Welcome, traveler. Looking to purchase, or perhaps turn some loot into gold?");
            System.out.println("Gold: "+player.getGold()); 
            System.out.println("Choose: ");
            System.out.println("1. Buy");
            System.out.println("2. Sell");
            System.out.println("3. Leave");
            int choice = InputUtils.getInt(">> ");
            switch (choice) {
                case 1:
                    while (true) {
                     System.out.println();
                     showShopItem();
                     int buyChoice = InputUtils.getInt("Choose Item >> ");
                     if (buyChoice==0) {
                        break;
                     }   

                     buyItem(player, buyChoice-1);
                    }
                    
                case 2:
                    sellMenu(player);
                case 3:
                    System.out.println("You leave the merchant");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
