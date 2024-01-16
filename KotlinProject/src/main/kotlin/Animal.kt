

class Animal (x : Int = 2, y : Int = 2) {
    //
    var orientation : MapDirection = MapDirection.NORTH
        private set

    var position : Vector2D = Vector2D(x,y) // domyślnie to jest x = 2, y = 2;
        private set


    fun isAt( otherPosition : Vector2D ) = this.position == otherPosition;

    fun move( direction : MoveDirection, map : WorldMap ) : Unit = when( direction ) {
        MoveDirection.RIGHT -> orientation = orientation.next()
        MoveDirection.LEFT  -> orientation = orientation.previous();

        MoveDirection.FORWARD -> {
            if (map.canMoveTo( position + orientation.toUnitVector() ) ) {
                position += orientation.toUnitVector()
            } else { }
        }

        MoveDirection.BACKWARD -> {
            if (map.canMoveTo( position - orientation.toUnitVector() ) ) {
                position -= orientation.toUnitVector()
            } else { }
        }
    } // end method move()



}

fun main() {
    var animal = Animal();

}