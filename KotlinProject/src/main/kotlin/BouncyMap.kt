class BouncyMap (val width : Int, val height : Int) : WorldMap { // end class BouncyMap
    //
    var animalsPosition : MutableMap <Vector2D, Animal> = mutableMapOf();

    override fun place(animal: Animal) : Unit {
        val animalPosition: Vector2D = animal.position;

        if ( animalsPosition.containsKey( animalPosition ) ) { bounceAnimals(animal); }
        else { animalsPosition[animalPosition] = animal; }
    }

    private fun bounceAnimals(animal : Animal) : Unit {

    }

    override fun move(animal: Animal, direction: MoveDirection) : Unit {
        TODO("Not yet implemented")
    }

    override fun isOccupied(position: Vector2D) : Boolean = animalsPosition.containsKey(position);

    override fun canMoveTo(position: Vector2D): Boolean = position.x <= width && position.y <= height;

    override fun objectAt(position: Vector2D): Animal? = animalsPosition[position];

}





