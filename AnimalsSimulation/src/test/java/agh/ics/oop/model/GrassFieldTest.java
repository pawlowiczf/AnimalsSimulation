package agh.ics.oop.model;

import agh.ics.oop.model.util.RandomPositionGenerator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void checkIfRandomGeneratorOfGrassFieldsWorks() {
        // given
        int numberOfGrassFields = 100;
        int borderGrass = (int) Math.sqrt( numberOfGrassFields * 10 );
        Map<Vector2d, Grass> grassLocation = new HashMap<>();

        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(borderGrass, borderGrass, numberOfGrassFields);
        Iterator<Vector2d> positionsIterator = randomPositionGenerator.iterator();

        // when
        for(Vector2d grassPosition : randomPositionGenerator) {
            grassLocation.put(grassPosition, new Grass(grassPosition));
        }

        // then
        assertEquals( grassLocation.size(), 100);

    }

}