package com.masaki.demo.MonasterPack;

import com.masaki.demo.ICombat;

public  abstract class Monster implements ICombat {

   public int damage;
   public int HP;
   public int strength;
   public String monsterName;
   public int EXP;
   public int SEK;

    public Monster(String monsterName, int HP, int strength, int EXP, int SEK) {
        super();
    }


    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getHP() {
        return HP;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setEXP(int EXP) {
        this.EXP = EXP;
    }

    public int getEXP() {
        return EXP;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public int getSEK() {
        return SEK;
    }

    public void setSEK(int SEK) {
        this.SEK = SEK;
    }



    @Override
    public int fight() {

        return calculateDamage();
    }

    @Override
    public  int calculateDamage(int strength) {//baseDamage + (styrka * 2 / 4 + 1).
        damage = strength + 1;
        return damage;
    }


}



