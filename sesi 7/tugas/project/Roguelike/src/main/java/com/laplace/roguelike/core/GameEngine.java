
package com.laplace.roguelike.core;

import com.laplace.roguelike.room.Room;
import com.laplace.roguelike.Interface.Equipable;
import com.laplace.roguelike.Interface.Usable;
import com.laplace.roguelike.Inventory.InventoryEntry;
import com.laplace.roguelike.entity.Player;
import com.laplace.roguelike.item.BaseItem;
import com.laplace.roguelike.utils.InputUtils;

public class GameEngine {
    public static void startGame(){
        System.out.println("=== Dungeon ===");
        System.out.println();

        String name = InputUtils.getString("Enter your name: ");
        Player player = new Player(name);
        int clearance =0;
        for (int floor = 1; floor <= 3; floor++) {
            int maxSection = switch (floor) {
                case 1 -> 6;
                case 2 -> 7;
                case 3 -> 8;
                default -> 0;
            };

            System.out.println();
            System.out.println("===== FLOOR "+floor+" =====");

            for (int section = 1; section<= maxSection;section++) {
                while (true) {
                    System.out.println();
                    System.out.println("Section "+section);
                    System.out.println();
                    System.out.println(
                            "1. Explore"
                    );
                    System.out.println(
                            "2. Inventory"
                    );
                    System.out.println(
                            "3. Stats"
                    );

                    int menuChoice = InputUtils.getInt(">> ");

                    if (menuChoice==1) {
                        Room[] choices = RoomGenerator.generateChoices(floor, section);
                        for (int i = 0; i < choices.length; i++) {
                            System.out.println((i+1)+". "+choices[i].getRoomName());
                        }
                        int choice;
                        while (true) {
                            choice =InputUtils.getInt(">> ");
                            if (choice>=1 && choice<=choices.length) {
                                break;
                            }
                            System.out.println("Invalid choice!");
                        }
                        Room selected = choices[choice-1];
                        selected.enter(player, clearance, floor);
                        clearance++;

                        if (!player.isAlive()) {
                            System.out.println();
                            System.out.println(player.getName()+ " died in the dungeon...");
                            return;
                        }
                        break;
                    }
                    else if (menuChoice == 2) {
                        while (true) {
                            System.out.println();
                            player.getInventory().showInventory();

                            System.out.println();
                            System.out.println("0. Back");

                            int inventoryChoice =InputUtils.getInt("Choose item >> ");

                            if(inventoryChoice == 0){
                                break;
                            }
                            InventoryEntry entry =player.getInventory().getEntry(inventoryChoice - 1);

                            if(entry == null){

                                System.out.println("Invalid choice!");
                                continue;
                            }

                            BaseItem item = entry.getItem();

                            System.out.println();
                            System.out.println("=== ITEM INFO ===");

                            System.out.println(item.getName());

                            System.out.println(item.getDescription());

                            // =====================
                            // USABLE
                            // =====================

                            if(item instanceof Usable usable){

                                System.out.println();
                                System.out.println("1. Use");
                                System.out.println("0. Back");

                                int useChoice =InputUtils.getInt( ">> ");

                                if(useChoice == 1){
                                    usable.use(player);
                                    player.getInventory().reduceItem(item);
                                }
                            }

                            // =====================
                            // EQUIPABLE
                            // =====================

                            else if(item instanceof Equipable equipable){
                                System.out.println();
                                System.out.println("1. Equip");
                                System.out.println("0. Back");

                                int equipChoice =InputUtils.getInt(">> ");
                                if(equipChoice == 1){
                                    equipable.equip(player);
                                }
                            }

                            // =====================
                            // OTHER ITEMS
                            // =====================

                            else {

                                System.out.println();
                                System.out.println("Press anything to continue...");
                                InputUtils.getString(">> ");
                            }
                        }
                    }
                    else if (menuChoice==3) {
                        System.out.println();
                        System.out.println("===== STATS =====");
                        player.getStats();
                    }
                    else {
                        System.out.println("Invalid Choice!");
                    }
                }
            }
            
        }
    }
}
