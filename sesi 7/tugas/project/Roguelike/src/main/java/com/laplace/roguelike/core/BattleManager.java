package com.laplace.roguelike.core;

import com.laplace.roguelike.entity.*;

public class BattleManager {
    public static boolean startBattle(Player player, Enemy enemy){
        while (player.isAlive() && enemy.isAlive()) {

            System.out.println("\n"+player.getName()+"  HP: " +player.getHp());
            System.out.println("\t\t\t\t\t"+ enemy.getName()+"  HP: " +enemy.getHp());
            delay(200);
            player.attackTarget(enemy);
            delay(200);

            if (enemy.isAlive()) {
                System.out.println("\n"+player.getName()+"  HP: " +player.getHp());
                System.out.println("\t\t\t\t\t"+ enemy.getName()+"  HP: " +enemy.getHp());
                delay(200);
                enemy.attackTarget(player);
                delay(200);
            }
        }

        if(enemy.getName().equals("Mimic") && !player.isAlive()){
            System.out.println(player.getName()+" trying to escape");
            player.setHp(1);
        }

        if(enemy instanceof Boss && player.isAlive()){
            showDungeonClear(player);
        }

        return player.isAlive();
    }
    public static void delay(int ms){
        try {
        Thread.sleep(ms); // 1 second delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void flush(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private static void showDungeonClear(Player player){
        System.out.println();
        System.out.println("======================================");
        System.out.println("The dungeon falls silent...");
        System.out.println();
        System.out.println("The final blow has been struck.");
        System.out.println("Before you, the defeated boss slowly fades into darkness.");
        System.out.println();
        System.out.println("For the first time since entering this cursed place,");
        System.out.println("you can finally breathe without fear.");
        System.out.println();
        System.out.println("The path to the surface has opened.");
        System.out.println();
        System.out.println(player.getName() + " has conquered the dungeon.");
        System.out.println("You cleared every floor and survived every battle.");
        System.out.println();
        System.out.println("Legends will remember your name.");
        System.out.println();
        System.out.println("           ★ DUNGEON CLEARED ★");
        System.out.println("======================================");
    }
}
