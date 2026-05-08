# Roguelike Dungeon Adventure

A terminal-based Roguelike RPG game built using Java and Object-Oriented Programming principles.

Players explore a dangerous dungeon filled with enemies, treasures, merchants, campfires, training grounds, and powerful bosses while collecting equipment and growing stronger floor by floor.

---

# Features

## Dungeon Exploration
- 3 Floors with increasing difficulty
- Randomized room choices
- Section-based progression system
- Unique guaranteed rooms per floor

---

## Combat System
- Turn-based battle system
- Enemy scaling based on:
  - Floor
  - Clearance progress
  - Player level
- Boss battle on the final floor

---

# Room Types

## Enemy Room
Fight enemies and earn:
- Gold
- EXP
- Random items

## Treasure Room
Obtain:
- Large gold rewards
- Rare items
- Possible Mimic encounter

## Shop Room
- Buy items
- Sell inventory items

## Campfire Room
Recover HP safely.

## Training Room
Gain bonus EXP through training.

## Boss Room
The final challenge of the dungeon.

---

# Inventory System

Fully interactive inventory system.

Players can:
- View inventory
- Use consumables
- Equip weapons and armor
- Read item descriptions

---

# Item System

## Consumables
- Healing Potions
- EXP Bottles

## Equipment

### Swords
Increase attack power.

### Armor
Increase defense.

## Books
Passive items that automatically apply effects when obtained.

Duplicate non-stackable items are automatically converted into gold.

---

# Equipment System

Supports:
- Weapon equipping
- Armor equipping
- Automatic stat replacement

Old equipment bonuses are removed before new bonuses are applied.

---

# Scaling System

## Gold Scaling
Rewards increase per floor.

| Floor | Multiplier |
|---|---|
| 1 | 1.0x |
| 2 | 1.2x |
| 3 | 1.5x |

---

# Random Room System

Each section presents 3 random room choices.

Some sections contain guaranteed special rooms.

Examples:
- Floor 2 Section 4 always contains a Shop Room
- Floor 3 Section 8 is always the Boss Room

---

# Technologies Used

- Java
- Maven
- Object-Oriented Programming

---

# OOP Concepts Used

- Inheritance
- Polymorphism
- Abstraction
- Interfaces
- Encapsulation

---

# Project Structure

```text
src/main/java/com/laplace/roguelike

├── core
├── entity
├── room
├── item
├── inventory
├── interfaces
├── utils
└── enums
```

---

# How To Run

## Compile

```bash
mvn clean compile
```

## Run

```bash
mvn exec:java
```

---

# Future Improvements

- Save & Load System
- Status Effects
- More Enemy Types
- Skill System
- Procedural Events
- Multiple Bosses
- Better UI
- Equipment rarity colors
- Sound & graphical version

---

# Final Notes

This project was created as a learning project to practice:
- Java programming
- OOP architecture
- Game system design
- Terminal game development

The focus of the project is building scalable game systems rather than graphical presentation.

