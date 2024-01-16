import kotlin.math.max
import kotlin.math.min

data class Vector2D (var x : Int, var y : Int) {
    //

    // Zastępuje follow(), precedes():
    operator fun compareTo (other : Vector2D) : Int = this.x.compareTo(other.x) + this.y.compareTo(other.y);

    // Zastępuje add(), subtract()
    operator fun plus (other : Vector2D) : Vector2D  = Vector2D( this.x + other.x, this.y + other.y );
    operator fun minus (other : Vector2D) : Vector2D = Vector2D( this.x - other.x, this.y - other.y );

    fun upperRight (other : Vector2D) : Vector2D = Vector2D( max(this.x, other.x), max(this.y, other.y) );
    fun lowerLeft  (other : Vector2D) : Vector2D = Vector2D( min(this.x, other.x), min(this.y, other.y) );

    fun opposite () : Vector2D = this.copy( x = -x, y = -y);


}

fun main() {
    //
    var wektorA = Vector2D(5, 4);
    var wektorB = Vector2D(6, 5);
    println( wektorA > wektorB );
}