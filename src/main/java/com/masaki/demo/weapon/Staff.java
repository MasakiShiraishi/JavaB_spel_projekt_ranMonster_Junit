package com.masaki.demo.weapon;

import java.util.Random;

public class Staff extends Weapon implements IWeaponFunctionality{

        int damage = 3;
        float price = 20;

    boolean canDoubleIntelligence;

    // Needs debugging
    public boolean willDoubleIntellect() {
        Random random = new Random();

        if ((random.nextInt(6) + 1) >= 3) {
            canDoubleIntelligence = true;
        } else {
            canDoubleIntelligence = false;
        }

        return canDoubleIntelligence;
    }

    @Override
    public int dealDamage() {

        return getDamage() + 2;
    }

    @Override
    public String toString() {
        return "Staff";
    }
}
