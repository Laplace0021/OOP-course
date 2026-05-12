package com.laplace.roguelike.entity;

import com.laplace.roguelike.utils.RandomUtils;

public class EnemySpawner {

    private static double getMultiplier(int clearance, int playerLevel) {
        return 1.0 + (0.12 * clearance) + (0.02 * (playerLevel-1));
    }

    private static Enemy createEnemy(String name, int baseHp, int baseAtk, int baseDef, int clearance, int playerLevel) {
        double multiplier = getMultiplier(clearance, playerLevel);
    
        int finalHp  = (int)(baseHp  * multiplier * 1.05);
        int finalAtk = (int)(baseAtk * multiplier);
        int finalDef = (int)(baseDef * (1 + clearance * 0.01));
        int finalLevel = clearance + (playerLevel / 2);

        return new Enemy(name, finalLevel, finalHp, finalAtk, finalDef);
    }
   public static Enemy goblinSpawner(int clearance, int playerLevel) {
        return createEnemy("Goblin", 8000, 1000, 500, clearance, playerLevel);
    }

    public static Enemy slimeSpawner(int clearance, int playerLevel) {
        return createEnemy("Slime", 3000, 200, 50, clearance, playerLevel);
    }

    public static Enemy skeletonSpawner(int clearance, int playerLevel) {
        return createEnemy("Skeleton", 6000, 400, 200, clearance, playerLevel);
    }

    public static Enemy spiderSpawner(int clearance, int playerLevel) {
        return createEnemy("Spider", 4000, 600, 800, clearance, playerLevel);
    }

    public static Enemy zombieSpawner(int clearance, int playerLevel) {
        return createEnemy("Zombie", 7000, 1200, 900, clearance, playerLevel);
    }

public static Enemy randomEnemy(int clearance, int playerLevel, int floor) {
    
    int roll = RandomUtils.randomInt(floor-1, floor+1);

    switch (roll) {
        case 0 -> {return slimeSpawner(clearance, playerLevel);}
        case 1 -> {return skeletonSpawner(clearance, playerLevel);}
        case 2 -> {return spiderSpawner(clearance, playerLevel);}
        case 3 -> {return goblinSpawner(clearance, playerLevel);}
        case 4 -> {return zombieSpawner(clearance, playerLevel);}
        default -> {return null;}
    }
}

}

