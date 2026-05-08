package com.laplace.roguelike.core;

import java.util.ArrayList;
import java.util.Collections;

import com.laplace.roguelike.room.*;
import com.laplace.roguelike.utils.RandomUtils;

public class RoomGenerator {
    public static Room[] generateChoices(int floor, int section){
        ArrayList<Room> rooms =new ArrayList<>();

        if (floor==1) {
            if(section==6){
                rooms.add(new TreasureRoom());  //unique
                rooms.add(randomRoom());
                rooms.add(randomRoom());
            } else {
                rooms.add(randomRoom());
                rooms.add(randomRoom());
                rooms.add(randomRoom());
            }
        } else if(floor==2){
            if (section==4) {
                rooms.add(new ShopRoom());    //unique
                rooms.add(randomRoom());
                rooms.add(randomRoom());
            } else if (section==7) {
                rooms.add(new TreasureRoom());    //unique
                rooms.add(randomRoom());
                rooms.add(randomRoom());
            } else{
                rooms.add(randomRoom());
                rooms.add(randomRoom());
                rooms.add(randomRoom());
            }
        } else if(floor==3){
            if (section==4) {
                rooms.add(new ShopRoom());    //unique
                rooms.add(randomRoom());
                rooms.add(randomRoom());
            } else if(section==7){
                rooms.add(new CampfireRoom());    //unique
                rooms.add(randomRoom());
                rooms.add(randomRoom());
            } else if(section==8){
                rooms.clear();
                rooms.add(new BossRoom());      //unique

                return rooms.toArray(new Room[0]);    
            }else{
                rooms.add(randomRoom());
                rooms.add(randomRoom());
                rooms.add(randomRoom());
            }
        }
        Collections.shuffle(rooms);

        return rooms.toArray(new Room[0]);
    }
    private static Room randomRoom(){
        int roll = RandomUtils.randomInt(1,100);
        if (roll<=60) return new EnemyRoom();
        else if(roll<=80) return new TrainingRoom();
        else if(roll<=90) return new CampfireRoom();
        else if(roll<=95) return new ShopRoom();
        else return new TreasureRoom();
    }
}
