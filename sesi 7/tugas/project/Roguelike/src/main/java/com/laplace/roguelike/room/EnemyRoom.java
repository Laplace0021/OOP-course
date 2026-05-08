package com.laplace.roguelike.room;

import com.laplace.roguelike.core.BattleManager;
import com.laplace.roguelike.core.RewardManager;
import com.laplace.roguelike.entity.Enemy;
import com.laplace.roguelike.entity.EnemySpawner;
import com.laplace.roguelike.entity.Player;

public class EnemyRoom extends Room{
    public EnemyRoom(){
        super("Monster Room");
    }

    @Override
    public void enter(Player player, int clearance,int floor) {
        System.out.println("You enter a monster room!");

        Enemy enemy = EnemySpawner.randomEnemy(clearance, player.getLevel(), floor);

        System.out.println("Ready to fight "+enemy.getName());
        System.out.println();
        System.out.println("===== BATTLE START =====");

        boolean win = BattleManager.startBattle(player,enemy);

        if (win) {
            System.out.println("You successfully clear this room");
            RewardManager.giveEnemyRoomReward(player,floor);
        } else{
            System.out.println("You Died");
        }
    }
}
