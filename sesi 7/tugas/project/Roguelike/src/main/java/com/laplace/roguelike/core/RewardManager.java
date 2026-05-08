package com.laplace.roguelike.core;

import com.laplace.roguelike.entity.Player;
import com.laplace.roguelike.item.BaseItem;
import com.laplace.roguelike.item.ItemPool;
import com.laplace.roguelike.utils.RandomUtils;

public class RewardManager {
    public static void giveEnemyRoomReward(Player player, int floor){
        int gold = RandomUtils.randomInt(20, 40);
        double multiplier = getMultiplier(floor);
        gold =(int)(gold*multiplier);
        int exp = RandomUtils.randomInt(100, 300);
        
        player.addGold(gold);
        player.addExp(exp);
        BaseItem reward = switch (floor) {
            case 1 -> ItemPool.randomItem(floor, 60, 35, 15, 5, 1);
            case 2 -> ItemPool.randomItem(floor, 50, 40, 17, 7, 2);
            case 3 -> ItemPool.randomItem(floor, 40, 45, 20, 10, 4);
            default -> null;
        };
        if(reward!=null)player.getInventory().addItem(reward, 1, player);
        System.out.println(player.getName() + " get "+gold+" gold & "+exp+" exp");
        }
    
    public static void giveTreasureRoomReward(Player player,int floor,boolean mimic){
        int gold = RandomUtils.randomInt(70, 130);
        double multiplier =getMultiplier(floor);
        gold =(int)(gold*multiplier);
        if (mimic) {
            gold*=2;
            int exp = RandomUtils.randomInt(100,300);
            player.addExp(exp);
            player.addGold(gold);
            System.out.println(player.getName() + " get "+gold+" gold & "+exp+" exp");
            BaseItem reward = switch (floor) {
            case 1 -> ItemPool.randomItem(floor, 45, 30, 15, 7, 3);
            case 2 -> ItemPool.randomItem(floor, 40, 28, 17, 10, 5);
            case 3 -> ItemPool.randomItem(floor, 35, 25, 20, 13, 7);
            default -> null;
        };
        if(reward!=null)player.getInventory().addItem(reward, 1, player);
            
        }
        BaseItem reward = switch (floor) {
            case 1 -> ItemPool.randomItem(floor, 45, 30, 15, 7, 3);
            case 2 -> ItemPool.randomItem(floor, 40, 28, 17, 10, 5);
            case 3 -> ItemPool.randomItem(floor, 35, 25, 20, 13, 7);
            default -> null;
        };  
        player.addGold(gold);
        if(reward!=null)player.getInventory().addItem(reward, 1, player);
        System.out.println(player.getName() + " get "+gold+" gold");
    }

    private static double getMultiplier(int floor) {
        switch (floor) {
            case 1: return 1.0;
            case 2: return 1.2;
            case 3: return 1.5;
            default: return 1.0;
        }
    }
}
