package agh.ics.oop.model;

@FunctionalInterface
public interface MapChangeListener {
    //

    void mapChanged(WorldMap worldMap, String message);

    // Wzorzec projektowy - observer - stosowałbym go wtedy, gdy zmiana atrybutu, wywołanie jakiejś metody w danej klasie
    // musi pociągać za sobą pewne zmiany w innych klasach. Możemy zastosować ten wzorzeć i jeśli coś zmieni
    // się, to wszystkie klasy, które implementują ten interfejs, wykonają jakąś logikę. Jest to taki 'trigger',
    // reakcja na zmianę. Tak to rozumiem :)

}
