package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static agh.ics.oop.OptionsParser.directionParser;

public class World2 {
    //

    public static void main(String[] args) {
        //
        List<MoveDirection> directions;
        List <Vector2d> positions = new ArrayList<>();

        directions = directionParser(args);
        positions.add( new Vector2d(2, 2 ) );
        positions.add( new Vector2d(3, 2 ) );
        positions.add( new Vector2d(0,0  ) );

        GrassField animalsParkB     = new GrassField(2,10);

//        ConsoleMapDisplay subscriberA = new ConsoleMapDisplay();
//        animalsParkB.addSubscriber(subscriberA);

        // Nowy obserwator:
        animalsParkB.addSubscriber( (map, message) -> {
            System.out.println(LocalDate.now() + " " + LocalTime.now().truncatedTo(ChronoUnit.MINUTES) + ": " + message);
        });

        Simulation simulationB = new Simulation(positions, directions, animalsParkB);
        simulationB.run();
    }



}
