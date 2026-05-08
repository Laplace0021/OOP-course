package com.laplace.roguelike.room;

import com.laplace.roguelike.core.BattleManager;
import com.laplace.roguelike.entity.Boss;
import com.laplace.roguelike.entity.Player;

public class BossRoom extends Room{
    public BossRoom(){
        super("Boss Room");
    }

    @Override
    public void enter(Player player, int clearance, int floor) {
        System.out.println("A terrifying presence fills the room...");
        System.out.println("The Boss Appears!");
        Boss boss = new Boss("Minotaur",(int)(player.getLevel()*(1.5)),100000,5000,500);
        Boolean win = BattleManager.startBattle(player, boss);
        if (win) {
            System.out.println("You defeated the boss!");
        }
        System.out.println("The dungeon has claimed another victim...");
        
    }
}
