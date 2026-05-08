package com.laplace.roguelike.room;

import com.laplace.roguelike.entity.Player;

public abstract class Room {
    protected String RoomName;

    public Room(String RoomName){
        this.RoomName= RoomName;
    }

    public String getRoomName(){
        return RoomName;
    }

    public abstract void enter(Player player,int clearance, int floor);
    
}
