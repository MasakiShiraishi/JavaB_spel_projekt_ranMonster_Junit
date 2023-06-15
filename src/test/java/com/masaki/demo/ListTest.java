package com.masaki.demo;

import com.masaki.demo.weapon.Axe;
import com.masaki.demo.weapon.Staff;
import com.masaki.demo.weapon.Weapon;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListTest {
    List<Weapon> weaponList = new ArrayList<>();
    Staff staff;
    Axe axe;

    @Test
    public void testAdd(){
        weaponList.add(axe);
        weaponList.add(staff);
        assertEquals("Adding 2 weapon to list",
                2, weaponList.size());
    }
    @Test
    public void testRemove(){
        weaponList.add(axe);
        weaponList.add(staff);
        weaponList.remove(axe);
        assertEquals("Adding 1 weapon to list",
                1, weaponList.size());
    }
    @Test
    public void removeAll(){
        weaponList.add(axe);
        weaponList.add(staff);
        weaponList.removeAll(weaponList);
        assertEquals("Removing all weapon to list",
                0, weaponList.size());
    }

}
