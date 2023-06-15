package com.masaki.demo;

public interface ICombat {

    // Abstract methods to player and monster class
    public int fight();
    public int calculateDamage();


    /*
        TODO check to the doubledamage
         */
    int calculateDamage(int strength);
}


