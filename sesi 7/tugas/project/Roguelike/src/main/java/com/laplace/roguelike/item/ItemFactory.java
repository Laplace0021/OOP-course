package com.laplace.roguelike.item;

import com.laplace.roguelike.enums.ItemRarity;

public class ItemFactory {

/////////////
//  SWORD  //
/////////////

    public static Sword woodSword() {
        return new Sword(
                "Wood Sword",
                "Old wooden sword",
                ItemRarity.COMMON,
                10,
                20
        );
    }

    public static Sword ironSword() {
        return new Sword(
                "Iron Sword",
                "Basic iron sword",
                ItemRarity.COMMON,
                25,
                50
        );
    }

    public static Sword steelSword() {
        return new Sword(
                "Steel Sword",
                "Sharp steel blade",
                ItemRarity.UNCOMMON,
                40,
                100
        );
    }

    public static Sword silverSword() {
        return new Sword(
                "Silver Sword",
                "Knight-class weapon",
                ItemRarity.UNCOMMON,
                60,
                180
        );
    }

    public static Sword goldSword() {
        return new Sword(
                "Gold Sword",
                "Luxurious heavy sword",
                ItemRarity.RARE,
                90,
                300
        );
    }

    public static Sword diamondSword() {
        return new Sword(
                "Diamond Sword",
                "Extremely durable blade",
                ItemRarity.SUPERRARE,
                125,
                500
        );
    }

    public static Sword heroSword() {
        return new Sword(
                "Hero Sword",
                "Legendary sword of heroes",
                ItemRarity.SPECIAL,
                250,
                1000
        );
    }

/////////////
//  ARMOR  //
/////////////

    public static Armor leatherArmor() {
        return new Armor(
                "Leather Armor",
                "Light protection",
                ItemRarity.COMMON,
                10,
                20
        );
    }

    public static Armor ironArmor() {
        return new Armor(
                "Iron Armor",
                "Basic iron armor",
                ItemRarity.COMMON,
                25,
                50
        );
    }

    public static Armor steelArmor() {
        return new Armor(
                "Steel Armor",
                "Heavy steel armor",
                ItemRarity.UNCOMMON,
                40,
                100
        );
    }

    public static Armor silverArmor() {
        return new Armor(
                "Silver Armor",
                "Knight-grade armor",
                ItemRarity.UNCOMMON,
                60,
                180
        );
    }

    public static Armor goldArmor() {
        return new Armor(
                "Gold Armor",
                "Expensive royal armor",
                ItemRarity.RARE,
                90,
                300
        );
    }

    public static Armor diamondArmor() {
        return new Armor(
                "Diamond Armor",
                "Highly durable armor",
                ItemRarity.SUPERRARE,
                125,
                500
        );
    }

    public static Armor heroArmor() {
        return new Armor(
                "Hero Armor",
                "Legendary armor",
                ItemRarity.SPECIAL,
                250,
                1000
        );
    }

//////////////////////
//  Healing Potion  //
//////////////////////

    public static HealingPotion smallPotion() {
        return new HealingPotion(
                "Small Potion",
                "Recover small HP",
                ItemRarity.COMMON,
                10,
                1000
        );
    }

    public static HealingPotion mediumPotion() {
        return new HealingPotion(
                "Medium Potion",
                "Recover medium HP",
                ItemRarity.UNCOMMON,
                20,
                3000
        );
    }

    public static HealingPotion bigPotion() {
        return new HealingPotion(
                "Big Potion",
                "Recover large HP",
                ItemRarity.RARE,
                35,
                7000
        );
    }

    public static HealingPotion greaterPotion() {
        return new HealingPotion(
                "Greater Potion",
                "Recover massive HP",
                ItemRarity.SUPERRARE,
                50,
                15000
        );
    }

//////////////////
//  EXP BOTTLE  //
//////////////////

    public static ExpBottle smallExpBottle() {
        return new ExpBottle(
                "Small EXP Bottle",
                "Gain small EXP",
                ItemRarity.COMMON,
                10,
                10
        );
    }

    public static ExpBottle mediumExpBottle() {
        return new ExpBottle(
                "Medium EXP Bottle",
                "Gain medium EXP",
                ItemRarity.UNCOMMON,
                20,
                45
        );
    }

    public static ExpBottle largeExpBottle() {
        return new ExpBottle(
                "Large EXP Bottle",
                "Gain huge EXP",
                ItemRarity.RARE,
                35,
                120
        );
    }
/////////////
//  BOOKS  //
/////////////
//HP//

    public static Book militiaRationGuide() {
        return new Book(
                "Militia's Rations Guide",
                "Improve body endurance",
                ItemRarity.UNCOMMON,
                25,
                1000,
                0,
                0
        );
    }

    public static Book fieldMedicNotes() {
        return new Book(
                "Field Medic's Notes",
                "Increase survival capability",
                ItemRarity.RARE,
                40,
                2500,
                0,
                0
        );
    }

    public static Book ironConditioningManual() {
        return new Book(
                "Iron Conditioning Manual",
                "Elite endurance training",
                ItemRarity.SUPERRARE,
                70,
                5000,
                0,
                0
        );
    }

//ATK//

    public static Book swordmanBasic() {
        return new Book(
                "Swordman's Basic",
                "Basic attack training",
                ItemRarity.UNCOMMON,
                25,
                0,
                50,
                0
        );
    }

    public static Book mercenaryStrikingArts() {
        return new Book(
                "Mercenary's Striking Arts",
                "Advanced combat techniques",
                ItemRarity.RARE,
                40,
                0,
                120,
                0
        );
    }

    public static Book masterDuelistTreatise() {
        return new Book(
                "Master Duelist Treatise",
                "Master-level swordsmanship",
                ItemRarity.SUPERRARE,
                70,
                0,
                250,
                0
        );
    }

//DEF//

    public static Book footmanGuardingStance() {
        return new Book(
                "Footman's Guarding Stance",
                "Basic defensive stance",
                ItemRarity.UNCOMMON,
                25,
                0,
                0,
                30
        );
    }

    public static Book knightArmorHandling() {
        return new Book(
                "Knight's Armor Handling",
                "Proper armor handling",
                ItemRarity.RARE,
                40,
                0,
                0,
                80
        );
    }

    public static Book siegeDefenderAlmanac() {
        return new Book(
                "Siege Defender's Almanac",
                "Legendary defensive knowledge",
                ItemRarity.SUPERRARE,
                70,
                0,
                0,
                180
        );
    }

//ALL STATS//

    public static Book sergeantDrillBook() {
        return new Book(
                "Sergeant Drill Book",
                "Balanced military training",
                ItemRarity.RARE,
                100,
                1500,
                70,
                50
        );
    }

    public static Book generalsWarDiary() {
        return new Book(
                "General's War Diary",
                "War experience from a veteran",
                ItemRarity.SUPERRARE,
                200,
                3500,
                150,
                120
        );
    }

    public static Book herosCodex() {
        return new Book(
                "Hero's Codex",
                "Legendary hero knowledge",
                ItemRarity.SPECIAL,
                400,
                10000,
                500,
                300
        );
    }
}
