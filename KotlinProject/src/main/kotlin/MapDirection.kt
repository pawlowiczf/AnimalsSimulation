enum class MapDirection {
    //
    NORTH, SOUTH, WEST, EAST;

    fun next() : MapDirection = when (this) {
        EAST  -> SOUTH;
        SOUTH -> WEST;
        WEST  -> NORTH;
        NORTH -> EAST;
    }

    fun previous() : MapDirection = when (this) {
        EAST  -> NORTH;
        NORTH -> WEST;
        WEST  -> SOUTH;
        SOUTH -> EAST;
    }

    fun toUnitVector() : Vector2D = when (this) {
        NORTH -> Vector2D(0, 1);
        EAST  -> Vector2D(1, 0);
        SOUTH -> Vector2D(0, -1);
        WEST  -> Vector2D(-1, 0);
    }

    override fun toString() : String = when (this) {
        NORTH -> "North";
        SOUTH -> "South";
        WEST  -> "West";
        EAST  -> "East";
    }

} // end enum class MapDirection()