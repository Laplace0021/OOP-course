package com.laplace.roguelike.room;

import com.laplace.roguelike.entity.Player;

public class CampfireRoom extends Room {
    public CampfireRoom(){
        super("Campfire");
    }

    @Override
    public void enter(Player player, int clearance,int floor) {
        System.out.println("You enter a room and found safe place to rest");

        player.heal(player.getMaxHp());
        System.out.println("you are fully healed ");
    }

}
