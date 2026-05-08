package com.laplace.roguelike.room;

import com.laplace.roguelike.core.BattleManager;
import com.laplace.roguelike.core.RewardManager;
import com.laplace.roguelike.entity.Enemy;
import com.laplace.roguelike.entity.Mimic;
import com.laplace.roguelike.entity.Player;
import com.laplace.roguelike.utils.RandomUtils;

public class TreasureRoom extends Room{
    public TreasureRoom(){
        super("Treasure Room");
    }

    @Override
    public void enter(Player player, int clearance,int floor) {
        System.out.println("You find a room full of treasure");
        boolean isMimic = RandomUtils.chance(10);
        if (isMimic) {
            Enemy Mimic = new Mimic(player.getLevel(), 20000, 2000, 150);
            boolean win = BattleManager.startBattle(player, Mimic);
            if (!win) {
                System.out.println(player.getName()+" managed to escape from the mimic");
                return;
            }
            System.out.println("You defeated the Mimic! The treasure is yours!");
            RewardManager.giveTreasureRoomReward(player, floor, true);
        } else{
            System.out.println("You opened the chest safely.");
            RewardManager.giveTreasureRoomReward(player, floor, false);
        }
        RewardManager.giveTreasureRoomReward(player, floor, false);
    }
}
