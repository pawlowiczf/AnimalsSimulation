package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

public class OptionsParser
{
    public static MoveDirection[] DirectionParser(String[] args)
    {
        // 1) Finding the length of array with proper inputs (i.e "f", "b", "r", "l")
        int length = 0;
        for(String x: args) {
            if (x.equals("f") || x.equals("b") || x.equals("r") || x.equals("l") ) length++;
        }

        // 2) Creating proper array containing ENUM MoveDirection constants
        int index = 0;
        MoveDirection[] Directions = new MoveDirection[length];

        for (String x : args) {
            //
            MoveDirection result = switch (x) {
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "r" -> MoveDirection.RIGHT;
                case "l" -> MoveDirection.LEFT;
                default  -> null;
            };

            if ( result != null ) {
                Directions[index] = result;
                index++;
            }
        }

        //
        return Directions;
    }
}


