package model

class RandomExtensions {
    //

} // end class RandomExtensions()

fun <T> Map <Vector2D, T>.randomPosition() : Vector2D? {
    //
    if ( this.isEmpty() ) { return null }
    return this.keys.toList().random();
}

fun <T> Map <Vector2D, T>.randomFreePosition(mapSize : Vector2D) : Vector2D? {
    //
    val freePosition: Vector2D? = this.randomPosition();

    if ( freePosition == null ) { return null; }
    if ( freePosition > mapSize ) { randomFreePosition(mapSize); }

    return freePosition;
} // Rekurencyjna funkcja. Jak nie spełnia wymagań, to szukam dalej. Jak spełnia, to zwracam. Tutaj oczywiście
// może się okazać, że nigdy nie będzie wolnego pola. Warto by było zrobić deterministyczne losowanie. Jeśli byśmy
// wtedy nie znaleźli pola, to wiemy, że nie ma już miejsca i możemy zakończyć znajdowanie z niepowodzeniem. A tak to
// loteria.