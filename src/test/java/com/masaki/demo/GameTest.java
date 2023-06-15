package com.masaki.demo;

import com.masaki.demo.MonasterPack.Wolf;
import org.junit.Test;

import static com.masaki.demo.Col.*;
import static org.junit.Assert.*;

public class GameTest  {

    Wolf wolf = new Wolf("Wolf", 40, 8,100,25) {
        @Override
        public int calculateDamage() {
            return 0;
        }
    };
    Player player = new Player(20,9,1,0,0) {
        @Override
        public int calculateDamage() {
            return 0;
        }
    };

    @Test
    public void calculatePlayerDamageTest(){
        assertEquals(7,6+((1/4)+1));
        // damage = strength + level / 4
        // players strength = 7
    }

    @Test
    public void playerWinLose() {
        System.out.println("You're fighting a: wolf");
        player.fight();
        wolf.setHP(wolf.getHP() - player.calculateDamage(player.getStrength()));
        System.out.println("Wolf HP: " + GREEN_UNDERLINED + wolf.getHP() + RESET);
        wolf.fight();
        player.setHP(player.getHP() - wolf.calculateDamage(8));
        // public int calculateDamage() {damage = strength + 1;
        System.out.println("Player HP: " +BLUE_UNDERLINED + player.getHP()+ RESET);
        if (player.getHP()<= 0) {
            System.out.println("You lost" + "\nGame over");
        }

        assertTrue("Player will be game over",
                player.getHP()<= 0);
        assertEquals(9,wolf.calculateDamage(8));
        assertNotEquals(40,wolf.getHP()
                - player.calculateDamage(player.getStrength()));
    }



}
