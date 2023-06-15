package com.masaki.demo;


import com.masaki.demo.MonasterPack.Pig;
import com.masaki.demo.MonasterPack.Slime;
import com.masaki.demo.MonasterPack.Wolf;
import com.masaki.demo.weapon.Axe;
import com.masaki.demo.weapon.Staff;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import static com.masaki.demo.Col.*;
import static com.masaki.demo.Logic_Story.clearConsole3;
import static com.masaki.demo.Logic_Story.printSeparation;

public class Game {
    Player player = new Player(100, 100, 1, 0, 0) {
        @Override
        public int calculateDamage() {
            return 0;
        }
    };
    Slime slime = new Slime("Slime", 10, 3, 20, 20) {
        @Override
        public int calculateDamage() {
            return 0;
        }
    };
    Pig pig = new Pig("Pig", 35, 5, 50, 50) {
        @Override
        public int calculateDamage() {
            return 0;
        }
    };
    Wolf wolf = new Wolf("Wolf", 40, 8, 100, 100) {
        @Override
        public int calculateDamage() {
            return 0;
        }
    };

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    WriteFile wf = new WriteFile();

    public void startGaming() {
        boolean isFighting = true;

        do {
            try {
                clearConsole3();
                System.out.println("You are at Stockholm city. \nWhich way do you want to go?" +
                        "\n 1 -  North " +
                        "\n 2 -  East" +
                        "\n 3 -  West" +
                        "\n 4 -  South (Shop)" +
                        "\n 5 -  check players state" +
                        "\n 6 -  Exit Game");

                switch (scanner.nextInt()) {
                    case 1 -> monsterEncounter();

                    case 2 -> monsterEncounter2();

                    case 3 -> {
                        System.out.println("You're fighting a:" + BLACK + " wolf" + RESET);
                        playerCombatActChoice();
                        playerCombatActWolf();
                    }
                    case 4 -> {
                        System.out.println("You can buy weapons" + RED + "if you have SEK! " + RESET
                                + "\nWhat do you want to buy ?" + "\nyou have" + " " + RED_UNDERLINED +
                                player.getSEK() + " " + "SEK" + RESET
                                + "\n 1 - buy weapons "
                                + "\n 2 - leave");
                        shopChoose();
                    }
                    case 5 -> {
                        System.out.println(player.toString());
                    }
                    case 6 -> {
                        isFighting = false;
                    }
                    default -> {
                        printSeparation(35);
                        System.out.println(YELLOW_UNDERLINED + "Please input correct numbers" + "\n" + RESET);
                    }
                }
            } catch (InputMismatchException e) {
                printSeparation(35);
                System.out.println("Invalid User Input." + YELLOW_UNDERLINED
                        + "\nPlease enter a number from 1 to 6." + RESET);
                scanner.next();
                printSeparation(35);
            }
        } while (isFighting);
        wf.writeToFile(player);
        System.out.println("Thank you for playing this game.");
        System.exit(0);
    }

    public void shopChoose() {
        switch (scanner.next()) {
            case "1" -> {
                shopWeapon();
            }
            case "2" -> {
                startGaming();
            }
            default -> {
                System.out.println(YELLOW_UNDERLINED + "Please input correct numbers" + "\n" + RESET
                        + "\n 1 - buy weapons "
                        + "\n 2 - leave");
                shopChoose();
            }
        }
    }

    public void shopWeapon() {

        if (player.getSEK() >= 50) {
            System.out.println("Do you want to buy Axe or Staff?");
            System.out.println("1 - " + BLUE_BRIGHT + "Axe" + RESET +
                    "\n2 - " + CYAN_BRIGHT + "Staff" + RESET + "\n3 - Nothing");

            switch (scanner.next()) {
                case "1" -> {
                    System.out.println("You get a Axe.");
                    player.setSEK(player.getSEK() - 50);
                    player.setWeapon(new Axe());
                }

                case "2" -> {
                    System.out.println("You get a Staff.");
                    player.setSEK(player.getSEK() - 20);
                    player.setWeapon(new Staff());

                }
                case "3" -> {
                    System.out.println("You don't buy anything.");
                }
                default -> {
                    System.out.println(YELLOW_UNDERLINED + "Please input correct numbers" + "\n" + RESET);
                    shopChoose();
                }
            }
        } else if (player.getSEK() >= 20) {
            System.out.println("Do you want to buy Staff." + "\n1 - " + CYAN_BRIGHT + "Staff" + RESET + "\n2 - No");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("You get a Staff.");
                player.setSEK(player.getSEK() - 20);
                player.setWeapon(new Axe());

            } else if (choice == 2) {
                startGaming();
            }
        } else {
            System.out.println("You have no enough.");
        }

    }

    public void monsterEncounter() {
        int monster_gen = random.nextInt(0, 3);
        if (monster_gen == 0) {
            System.out.println("You're fighting a:" + BLUE + "slime" + RESET);
            playerCombatActChoice();
            playerCombatActSlime();
        } else if (monster_gen == 1) {
            System.out.println("You're fighting a:" + PURPLE + "pig" + RESET);
            playerCombatActChoice();
            playerCombatActPig();
        } else {
            System.out.println("You're fighting a:" + BLACK + " wolf" + RESET);
            playerCombatActChoice();
            playerCombatActWolf();
        }
    }

    public void monsterEncounter2() {
        int monster_gen = random.nextInt(1, 3);
        if (monster_gen == 1) {
            System.out.println("You're fighting a:" + PURPLE + "pig" + RESET);
            playerCombatActChoice();
            playerCombatActPig();
        } else {
            System.out.println("You're fighting a: " + BLACK + " wolf" + RESET);
            playerCombatActChoice();
            playerCombatActWolf();
        }
    }

    public void playerCombatActChoice() {
        clearConsole3();
        printSeparation(30);
        System.out.println(YELLOW_BOLD + "Enter a number between 1 and 3" + RESET +
                WHITE_BOLD_BRIGHT + "\n 1 - fighting" +
                "\n 2 - flee" + "\n 3 - get status" + RESET);
        printSeparation(15);
    }

    public void playerCombatActSlime() {
        switch (scanner.next()) {
            case "1" -> {
                fightingSlime();
                playerWinLose();
                player.checkIfLevelUp();
                playerCombatActChoice();
                playerCombatActSlime();
            }
            case "2" -> {
                playerFleeSlime();
            }
            case "3" -> {
                System.out.println(player.toString() + "\n" + slime.toString());
                playerCombatActChoice();
                playerCombatActSlime();
            }
            default -> {
                System.out.println("choice a number from 1 to 3");
                playerCombatActChoice();
                playerCombatActSlime();
            }
        }
    }

    public void fightingSlime() {
        player.fight();
        slime.setHP(slime.getHP() - player.calculateDamage(player.getStrength()));
        System.out.println("Slime HP: " + slime.getHP());
        if (slime.getHP() <= 0) {
            System.out.println("You won." + "\nPlayer HP: " + BLUE_UNDERLINED + player.getHP() + RESET);
        } else {
            playerDidDodgeSlime();
        }
    }

    public void playerDidDodgeSlime() { // players agility is 10
        if (player.getAgility() > random.nextInt(1, 100)) {
            System.out.println("You have succeeded to avoid attacked" + CYAN_BOLD_BRIGHT + "\nThis time no damaged." + RESET);

        } else {
            slime.fight();
            player.setHP(player.getHP() - slime.calculateDamage(3));
            System.out.println("Player HP: " + BLUE_UNDERLINED + player.getHP() + RESET);
        }
    }

    public void playerFleeSlime() {
        if (15 >= random.nextInt(1, 101) || 85 <= random.nextInt(1, 101)) {
            System.out.println("Succeeded in escaping");
            clearConsole3();
            startGaming();
        } else {
            slime.playerMissFlee();
            player.setHP(player.getHP() - slime.calculateDamage(3));
            System.out.println("Player HP: " + BLUE_UNDERLINED + player.getHP() + RESET);
            playerWinLose();
            playerCombatActChoice();
            playerCombatActSlime();
        }
    }

    public void playerCombatActPig() {
        switch (scanner.next()) {
            case "1" -> {
                fightingPig();
                playerWinLose();
                player.checkIfLevelUp();
                playerCombatActChoice();
                playerCombatActPig();
            }
            case "2" -> {
                playerFleePig();
            }
            case "3" -> {
                System.out.println(player.toString() + "\n" + pig.toString());
                playerCombatActChoice();
                playerCombatActPig();
            }
            default -> {
                System.out.println("choice a number from 1 to 3");
                playerCombatActChoice();
                playerCombatActPig();
            }
        }
    }

    public void fightingPig() {
        player.fight();
        pig.setHP(pig.getHP() - player.calculateDamage(player.getStrength()));
        System.out.println("Pig HP: " + PURPLE_UNDERLINED + pig.getHP() + RESET);
        if (pig.getHP() <= 0) {
            System.out.println("You won." + "\nPlayer HP: " + BLUE_UNDERLINED + player.getHP() + RESET);
        } else {
            playerDidDodgePig();
        }
    }

    public void playerDidDodgePig() {// players agility is 10
        if (player.getAgility() > random.nextInt(1, 150)) {
            System.out.println("You have succeeded to avoid attacked" + CYAN_BOLD_BRIGHT + "\nThis time no damaged." + RESET);

        } else {
            pig.fight();
            player.setHP(player.getHP() - pig.calculateDamage(5));
            System.out.println("Player HP: " + BLUE_UNDERLINED + player.getHP() + RESET);
        }
    }

    public void playerFleePig() {
        if (10 >= random.nextInt(1, 101) || 85 <= random.nextInt(1, 101)) {
            System.out.println("Succeeded in escaping");
            clearConsole3();
            startGaming();
        } else {
            pig.playerMissFlee();
            player.setHP(player.getHP() - pig.calculateDamage(5));
            System.out.println("Player HP: " + BLUE_UNDERLINED + player.getHP() + RESET);
            playerWinLose();
            playerCombatActChoice();
            playerCombatActPig();
        }
    }


    public void playerCombatActWolf() {
        switch (scanner.next()) {
            case "1" -> {
                fightingWolf();
                playerWinLose();
                player.checkIfLevelUp();
                playerCombatActChoice();
                playerCombatActWolf();
            }
            case "2" -> {
                playerFleeWolf();

            }
            case "3" -> {
                System.out.println(player.toString() + "\n" + wolf.toString());
                playerCombatActChoice();
                playerCombatActWolf();
            }
            default -> {
                System.out.println("choice a number from 1 to 3");
                playerCombatActChoice();
                playerCombatActWolf();
            }
        }
    }

    public void fightingWolf() {
        player.fight();
        wolf.setHP(wolf.getHP() - player.calculateDamage(player.getStrength()));
        System.out.println("Wolf HP: " + GREEN_UNDERLINED + wolf.getHP() + RESET);
        if (wolf.getHP() <= 0) {
            System.out.println("You won." + "\nPlayer HP: " + BLUE_UNDERLINED + player.getHP() + RESET);
        } else {
            playerDidDodgeWolf();
        }
    }

    public void playerDidDodgeWolf() {// players agility is 10
        if (player.getAgility() > random.nextInt(1, 200)) {
            System.out.println("You have succeeded to avoid attacked" + CYAN_BOLD_BRIGHT + "\nThis time no damaged." + RESET);

        } else {
            wolf.fight();
            player.setHP(player.getHP() - wolf.calculateDamage(8));
            System.out.println("Player HP: " + BLUE_UNDERLINED + player.getHP() + RESET);
        }
    }

    public void playerFleeWolf() {
        if (10 >= random.nextInt(1, 101) || 90 <= random.nextInt(1, 101)) {
            System.out.println("Succeeded in escaping");
            clearConsole3();
            startGaming();
        } else {
            wolf.playerMissFlee();
            player.setHP(player.getHP() - wolf.calculateDamage(8));
            System.out.println("Player HP: " + BLUE_UNDERLINED + player.getHP() + RESET);
            playerWinLose();
            playerCombatActChoice();
            playerCombatActWolf();
        }
    }

    public void playerWinLose() {
        if (slime.getHP() <= 0) {
            System.out.println("You beat a monster and got" +
                    " " + slime.getEXP() + " " + "XP, " + slime.getSEK() + " " + "SEK");
            player.calculateExperience(slime.getEXP());
            player.setSEK(player.getSEK() + slime.getSEK());
            slime.setHP(10);
            player.increaseMBBeaten();//player.setMB(player.getMB() + 1);
            startGaming();

        } else if (pig.getHP() <= 0) {
            System.out.println("You beat a monster and got" +
                    " " + pig.getEXP() + " " + "XP, " + pig.getSEK() + " " + "SEK");
            player.calculateExperience(pig.getEXP());
            player.setSEK(player.getSEK() + pig.getSEK());
            pig.setHP(35);
            player.increaseMBBeaten(); //player.setMB(player.getMB() + 1);
            startGaming();

        } else if (wolf.getHP() <= 0) {
            System.out.println("You beat a monster and got" +
                    " " + wolf.getEXP() + " " + "XP, " + wolf.getSEK() + " " + "SEK");
            player.calculateExperience(wolf.getEXP());
            player.setSEK(player.getSEK() + wolf.getSEK());
            wolf.setHP(40);
            player.increaseMBBeaten();//player.setMB(player.getMB() + 1);
            startGaming();

        }
        if (player.getHP() <= 0) {
            System.out.println("You lost" + "\nGame over");
            System.exit(0);
        }


    }

}










