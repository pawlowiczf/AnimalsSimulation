package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionsParser
{

    private static MoveDirection parser(String argument) {
        return switch (argument) {
            case "f" -> MoveDirection.FORWARD;
            case "b" -> MoveDirection.BACKWARD;
            case "r" -> MoveDirection.RIGHT;
            case "l" -> MoveDirection.LEFT;
            default  -> throw new IllegalArgumentException(argument + " is not legal move specification");
        };
    }

    public static List <MoveDirection> directionParser(String[] arguments) {
        //
        return Stream.of(arguments)
                .map( OptionsParser :: parser )
                .collect( Collectors.toList() );
    } // end method directionParser()

    // Test OptionsParser nadal oczywiście przechodzi :)
}


