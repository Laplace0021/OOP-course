package com.laplace.roguelike.utils;

import java.util.List;
import java.util.Random;
public class RandomUtils {
    private static final Random random = new Random();

    //random integer between min and max
    public static int randomInt(int min, int max){
        return random.nextInt(max-min+1)+min;
    }
    public static int randomInt(int size){
        return random.nextInt(size);
    }

    //random Double between min and max
    public static double randomDouble(double min, double max){
        return random.nextDouble(max-min)+min;
    }
    //Chance system
    public static boolean chance(int percentage){
        return random.nextInt() * 100 <percentage;
    }
    //random Element from array
    public static<T> T randomFromArray(T [] array){
        if (array == null || array.length ==0) {
            throw new IllegalArgumentException("Array is empty");
        }
        return array[random.nextInt(array.length)];
    }
    //Random Element from List
    public static <T> T randomFromList(List<T> list){
        if (list==null || list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        return list.get(random.nextInt(list.size()));
    }
}
