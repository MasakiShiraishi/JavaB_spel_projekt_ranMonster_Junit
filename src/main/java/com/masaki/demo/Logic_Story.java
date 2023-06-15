package com.masaki.demo;


import java.util.Scanner;

public class Logic_Story {
static Scanner scanner = new Scanner(System.in);
    // method to simulate clearing out the console
    public static void clearConsole3(){
        for (int i = 0; i < 3; i++)
            System.out.println();
    }

    public static void clearConsole15(){
        for (int i = 0; i < 15; i++)
            System.out.println();
    }
    // method to print a separation with length n
    public static void printSeparation(int n){
        for (int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }
    //method to print a heading
    public static void printHeading(String title){
        printSeparation(30);
        System.out.println(title);
        printSeparation(30);
    }
    public static void printHeading2(String title){
        printSeparation(50);
        System.out.println(title);
        printSeparation(50);
    }

    // method to stop the game until user enters anything
    public static void anythingToContinue(){
        System.out.println("\nEnter anything to continue...");
        scanner.next();
    }
    public static void printIntro(){
        clearConsole15();
        printSeparation(20);
        System.out.println("Intro");
        printSeparation(20);
        System.out.println("You were living peacefully with your family in Stockholm.");
        System.out.println("One day, you got up and noticed that your family was gone.");
        System.out.println("You checked inside the house, but you could not find anything.");
        System.out.println("You rushed out of the house but couldn't see anyone. You then knew that almost everyone had disappeared.");
        System.out.println("A few days later, news by Aftonbladet caught your eye that most citizens had been kidnapped by a monster. ");
        printSeparation(40);
        System.out.println("You decided to defeat the monster and rescue everyone.");
        anythingToContinue();
    }

}
