package com.masaki.demo;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class PlayerTest  {

    @Test
    public void testPlayerSetUp(){
        System.out.println("Please enter your name?");
        String str1 = "Please enter your name?";
        String str2 = "May I help you?";
        assertEquals("Please enter your name?", str1);

        assertNotEquals("Please enter your name?",str2);
    }


    Player player = new Player(20,9,1,25,0) {
        @Override
        public int calculateDamage() {
            return 0;
        }
    };

        @Test
    @DisplayName("Adding 100 experience test")
    public void experience100() {

        player.calculateExperience(100);
        assertNotNull(player);
        assertEquals(25,player.getEXP());
        assertEquals(2,player.getLevel());
        assertTrue("Value was not between 0...100",
                player.getEXP() < 101 && player.getEXP() >= 0);

    }

}