package com.masaki.demo.MonasterPack;

import static com.masaki.demo.Col.*;

public class Pig extends Monster{

    int damage;
    int HP = 35;
    int strength = 5;
    String monsterName = "Pig";
    int EXP = 50;
    int SEK = 50;
    public Pig(String monsterName, int HP, int Strength, int EXP, int SEK) {
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
        System.out.println("Monster attacked the player and gave" + " " +
                RED_BOLD + calculateDamage(5) + RESET +" " + "damage!");

        return calculateDamage();
    }

    @Override
    public int calculateDamage() {
        return damage = strength + 1;
    }

    @Override
    public String toString() {
        return "\nPig{" +
                PURPLE_UNDERLINED + "HP=" + HP + RESET + ", " +
                RED_UNDERLINED + "strength=" + strength + RESET +
                ", EXP=" + EXP +
                '}';
    }

    public void playerMissFlee(){
        System.out.println("You couldn't run away"
                + "\nMonster attacked the player and gave" + " "
                + RED_BOLD +calculateDamage(5) + RESET + " " + "damage!");

    }



}
          /*
             damage = strength + 1;
        return damage;
                */
