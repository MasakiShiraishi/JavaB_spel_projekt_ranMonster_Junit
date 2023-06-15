package com.masaki.demo;


import static com.masaki.demo.Player.playerSetup;

public class Main {
    public static void main(String[] args) {


        Game game = new Game();
        Shop shop = new Shop();
        shop.populateShop();

        Logic_Story.printIntro();
        playerSetup();

        game.startGaming();






    }


}
