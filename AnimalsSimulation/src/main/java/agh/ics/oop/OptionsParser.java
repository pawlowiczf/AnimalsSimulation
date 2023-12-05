package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import java.util.ArrayList;
import java.util.List;

public class OptionsParser
{
    public static List <MoveDirection> directionParser(String[] arguments) {
        //
        List <MoveDirection> directions = new ArrayList<>();

        for (String arg: arguments) {
            //
            MoveDirection result = switch (arg) {
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "r" -> MoveDirection.RIGHT;
                case "l" -> MoveDirection.LEFT;
                default  -> throw new IllegalArgumentException(arg + " is not legal move specification");
            };

            directions.add(result);
        } // end 'for each' loop

        return directions;
    }
}


