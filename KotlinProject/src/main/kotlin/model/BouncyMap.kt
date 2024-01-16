package model

class BouncyMap (private val width : Int, private val height : Int) : WorldMap { // end class BouncyMap
    //
    private var animalsPosition : MutableMap <Vector2D, Animal> = mutableMapOf();

    override fun place(animal: Animal) : Unit {
        val animalPosition: Vector2D = animal.position;

        if ( animalsPosition.containsKey( animalPosition ) ) { bounceAnimals(animal); }
        else { animalsPosition[animalPosition] = animal; }
    }

    private fun bounceAnimals(animal : Animal) : Unit {
        //
        val position = animalsPosition.randomFreePosition( Vector2D(width, height) ) ?: return Unit;

        animalsPosition[position] = animal;
        animal.position = position;
    }

    override fun isOccupied(position: Vector2D) : Boolean = animalsPosition.containsKey(position);

    override fun canMoveTo(position: Vector2D): Boolean = position.x <= width && position.y <= height;

    override fun objectAt(position: Vector2D): Animal? = animalsPosition[position];

}





