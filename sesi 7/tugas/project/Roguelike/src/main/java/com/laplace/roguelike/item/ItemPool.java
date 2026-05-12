package com.laplace.roguelike.item;

import java.util.ArrayList;

import com.laplace.roguelike.utils.RandomUtils;

public class ItemPool {
    private static final ArrayList<BaseItem> CommonItems = new ArrayList<>();
    private static final ArrayList<BaseItem> UncommonItems = new ArrayList<>();
    private static final ArrayList<BaseItem> RareItems = new ArrayList<>();
    private static final ArrayList<BaseItem> SuperRareItems = new ArrayList<>();
    private static final ArrayList<BaseItem> SpecialItems = new ArrayList<>();

    static{
        //Common
        CommonItems.add(ItemFactory.woodSword());
        CommonItems.add(ItemFactory.ironSword());
        CommonItems.add(ItemFactory.leatherArmor());
        CommonItems.add(ItemFactory.ironArmor());
        CommonItems.add(ItemFactory.smallPotion());
        CommonItems.add(ItemFactory.smallExpBottle());

        //Uncommon
        UncommonItems.add(ItemFactory.steelSword());
        UncommonItems.add(ItemFactory.silverSword());
        UncommonItems.add(ItemFactory.steelArmor());
        UncommonItems.add(ItemFactory.silverArmor());
        UncommonItems.add(ItemFactory.mediumPotion());
        UncommonItems.add(ItemFactory.mediumExpBottle());
        UncommonItems.add(ItemFactory.militiaRationGuide());
        UncommonItems.add(ItemFactory.swordmanBasic());
        UncommonItems.add(ItemFactory.footmanGuardingStance());

        //Rare
        RareItems.add(ItemFactory.goldSword());
        RareItems.add(ItemFactory.goldArmor());
        RareItems.add(ItemFactory.bigPotion());
        RareItems.add(ItemFactory.largeExpBottle());
        RareItems.add(ItemFactory.fieldMedicNotes());
        RareItems.add(ItemFactory.mercenaryStrikingArts());
        RareItems.add(ItemFactory.knightArmorHandling());
        RareItems.add(ItemFactory.sergeantDrillBook());

        //SuperRare
        SuperRareItems.add(ItemFactory.diamondSword());
        SuperRareItems.add(ItemFactory.diamondArmor());
        SuperRareItems.add(ItemFactory.greaterPotion());
        SuperRareItems.add(ItemFactory.ironConditioningManual());
        SuperRareItems.add(ItemFactory.masterDuelistTreatise());
        SuperRareItems.add(ItemFactory.siegeDefenderAlmanac());
        SuperRareItems.add(ItemFactory.generalsWarDiary());

        //Special
        SpecialItems.add(ItemFactory.heroSword());
        SpecialItems.add(ItemFactory.herosCodex());
        SpecialItems.add(ItemFactory.heroArmor());
    }

    public static BaseItem randomItem(int floor, int CRate,int UCRate, int RRate, int SRRate, int SRate){
        int sum =CRate+UCRate+RRate+SRRate+SRate;
        int roll = RandomUtils.randomInt(1,sum );
        int C = CRate;
        int UC = C+UCRate;
        int R = UC+RRate;
        int SR = R+SRRate;
        int S = SR+SRate;

        if (roll<=C) return RandomUtils.randomFromList(CommonItems);
        else if (roll<=UC) return RandomUtils.randomFromList(UncommonItems); 
        else if (roll<=R) return RandomUtils.randomFromList(RareItems); 
        else if (roll<=SR) return RandomUtils.randomFromList(SuperRareItems); 
        else if (roll<=S) return RandomUtils.randomFromList(SpecialItems);
        return null; 
            
        
    }
}
