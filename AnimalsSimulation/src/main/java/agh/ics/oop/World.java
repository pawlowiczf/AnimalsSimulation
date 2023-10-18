package agh.ics.oop;

import java.sql.SQLOutput;

public class World {
    //
    public static void run(String[] args) {
        //
        System.out.println("Start");
        for(String x : args) {
            //
            switch(x) {
                case "f" -> System.out.println("Zwierzak idzie do przodu");
                case "b" -> System.out.println("Zwierzak idzie do tyłu");
                case "r" -> System.out.println("Zwierzak skręca w prawo");
                case "l" -> System.out.println("Zwierzak skręca w lewo");
            }
        }
        System.out.println("Stop");
    }
    public static void main(String[] args) {
        //
        System.out.println("System wystartował");
        run(args);
        System.out.println("System zakończył działanie");
    }
}
