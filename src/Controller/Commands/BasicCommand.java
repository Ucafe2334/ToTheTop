package Controller.Commands;

import Model.Abstract.Item;

import java.util.ArrayList;
import java.util.Scanner;

public interface BasicCommand {
    ArrayList<String> array = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    static int inputint(String Question) {
        System.out.println(Question +" : ");
        return sc.nextInt();
    }

    static int inputint() {
        System.out.println("Select One : ");
        return sc.nextInt();
    }

    static String inputString(String Question) {
        System.out.println(Question+" : ");
        return sc.next();
    }

    static String inputString() {
        System.out.println("Answer : ");
        return sc.next();
    }

    static void printMenu() {
        int i = 0;
        System.out.println("Menu");
        for (String data : array) {
            i++;
            System.out.println(i + ") " + data);
        }
        System.out.println("0) Back");
        array.clear();
    }

    static void printMenu(ArrayList<Item> item) {
        int i = 0;
        System.out.println("Menu");
        for (Item data : item) {
            i++;
            System.out.println(i + ") " + data);
        }
        System.out.println("0) Back");
        array.clear();
    }

    static void pause() {
        System.out.println("Press Any Key To Continue...");
        new java.util.Scanner(System.in).nextLine();
    }

    static void pauseE() {
        new java.util.Scanner(System.in).nextLine();
    }

    static void tittle(String name){
        System.out.println("========================================");
        System.out.println(name);
        System.out.println("========================================");
    }

    static void subtittle(String name){
        System.out.println("-----------------------------------------");
        System.out.println(name);
        System.out.println("-----------------------------------------");
    }

    static void nextTurn(){
        System.out.println("-----------------NEXT TURN---------------");
    }
}
