package com.masaki.demo;


import com.masaki.demo.weapon.Weapon;

import java.util.Random;
import java.util.Scanner;

import static com.masaki.demo.Col.*;

public abstract class Player implements ICombat {
    private int maxHP;
    private int damage;
    private int intelligence = 5;
    public int HP;
    public int strength = 7;
    public int level;
    public int agility = 10;
    public int EXP;
    public int SEK;
    public int MB;    //monster beating
   Weapon weapon = null;


    public Player(int maxHP, int HP, int level, int EXP, int SEK) {
        this.maxHP = maxHP;
        this.HP = HP;
        this.level = level;
        this.EXP = EXP;
        this.SEK = SEK;

    }

    public int getMB() {
        return MB;
    }

    public void increaseMBBeaten(){
        MB++;
    }

    public void setMB(int MB) {
        this.MB = MB;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }



    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getHP() {
        return HP;
    }
    public void setHP(int HP) {

        this.HP = HP;
        isHealthAboveLimit();
    }
    public void setStrength(int strength) {

        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setEXP(int EXP) {
        this.EXP = EXP;
        checkIfLevelUp();
    }

    public int getEXP() {
        return EXP;
    }

    public void setLevel(int level) {
        this.level = level;
         }

    public int getLevel() {
        return level;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getAgility() {
        return agility;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getSEK() {
        return SEK;
    }

    public void setSEK(int SEK) {
        this.SEK = SEK;
    }

    @Override
    public String toString() {
        return "Player{" +
                "maxHP=" + maxHP + ", " +
                BLUE_UNDERLINED + "HP=" + HP + RESET + ", " +
                RED_BOLD + "strength=" + strength + RESET +
                ", level=" + level +
                ", \nEXP=" + EXP +
                ", SEK=" + SEK +
                ", intelligence=" + intelligence +
                ", agility=" + agility +
                ", \nweapon is " + getWeapon() + " ATK +" +getDamage() + " points" +
                '}';
    }


    public void levelUp() {
        setLevel(getLevel() + 1);
        setMaxHP(getMaxHP() + 10);
        setHP(getMaxHP());
        setStrength(getStrength() + 2);
        setIntelligence(getIntelligence() + 2);
        setAgility(getAgility() + 2);
    }

    public void isHealthAboveLimit() {
        if (getHP() > getMaxHP()) {
            setHP(getMaxHP());
        }
    }

    @Override
    public int fight() {
        Random doubleDam = new Random();
        final int player_doubleDam =  doubleDam.nextInt(1,15);
        if ( 1 >= doubleDam.nextInt(1,15) ) {
            System.out.println("This time is " + RED_BRIGHT + "critical hit!!" + RESET);
        System.out.println("You attacked the monster and gave" + " " +
                YELLOW_BOLD_BRIGHT + calculateDamage(getStrength() * 2) + RESET +" " + "damage!");

        }else{
            System.out.println("You attacked the monster and gave" + " " +
                YELLOW_BOLD_BRIGHT +calculateDamage(getStrength()) + RESET +" " + "damage!");}
        return calculateDamage();
    }

    @Override
    public int calculateDamage(int strength) {
       if(getWeapon() != null ){
            damage = (strength + level / 4) + weapon.getDamage();
       }else{
            damage = strength + level / 4;
       }
            return damage ;

    }
    public  void calculateExperience(int EXP)  {

                 int difference = 100 - getEXP();
                 EXP -= difference;

                 int remainder = EXP % 100;

                 System.out.printf("difference: %s, \n remainder: %s, \n cheatInputExp: %s \n", difference, remainder, EXP); // DEBUGGING

                 if ( EXP >= 100) {

                     System.out.println("\n ENTERING IF-For loop \n");
                     for (int i = EXP; i >= 100; i -= 100) {
                         setLevel(getLevel() + 1);
                         System.out.println(i);
                     }
                 }

                 if (getEXP() + (remainder + difference) >= 100) {
                     System.out.println("\n IF");

                     setEXP(getEXP() + difference);
                     setEXP(getEXP() + remainder);

                 } else {
                     System.out.println("ELSE");
                     setEXP(getEXP() + (remainder + difference));
                 }
             }

    public void checkIfLevelUp() {
        if (getEXP() == 100) {
            System.out.println("LEVEL UP");
            levelUp();
            setEXP(0);
        }
    }


    static Scanner scanner = new Scanner(System.in);
    public static void playerSetup(){
        String playerName = " ";
        System.out.println("Please enter your name?");
        playerName = scanner.next();
        System.out.println("Hello " + playerName + ", let's start your adventure!");
    }


}

