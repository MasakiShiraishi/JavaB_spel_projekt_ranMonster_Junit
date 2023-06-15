package com.masaki.demo;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public void writeToFile(Player player) {

        try {
            FileWriter fileWriter = new FileWriter("filename.txt");

            fileWriter.write("\nPlayers Level Log");
            fileWriter.write("\nPlayers Current Level " +
                    player.getLevel());
            fileWriter.write("\n--------------------------\n");
            fileWriter.write("\nPlayers Weapon Log");
            if(player.getWeapon() != null) {
                fileWriter.write("\nPlayers weapon " + " " +
                        player.getWeapon());
            } else{
                fileWriter.write("\nYou have no weapon!");
            }
            fileWriter.write("\n--------------------------\n");
            fileWriter.write("\nYou had beat " + player.getMB() + " monsters.");

            if (player.getHP() <= 0) {
                fileWriter.write("You lost" + "\nGame over");
                System.exit(0);
            }
            fileWriter.write("\n--------------------------\n");
            fileWriter.write("Thank you for playing this game!" + "\nHave a nice day.");
            fileWriter.close();

        } catch (IOException error) {
            System.out.println("An error occurred");
            error.printStackTrace();
        }


    }

    }

