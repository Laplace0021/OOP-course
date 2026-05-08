package com.laplace.roguelike.entity;

public abstract class Entity {
    protected String name;
    protected int level;
    protected int maxHp;
    protected int hp;
    protected int atk;
    protected int def;


    public Entity(String name,int level,int maxHp, int atk, int def){
        this.name = name;
        this.level=level;
        this.maxHp=maxHp;
        this.hp=maxHp;
        this.atk=atk;
        this.def=def;
    }

    public boolean isAlive(){
        return this.hp>0;
    }

    public String getName(){
        return name;
    }
    
    public void levelUp(){
        level +=1;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp>maxHp) {
            this.hp = maxHp;
        } else if (hp<0) {
            this.hp =0;
        } else{
            this.hp=hp;
        }
    }

    public void heal(int amount){
        this.hp +=amount;
        if (hp>maxHp) {
            this.hp=maxHp;
        }
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void addMaxHp(int amount) {
        this.maxHp += amount;
    }

    public int getAtk() {
        return atk;
    }

    public void addAtk(int amount) {
        this.atk += amount;
    }

    public int getDef() {
        return def;
    }

    public void addDef(int amount) {
        this.def += amount;
    }

    
    public void takeDamage(int damage,boolean ignoreDefense) {
        int finalDamage;

        if(ignoreDefense){
            finalDamage = damage;
        } else {
            finalDamage = damage *1000/(1000+getDef());
        }

        if(finalDamage < 0){
            finalDamage = 0;
        }
        if (finalDamage > 0) {
            this.setHp(getHp() - finalDamage);
            System.out.println(this.getName()+ " Take " + finalDamage + " DMG!");
        } else {
            System.out.println("Blocked! The armor absorbed all damage.");
        }
        
    }
    public void attackTarget(Entity target) {
        System.out.println(getName()+" cause "+ getAtk()+ " DMG!");
        target.takeDamage(getAtk(),false);
    }
    public abstract void displayStatus();

    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

}
