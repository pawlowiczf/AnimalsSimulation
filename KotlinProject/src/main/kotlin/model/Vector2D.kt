package model

import kotlin.math.max
import kotlin.math.min

data class Vector2D (var x : Int, var y : Int) {
    //

    // Zastępuje follow(), precedes():
    operator fun compareTo (other : Vector2D) : Int = this.x.compareTo(other.x) + this.y.compareTo(other.y);

    // Zastępuje add(), subtract()
    operator fun plus (other : Vector2D) : Vector2D = Vector2D( this.x + other.x, this.y + other.y );
    operator fun minus (other : Vector2D) : Vector2D = Vector2D( this.x - other.x, this.y - other.y );

    fun upperRight (other : Vector2D) : Vector2D = Vector2D( max(this.x, other.x), max(this.y, other.y) );
    fun lowerLeft  (other : Vector2D) : Vector2D = Vector2D( min(this.x, other.x), min(this.y, other.y) );

    fun opposite () : Vector2D = this.copy( x = -x, y = -y);


} // end class Vector2D

fun MapDirection.toUnitVector() : Vector2D = when (this) {
    //
    MapDirection.NORTH -> Vector2D(0, 1);
    MapDirection.EAST  -> Vector2D(1, 0);
    MapDirection.SOUTH -> Vector2D(0, -1);
    MapDirection.WEST  -> Vector2D(-1, 0);
}
