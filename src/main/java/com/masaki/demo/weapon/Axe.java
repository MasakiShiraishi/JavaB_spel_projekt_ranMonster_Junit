package com.masaki.demo.weapon;

public class Axe extends Weapon implements  IWeaponFunctionality{

    int damage = 7;
    float price = 50;


    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override

    public int dealDamage() {

        return getDamage() ; // TODO - change formaula
    }

    @Override
    public String toString() {
        return "Axe" ;
    }
}
