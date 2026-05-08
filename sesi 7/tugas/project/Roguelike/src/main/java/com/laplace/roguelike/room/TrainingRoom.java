package com.laplace.roguelike.room;

import com.laplace.roguelike.entity.Player;
import com.laplace.roguelike.utils.InputUtils;
import com.laplace.roguelike.utils.RandomUtils;

public class TrainingRoom extends Room {
    public TrainingRoom(){
        super("Training Room");
    }

    @Override
    public void enter(Player player,int clearance ,int floor) {
        System.out.println("You find a quiet place. This is a good time to train.");
        System.out.println("Choose Training:");
        System.out.println("1. ATK ");
        System.out.println("2. DEF ");
        System.out.println("3. HP ");
        int choice = InputUtils.getInt(">> ");
        double multiplier = RandomUtils.randomDouble(0.05, 0.1); 
        switch (choice) {
            case 1 -> {
                int gain = (int)(player.getAtk()*multiplier);
                player.addAtk(gain);
                System.out.println(player.getName()+" ATK increased by "+gain);
            }
            case 2 -> {
                int gain = (int)(player.getDef()*multiplier);
                player.addDef(gain);
                System.out.println(player.getName()+" DEF increased by "+gain);
            }
            case 3 -> {
                int gain =(int)(player.getMaxHp()*multiplier);
                player.addMaxHp(gain);
                System.out.println(player.getName()+ "Max HP increased by "+gain);
            }
        }
        int exp =RandomUtils.randomInt(100, 200);
        player.addExp(exp);
        System.out.println(player.getName()+" Gained "+exp+ " EXP");
    }
}
