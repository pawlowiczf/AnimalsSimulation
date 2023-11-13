package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import static agh.ics.oop.OptionsParser.directionParser;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    public void doesDirectionParserWork() {
        // given
        String[] argumentsA = {"f", "X", "K", "r", "l"};
        String[] argumentsB = {};
        String[] argumentsC = {"0", "NIE MAM", "HEJKA", "FLP", "GRY"};

        // when
        List <MoveDirection> directionsA       = directionParser(argumentsA);
        List<MoveDirection> properDirectionsA = new ArrayList<>( Arrays.asList(MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.LEFT) );

        List <MoveDirection> directionsB       = directionParser(argumentsB);
        List <MoveDirection> properDirectionsB = new ArrayList<>();

        List <MoveDirection> directionsC       = directionParser(argumentsC);
        List <MoveDirection> properDirectionsC = new ArrayList<>();

        // then
        assertEquals(directionsA, properDirectionsA);
        assertEquals(directionsB, properDirectionsB);
        assertEquals(directionsC, properDirectionsC);
    }

    @Test
    public void doesDirectionParserWorkWithMixedInputs() {
        // given
        String[] argumentsA = {"Tu byłby", "raj", "f", "b", "gdybyś", "l"};
        String[] argumentsB = {"Znasz li", "f", "ten kraj", "l", "r", "gdzie"};
        String[] argumentsC = {"Szukam", "północnej", "fg?", "gwiazdy", "l", "l", "l", "l", "r" };

        // when
        List <MoveDirection> directionsA       = directionParser(argumentsA);
        ArrayList <MoveDirection> properDirectionsA = new ArrayList<>( Arrays.asList(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT) );

        List <MoveDirection> directionsB       = directionParser(argumentsB);
        List <MoveDirection> properDirectionsB = new ArrayList<>( Arrays.asList(MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT) );

        List <MoveDirection> directionsC       = directionParser(argumentsC);
        List <MoveDirection> properDirectionsC = new ArrayList<>( Arrays.asList(MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.RIGHT) );

        // then
        assertEquals(directionsA, properDirectionsA);
        assertEquals(directionsB, properDirectionsB);
        assertEquals(directionsC, properDirectionsC);
    }

}