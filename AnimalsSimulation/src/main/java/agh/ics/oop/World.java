package agh.ics.oop;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static agh.ics.oop.OptionsParser.directionParser;


public class World {
    //
    public static void run(List <MoveDirection> directions)
    {
        //
        System.out.println("Start");

        for(MoveDirection direction : directions) {
            //
            switch(direction) {
                case FORWARD  -> System.out.println( "Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println( "Zwierzak idzie do tyłu"  );
                case RIGHT    -> System.out.println( "Zwierzak skręca w prawo" );
                case LEFT     -> System.out.println( "Zwierzak skręca w lewo"  );
            }
        } //end 'for each' loop
        System.out.println("Stop");
    }

    public static void main(String[] args)
    {
        //
        System.out.println("System wystartował");
        List<MoveDirection> directions;
        List<Vector2d> positions;

        directions = directionParser(args);
        positions = new ArrayList<>();
        positions.add( new Vector2d(2, 2 ) );
        positions.add( new Vector2d(3, 2 ) );

        Simulation simulation = new Simulation(positions, directions);
        simulation.run();

//        List <MoveDirection> directions = directionParser(args);
//        run(directions);

        System.out.println("System zakończył działanie");


    }

}

