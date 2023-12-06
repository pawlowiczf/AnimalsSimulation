package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import static agh.ics.oop.OptionsParser.directionParser;

import agh.ics.oop.model.util.PositionAlreadyOccupiedException;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    public void doesDirectionParserWork() {
        // given
        String[] argumentsA = {"f", "X", "r", "r", "l"};
        String[] argumentsB = {"gwiazda", "l", "r", "b"};
        String[] argumentsC = {"r", "r", "l", "f", "meteor"};
        String[] argumentsD = {"r", "r", "l", "f"};


        // when
        List <MoveDirection> properDirectionsD = new ArrayList<>( Arrays.asList(MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.FORWARD) );

        IllegalArgumentException exceptionA = assertThrows(IllegalArgumentException.class, () -> OptionsParser.directionParser(argumentsA) );
        IllegalArgumentException exceptionB = assertThrows(IllegalArgumentException.class, () -> OptionsParser.directionParser(argumentsB) );
        IllegalArgumentException exceptionC = assertThrows(IllegalArgumentException.class, () -> OptionsParser.directionParser(argumentsC) );

        // then

        assertEquals("X is not legal move specification",       exceptionA.getMessage() );
        assertEquals("gwiazda is not legal move specification", exceptionB.getMessage() );
        assertEquals("meteor is not legal move specification",  exceptionC.getMessage() );

        assertEquals(properDirectionsD, directionParser(argumentsD));


    }


}