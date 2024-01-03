package agh.ics.oop;
import agh.ics.oop.model.*;
import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static agh.ics.oop.OptionsParser.directionParser;


public class World {
    //
    public static void run(List <MoveDirection> directions)
    {
        //
        System.out.println("Start");

        for(MoveDirection direction : directions) {
            //
            switch(direction) {
                case FORWARD  -> System.out.println( "Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println( "Zwierzak idzie do tyłu"  );
                case RIGHT    -> System.out.println( "Zwierzak skręca w prawo" );
                case LEFT     -> System.out.println( "Zwierzak skręca w lewo"  );
            }
        } //end 'for each' loop
        System.out.println("Stop");
    }

    public static void main(String[] args) throws InterruptedException {
        //
//        Application.launch(SimulationApp.class, args);

//        List <MoveDirection> directions;
//        List <Vector2d> positions = new ArrayList<>();
//
//        directions = directionParser(args); // nieobsłużenie wyjątku; program się zakończy
//
//        positions.add( new Vector2d(2, 2 ) );
//        positions.add( new Vector2d(3, 2 ) );
//        positions.add( new Vector2d(0,0  ) );
//
////        RectangularMap animalsParkA = new RectangularMap(1, 10,10);
//        GrassField animalsParkB     = new GrassField(2,10);
//
//        ConsoleMapDisplay subscriber = new ConsoleMapDisplay();
////        animalsParkA.addSubscriber(subscriber);
//        animalsParkB.addSubscriber(subscriber);
//
////        Simulation simulationA = new Simulation(positions, directions, animalsParkA);
//        Simulation simulationB = new Simulation(positions, directions, animalsParkB);
//
//        List <Simulation> simulationList = new ArrayList <> ( Arrays.asList( simulationA, simulationB ) );
//        SimulationEngine simulationEngine = new SimulationEngine( simulationList );
//
//        ArrayList <Simulation> simulationList = new ArrayList<>();
//
//        for (int counter = 0 ; counter < 10 ; counter++ ) {
//            GrassField animalsPark = new GrassField(counter, 10);
//            animalsPark.addSubscriber(subscriber);
//            Simulation simulation  = new Simulation(positions, directions, animalsPark);
//
//            simulationList.add(simulation);
//        }
//
//        SimulationEngine simulationEngine = new SimulationEngine( simulationList );
//        simulationEngine.runSync();
//        simulationEngine.runAsync();
//        simulationEngine.runAsyncInThreadPool();


        System.out.println("System zakonczyl dzialanie");
    }

}

