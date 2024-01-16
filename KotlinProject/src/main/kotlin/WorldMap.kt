interface WorldMap {
    //
    fun place(animal : Animal) : Unit;

    fun move(animal : Animal, direction : MoveDirection) : Unit;

    fun isOccupied(position : Vector2D) : Boolean;

    fun canMoveTo(position : Vector2D) : Boolean;

    fun objectAt(position : Vector2D) : Animal?;
}