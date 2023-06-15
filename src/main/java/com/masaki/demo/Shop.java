package com.masaki.demo;

import com.masaki.demo.weapon.Axe;
import com.masaki.demo.weapon.Staff;
import com.masaki.demo.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    List<Weapon> weaponList = new ArrayList<>();
    Game game = new Game();
    Staff staff;
    Axe axe;


    public void populateShop() {
        weaponList.add(axe);
        weaponList.add(staff);
    }




}