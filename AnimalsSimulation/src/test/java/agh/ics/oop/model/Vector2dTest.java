package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    public void isXcoordinateProper() {
        //given
        Vector2d vectorA = new Vector2d(3, 4);
        Vector2d vectorB = new Vector2d(-10000, 0);
        Vector2d vectorC = new Vector2d(2137, 9420);

        //when
        int xVectorA = vectorA.getX();
        int xVectorB = vectorB.getX();
        int xVectorC = vectorC.getX();

        //then
        assertEquals(xVectorA, 3);
        assertEquals(xVectorB, -10000);
        assertEquals(xVectorC, 2137);
    }

    @Test
    public void isYcoordinateProper() {
        //given
        Vector2d vectorA = new Vector2d(3, 4);
        Vector2d vectorB = new Vector2d(-10000, 0);
        Vector2d vectorC = new Vector2d(2137, 9420);

        //when
        int yVectorA = vectorA.getY();
        int yVectorB = vectorB.getY();
        int yVectorC = vectorC.getY();

        //then
        assertEquals(yVectorA, 4);
        assertEquals(yVectorB, 0);
        assertEquals(yVectorC, 9420);
    }

    @Test
    public void doesPrecedesWorkProperly() {
        //given
        Vector2d vectorA = new Vector2d(5, 7);
        Vector2d vectorB = new Vector2d(5, 8);

        //then
        boolean flagAB = vectorA.precedes(vectorB);
        boolean flagBA = vectorB.precedes(vectorA);

        //then
        assertTrue( flagAB ); // czy to jest prawda? oby tak
        assertFalse( flagBA ); // czy to jest fałsz? oby tak
    }

    @Test
    public void doesFollowWorkProperly() {
        //given
        Vector2d vectorA = new Vector2d(154, 679);
        Vector2d vectorB = new Vector2d(58, 0);

        Vector2d vectorC = new Vector2d(0, 0);
        Vector2d vectorD = new Vector2d(0, 0);

        //when
        boolean flagAB = vectorA.follow(vectorB);
        boolean flagBA = vectorB.follow(vectorA);

        boolean flagCD = vectorC.follow(vectorD);
        boolean flagDC = vectorD.follow(vectorC);

        //then
        assertTrue( flagAB );
        assertFalse( flagBA );

        assertTrue( flagCD ); // sprawdzenie, czy relacja symetryczna
        assertTrue( flagDC );
    }

    @Test
    public void doesAddingVectorsWork() {
        //given
        Vector2d vectorA = new Vector2d(9, 10);
        Vector2d vectorB = new Vector2d(19, -5);

        //when
        Vector2d vectorC = vectorA.add(vectorB);
        int xVectorC = vectorC.getX();
        int yVectorC = vectorC.getY();

        //then
        assertEquals(xVectorC, 28);
        assertEquals(yVectorC, 5);
    }

    @Test
    public void doesSubtractingVectorsWork() {
        //given
        Vector2d vectorA = new Vector2d(0, 179);
        Vector2d vectorB = new Vector2d(16, 41);

        //when
        Vector2d vectorC = vectorA.subtract(vectorB);
        Vector2d vectorD = vectorB.subtract(vectorA);

        //then
        assertEquals( vectorC.getX(), -16 );
        assertEquals( vectorC.getY(), 138);
        assertEquals( vectorD.getX(), 16);
        assertEquals( vectorD.getY(), -138);
    }

    @Test
    public void doesUpperRightWork() {
        //given
        Vector2d vectorA = new Vector2d(13, 19);
        Vector2d vectorB = new Vector2d(16, -3);
        Vector2d vectorC = new Vector2d(-4, -2);

        //when
        Vector2d vectorD = vectorA.upperRight(vectorB);
        Vector2d vectorE = vectorB.upperRight(vectorC);

        //then
        assertEquals( vectorD.getX(), 16);
        assertEquals( vectorD.getY(), 19);

        assertEquals( vectorE.getX(), 16);
        assertEquals( vectorE.getY(), -2);
    }

    @Test
    public void doesLowerLeftWork() {
        //given
        Vector2d vectorA = new Vector2d(13, 19);
        Vector2d vectorB = new Vector2d(16, -3);
        Vector2d vectorC = new Vector2d(-4, -2);

        //when
        Vector2d vectorD = vectorA.lowerLeft(vectorB);
        Vector2d vectorE = vectorB.lowerLeft(vectorC);

        //then
        assertEquals(vectorD.getX(), 13);
        assertEquals(vectorD.getY(), -3);

        assertEquals(vectorE.getX(), -4);
        assertEquals(vectorE.getY(), -3);
    }

    @Test
    public void doesOppositeWork() {
        //given
        Vector2d vectorA = new Vector2d(-4, 5);
        Vector2d vectorB = new Vector2d(16, 0);

        //when
        Vector2d vectorC = vectorA.opposite();
        Vector2d vectorD = vectorB.opposite();

        //then
        assertEquals(vectorC.getX(), 4);
        assertEquals(vectorC.getY(), -5);
        assertEquals(vectorD.getX(), -16);
        assertEquals(vectorD.getY(), 0);
    }

    @Test
    public void doesEqualsWork() {
        //given
        Vector2d vectorA = new Vector2d(4,4);
        Vector2d vectorB = new Vector2d(4,4);
        Vector2d vectorC = new Vector2d(4,0);

        //when
        boolean flagAB = vectorA.equals(vectorB);
        boolean flagAA = vectorA.equals(vectorA); // tylko sprawdzam
        boolean flagBC = vectorB.equals(vectorC);

        //then
        assertTrue( flagAB );
        assertTrue( flagAA );
        assertFalse( flagBC );
    }
}