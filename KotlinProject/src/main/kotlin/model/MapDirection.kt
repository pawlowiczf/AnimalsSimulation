package model

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
        EAST -> NORTH;
        NORTH -> WEST;
        WEST -> SOUTH;
        SOUTH -> EAST;
    }

    override fun toString() : String = when (this) {
        NORTH -> "North";
        SOUTH -> "South";
        WEST  -> "West";
        EAST  -> "East";
    }

} // end enum class MapDirection()