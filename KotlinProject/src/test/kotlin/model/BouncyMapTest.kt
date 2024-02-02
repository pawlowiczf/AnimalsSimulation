package model

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class BouncyMapTest : FunSpec({
    //
    test("testing method place") {
      //
        val animalsMap : BouncyMap = BouncyMap(10,10);
        val animalA : Animal = Animal(1,2);
        val animalB : Animal = Animal(3, 4);
        animalsMap.place(animalA);
        animalsMap.place(animalB);

        val newAnimal : Animal = Animal(1,2);
        animalsMap.place( newAnimal );

        newAnimal.position shouldNotBe Vector2D(1,2);

    }

    test("testing method isOccupied") {
        //
        val animalsMap : BouncyMap = BouncyMap(10,10);
        val animalA : Animal = Animal(1,2);
        val animalB : Animal = Animal(3, 4);
        animalsMap.place(animalA);
        animalsMap.place(animalB);

        animalsMap.isOccupied( Vector2D(1,2) ) shouldBe true
        animalsMap.isOccupied( Vector2D(3,4) ) shouldBe true
        animalsMap.isOccupied( Vector2D(1,1) ) shouldNotBe true
    }

    test("testing method canMoveTo") {
        //
        val animalsMap : BouncyMap = BouncyMap(10,10);

        animalsMap.canMoveTo( Vector2D(15,15) ) shouldBe false
        animalsMap.canMoveTo( Vector2D(5,4) )   shouldBe true
        animalsMap.canMoveTo( Vector2D(1,2) )   shouldBe true

    }

    test("testing method objectAt") {
        //
        val animalsMap : BouncyMap = BouncyMap(10,10);
        val animalA : Animal = Animal(1,2);
        val animalB : Animal = Animal(3, 4);
        animalsMap.place(animalA);
        animalsMap.place(animalB);

        animalsMap.objectAt( Vector2D(1,2) ) shouldBe animalA
        animalsMap.objectAt( Vector2D(3,4) ) shouldBe animalB
        animalsMap.objectAt( Vector2D(6,6) ) shouldBe null;

    }
})
