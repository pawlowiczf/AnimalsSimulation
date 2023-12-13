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
        MoveValidator validator = new RectangularMap(4,4, 4);
        Animal animalA = new Animal(3, 4);
        Animal animalB = new Animal(5, 5);
        Animal animalC = new Animal(-3, -3);
        Animal animalD = new Animal(0,0);
        // when
        animalA.move( MoveDirection.FORWARD, validator );
        animalA.move( MoveDirection.FORWARD, validator );
        animalA.move( MoveDirection.RIGHT, validator   );
        animalA.move( MoveDirection.FORWARD, validator );
        animalA.move( MoveDirection.LEFT, validator    );

        animalB.move( MoveDirection.BACKWARD, validator);

        animalC.move( MoveDirection.RIGHT, validator   );
        animalC.move( MoveDirection.FORWARD, validator );
        animalC.move( MoveDirection.FORWARD, validator );
        animalC.move( MoveDirection.FORWARD, validator );

        animalD.move( MoveDirection.FORWARD, validator );
        animalD.move( MoveDirection.FORWARD, validator );
        animalD.move( MoveDirection.LEFT, validator    );
        animalD.move( MoveDirection.FORWARD, validator );
        animalD.move( MoveDirection.LEFT, validator    );
        animalD.move( MoveDirection.BACKWARD, validator);

        // then
        assertTrue( animalA.isAt( new Vector2d(4,4)   ) );
        assertTrue( animalB.isAt( new Vector2d(5,5)   ) ); // nic nie powinno się stać (zwierzę poza mapą)
        assertTrue( animalC.isAt( new Vector2d(-3,-3)  ) ); // nic nie powinno się stać (zwierzę poza mapą)
        assertTrue( animalD.isAt( new Vector2d(0 ,3) ) );
    }

    @Test
    public void doesNotAnimalCrossMapBorder() {
        // given
        MoveValidator validator = new RectangularMap(4,4, 4);
        Animal animalA = new Animal(4,4);
        Animal animalB = new Animal(-4, -4);
        Animal animalC = new Animal(-4, 4);
        Animal animalD = new Animal(4, -4);
        Animal animalE = new Animal(0 ,0);

        // when
        animalA.move( MoveDirection.FORWARD, validator  );
        animalA.move( MoveDirection.RIGHT, validator    );
        animalA.move( MoveDirection.FORWARD, validator  );

        animalB.move( MoveDirection.BACKWARD, validator );
        animalB.move( MoveDirection.LEFT, validator     );
        animalB.move( MoveDirection.FORWARD, validator  );

        animalC.move( MoveDirection.FORWARD, validator  );
        animalC.move( MoveDirection.LEFT, validator     );
        animalC.move( MoveDirection.FORWARD, validator  );

        animalD.move( MoveDirection.BACKWARD, validator );
        animalD.move( MoveDirection.RIGHT, validator    );
        animalD.move( MoveDirection.FORWARD, validator  );

        animalE.move( MoveDirection.FORWARD, validator );
        animalE.move( MoveDirection.FORWARD, validator );
        animalE.move( MoveDirection.FORWARD, validator );
        animalE.move( MoveDirection.FORWARD, validator );

        // then
        assertTrue( animalA.isAt( new Vector2d(4,  4) ) );
        assertTrue( animalB.isAt( new Vector2d(-4,-4) ) ); // nic nie powinno się stać (zwierzę poza mapą)
        assertTrue( animalC.isAt( new Vector2d(-4, 4) ) ); // nic nie powinno się stać (zwierzę poza mapą)
        assertTrue( animalD.isAt( new Vector2d(4, -4) ) ); // nic nie powinno się stać (zwierzę poza mapą)
        assertTrue( animalE.isAt( new Vector2d(0, 4)  ) );

    }
}