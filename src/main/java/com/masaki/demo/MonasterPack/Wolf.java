package com.masaki.demo.MonasterPack;

import static com.masaki.demo.Col.*;

public  class Wolf extends Monster{

     int damage;
     int HP = 40;
     int strength = 8;
     String monsterName = "Wolf";
     int EXP = 100;
     int SEK = 100;

    public Wolf(String monsterName, int HP, int Strength, int EXP, int SEK) {
        super(monsterName, HP, Strength, EXP,SEK);

    }


    @Override
    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    @Override
    public String getMonsterName() {
        return monsterName;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public void setHP(int HP) {
        this.HP = HP;
    }

    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public void setEXP(int EXP) {
        this.EXP = EXP;
    }

    @Override
    public int getEXP() {
        return EXP;
    }

    @Override
    public int getSEK() {
        return SEK;
    }

    @Override
    public void setSEK(int SEK) {
        this.SEK = SEK;
    }

    @Override
    public int fight() {
        System.out.println("Wolf attacked the player and gave" + " " +
                RED_BOLD + calculateDamage(8) + RESET +" " + "damage!");

        return calculateDamage();
    }


    @Override
    public int calculateDamage() {
        damage = strength + 1;
        return damage;
    }

    @Override
    public String toString() {
        return "\nWolf{" +
                GREEN_UNDERLINED + "HP=" + HP + RESET + ", " +
                RED_UNDERLINED + "strength=" + strength + RESET +
                ", EXP=" + EXP +
                '}';
    }

    public void playerMissFlee(){
        System.out.println("You couldn't run away"
                + "\nMonster attacked the player and gave" + " " +
                RED_BOLD + calculateDamage(8) + RESET + " " + "damage!");

    }

}
