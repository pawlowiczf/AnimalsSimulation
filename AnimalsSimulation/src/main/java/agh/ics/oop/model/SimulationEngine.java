package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine {
    //
    private final List <Simulation> simulationList;

    public SimulationEngine( List <Simulation> simulationList ) {
        this.simulationList = simulationList;
    } // constructor

    public void runSync() {
        //
        for(Simulation currentSimulation : simulationList ) {
            currentSimulation.run();
        }
    }


}
