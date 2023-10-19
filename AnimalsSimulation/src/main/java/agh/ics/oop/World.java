package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import static agh.ics.oop.OptionsParser.DirectionParser;


public class World {
    //
    public static void run(MoveDirection[] args)
    {
        //
        System.out.println("Start");
        for(MoveDirection x : args) {
            //
            switch(x) {
                case FORWARD  -> System.out.println( "Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println( "Zwierzak idzie do tyłu"  );
                case RIGHT    -> System.out.println( "Zwierzak skręca w prawo" );
                case LEFT     -> System.out.println( "Zwierzak skręca w lewo"  );
            }
        }
        System.out.println("Stop");
    }
    public static void main(String[] args)
    {
        //
        System.out.println("System wystartował");

        MoveDirection[] MoveDirection = DirectionParser(args);
        run(MoveDirection);

        System.out.println("System zakończył działanie");
    }
}
