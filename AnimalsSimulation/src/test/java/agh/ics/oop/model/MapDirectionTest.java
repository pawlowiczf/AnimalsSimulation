package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    public void doesToStringWork() {
        //given
        MapDirection directionA = MapDirection.NORTH;
        MapDirection directionB = MapDirection.EAST;
        MapDirection directionC = MapDirection.WEST;
        MapDirection directionD = MapDirection.SOUTH;

        //when
        String stringA = directionA.toString();
        String stringB = directionB.toString();
        String stringC = directionC.toString();
        String stringD = directionD.toString();

        //then
        assertEquals(stringA, "Północ");
        assertEquals(stringB, "Wschód");
        assertEquals(stringC, "Zachód");
        assertEquals(stringD, "Południe");
    }

    @Test
    public void doesNextWork() {
        //given
        MapDirection directionA = MapDirection.NORTH;
        MapDirection directionB = MapDirection.EAST;
        MapDirection directionC = MapDirection.WEST;
        MapDirection directionD = MapDirection.SOUTH;

        //when
        MapDirection nextA = directionA.next();
        MapDirection nextB = directionB.next();
        MapDirection nextC = directionC.next();
        MapDirection nextD = directionD.next();

        //then
        assertEquals(nextA, MapDirection.EAST);
        assertEquals(nextB, MapDirection.SOUTH);
        assertEquals(nextC, MapDirection.NORTH);
        assertEquals(nextD, MapDirection.WEST);
    }

    @Test
    public void doesPreviousWork() {
        //given
        MapDirection directionA = MapDirection.NORTH;
        MapDirection directionB = MapDirection.EAST;
        MapDirection directionC = MapDirection.WEST;
        MapDirection directionD = MapDirection.SOUTH;

        //when
        MapDirection previousA = directionA.previous();
        MapDirection previousB = directionB.previous();
        MapDirection previousC = directionC.previous();
        MapDirection previousD = directionD.previous();

        //then
        assertEquals(previousA, MapDirection.WEST);
        assertEquals(previousB, MapDirection.NORTH);
        assertEquals(previousC, MapDirection.SOUTH);
        assertEquals(previousD, MapDirection.EAST);
    }

    @Test
    public void doesToUnitVectorWork() {
        //given
        MapDirection directionA = MapDirection.NORTH;
        MapDirection directionB = MapDirection.EAST;
        MapDirection directionC = MapDirection.WEST;
        MapDirection directionD = MapDirection.SOUTH;

        //when
        Vector2d unitA = directionA.toUnitVector();
        Vector2d unitB = directionB.toUnitVector();
        Vector2d unitC = directionC.toUnitVector();
        Vector2d unitD = directionD.toUnitVector();

        //then
        assertEquals(unitA.getX(), 0);
        assertEquals(unitA.getY(), 1);

        assertEquals(unitB.getX(), 1);
        assertEquals(unitB.getY(), 0);

        assertEquals(unitC.getX(), -1);
        assertEquals(unitC.getY(), 0);

        assertEquals(unitD.getX(), 0);
        assertEquals(unitD.getY(), -1);
    }
}