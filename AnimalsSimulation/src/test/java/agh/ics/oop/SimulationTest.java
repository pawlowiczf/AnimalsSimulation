package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {
    //

    @Test
    public void doesInputMatchAnimalsMoves() {
        // given
        Vector2d posA = new Vector2d(2,2);
        Vector2d posB = new Vector2d(1,1);
        Vector2d posC = new Vector2d(-1, 1);

        List <Vector2d> positions = new ArrayList<>( Arrays.asList(posA, posB, posC) );

        List <MoveDirection> directions = new ArrayList<>
                (
                Arrays.asList( MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.BACKWARD)
                ) ;

        Simulation simulation = new Simulation(positions, directions);

        // when
        Vector2d newPosA = new Vector2d(2, 2);
        Vector2d newPosB = new Vector2d(0, 2);
        Vector2d newPosC = new Vector2d(-1, 1); // w tym przypadku pozycja nie powinna się zmienić - zwierzę jest poza mapą
        simulation.run();

        List <Vector2d> newPositions = new ArrayList<>( Arrays.asList( newPosA, newPosB, newPosC ) );
        List <Animal> animals = simulation.getAnimalsList();

        // then
        for(int idx = 0 ; idx < 3 ; idx++ ) {
            assertTrue( animals.get(idx).isAt( newPositions.get(idx) ) );
        }


    }
}