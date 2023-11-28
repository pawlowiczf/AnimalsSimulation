package agh.ics.oop.model.util;

import agh.ics.oop.model.Vector2d;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class RandomPositionGenerator implements Iterable<Vector2d>{
    //
    private final int maxWidth;
    private final int maxHeight;
    private int grassCount;
    private final ArrayList<Integer> arrayGenerator;

    public RandomPositionGenerator(int maxWidth, int maxHeight, int grassCount) {
        this.maxWidth = (int) Math.sqrt( maxWidth * 10 );
        this.maxHeight = (int) Math.sqrt( maxHeight * 10 );
        this.grassCount = grassCount;

        this.arrayGenerator = new ArrayList<>();
        for(int idx = 0 ; idx <= maxWidth * maxHeight; idx++) {
            arrayGenerator.add(idx);
        }
    }

    @Override
    public Iterator<Vector2d> iterator() {
        return new getIterator();
    }

    class getIterator implements Iterator<Vector2d> {

        @Override
        public boolean hasNext() {
            return grassCount >= 1 && !arrayGenerator.isEmpty();
        }

        @Override
        public Vector2d next() {
            //
            int randomIndex = (int) Math.floor( Math.random() * ( arrayGenerator.size() ) );
            int xCoord = ( arrayGenerator.get(randomIndex) / maxHeight );
            int yCoord = ( arrayGenerator.get(randomIndex) % maxWidth );
            arrayGenerator.remove( randomIndex );
            grassCount -= 1;

            return new Vector2d(xCoord, yCoord);
        }
    }


}
