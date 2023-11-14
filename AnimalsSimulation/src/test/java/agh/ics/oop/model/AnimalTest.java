package agh.ics.oop.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    //

    @Test
    public void isOrientationDefaultSetToNorth() {
        // given
        Animal animalA = new Animal();
        Animal animalB = new Animal();

        // when
        MapDirection orientationA = MapDirection.NORTH;
        MapDirection orientationB = MapDirection.NORTH;


        // then
        assertEquals(animalA.getOrientation(), orientationA);
        assertEquals(animalB.getOrientation(), orientationB);
    }

    @Test
    public void doesAnimalMoveProperlyOnBoard() {
        // given
        Animal animalA = new Animal(3, 4);
        Animal animalB = new Animal(5, 5);
        Animal animalC = new Animal(-3, -3);
        Animal animalD = new Animal(0,0);
        // when
        animalA.move( MoveDirection.FORWARD );
        animalA.move( MoveDirection.FORWARD );
        animalA.move( MoveDirection.RIGHT   );
        animalA.move( MoveDirection.FORWARD );
        animalA.move( MoveDirection.LEFT    );

        animalB.move( MoveDirection.BACKWARD);

        animalC.move( MoveDirection.RIGHT   );
        animalC.move( MoveDirection.FORWARD );
        animalC.move( MoveDirection.FORWARD );
        animalC.move( MoveDirection.FORWARD );

        animalD.move( MoveDirection.FORWARD );
        animalD.move( MoveDirection.FORWARD );
        animalD.move( MoveDirection.LEFT    );
        animalD.move( MoveDirection.FORWARD );
        animalD.move( MoveDirection.LEFT    );
        animalD.move( MoveDirection.BACKWARD);

        // then
        assertTrue( animalA.isAt( new Vector2d(4,4)   ) );
        assertTrue( animalB.isAt( new Vector2d(5,5)   ) ); // nic nie powinno się stać (zwierzę poza mapą)
        assertTrue( animalC.isAt( new Vector2d(-3,-3)  ) ); // nic nie powinno się stać (zwierzę poza mapą)
        assertTrue( animalD.isAt( new Vector2d(0 ,3) ) );
    }

    @Test
    public void doesNotAnimalCrossMapBorder() {
        // given
        Animal animalA = new Animal(4,4);
        Animal animalB = new Animal(-4, -4);
        Animal animalC = new Animal(-4, 4);
        Animal animalD = new Animal(4, -4);
        Animal animalE = new Animal(0 ,0);

        // when
        animalA.move( MoveDirection.FORWARD  );
        animalA.move( MoveDirection.RIGHT    );
        animalA.move( MoveDirection.FORWARD  );

        animalB.move( MoveDirection.BACKWARD );
        animalB.move( MoveDirection.LEFT     );
        animalB.move( MoveDirection.FORWARD  );

        animalC.move( MoveDirection.FORWARD  );
        animalC.move( MoveDirection.LEFT     );
        animalC.move( MoveDirection.FORWARD  );

        animalD.move( MoveDirection.BACKWARD );
        animalD.move( MoveDirection.RIGHT    );
        animalD.move( MoveDirection.FORWARD  );

        animalE.move( MoveDirection.FORWARD );
        animalE.move( MoveDirection.FORWARD );
        animalE.move( MoveDirection.FORWARD );
        animalE.move( MoveDirection.FORWARD );

        // then
        assertTrue( animalA.isAt( new Vector2d(4,  4) ) );
        assertTrue( animalB.isAt( new Vector2d(-4,-4) ) ); // nic nie powinno się stać (zwierzę poza mapą)
        assertTrue( animalC.isAt( new Vector2d(-4, 4) ) ); // nic nie powinno się stać (zwierzę poza mapą)
        assertTrue( animalD.isAt( new Vector2d(4, -4) ) ); // nic nie powinno się stać (zwierzę poza mapą)
        assertTrue( animalE.isAt( new Vector2d(0, 4)  ) );

    }
}