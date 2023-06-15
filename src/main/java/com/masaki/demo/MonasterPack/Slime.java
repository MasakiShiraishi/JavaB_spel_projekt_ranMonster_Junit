package com.masaki.demo.MonasterPack;


import static com.masaki.demo.Col.RED_BOLD;
import static com.masaki.demo.Col.RESET;

public class Slime extends Monster  {

   int damage;
   int HP = 10;
   int strength = 5;
   String monsterName = "Slime";
   int EXP = 20;
   int SEK = 20;

   public Slime(String monsterName, int HP, int Strength, int EXP, int SEK) {
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
        System.out.println(getMonsterName() + " attacked the player and gave" + " " +
                RED_BOLD + calculateDamage(3) + RESET  + " " + "damage!");
        return calculateDamage();
    }

    @Override
    public int calculateDamage() {
        damage = strength + 1;
        return damage;
    }

    @Override
    public String toString() {
        return "\nSlime{" +
                "HP=" + HP +
                ", strength=" + strength +
                ", EXP=" + EXP +
                '}';
    }

    public void playerMissFlee(){
        System.out.println("You couldn't run away\n"
                + this.monsterName + " attacked the player and gave" + " " +
                RED_BOLD + calculateDamage(3) + RESET + " " + "damage!");

    }



}
