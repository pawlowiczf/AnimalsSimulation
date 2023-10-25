package agh.ics.oop.model;

public enum MapDirection {
    NORTH, SOUTH, WEST, EAST;

    public String toString() {
        //
        String direction = switch (this) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
            case EAST -> "Wschód";
        };

        return direction;
    }

    public MapDirection next() {
        //
        MapDirection direction = switch (this) {
            case EAST  -> SOUTH;
            case SOUTH -> WEST;
            case WEST  -> NORTH;
            case NORTH -> EAST;
        };

        return direction;
    }

    public MapDirection previous() {
        //
        MapDirection direction = switch (this) {
            case EAST  -> NORTH;
            case NORTH -> WEST;
            case WEST  -> SOUTH;
            case SOUTH -> EAST;
        };

        return direction;
    }

    public Vector2d toUnitVector() {
        //
        Vector2d vector = switch (this) {
            case NORTH -> new Vector2d(0, 1);
            case EAST  -> new Vector2d(1, 0);
            case SOUTH -> new Vector2d(0, -1);
            case WEST  -> new Vector2d(-1, 0);
        };

        return vector;
    }
}
