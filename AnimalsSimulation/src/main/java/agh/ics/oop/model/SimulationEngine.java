package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine {
    //
    private final List <Simulation> simulationList;
    private final ArrayList <Thread> simulationThreadList = new ArrayList<>();

    public SimulationEngine( List <Simulation> simulationList ) {
        this.simulationList = simulationList;
        createThreadList(simulationList);
    } // constructor

    private void createThreadList(List <Simulation> simulationList ) {
        //
        for (Simulation currentSimulation : simulationList ) {
            Thread thread = new Thread(currentSimulation);
            simulationThreadList.add(thread);
        }
    }

    public void runSync() {
        //
        for (Simulation currentSimulation : simulationList) {
            currentSimulation.run();
        }
    } // end runSync() method

    public void runAsync() throws InterruptedException {
        //
        for (Thread currentThread : simulationThreadList ) {
            currentThread.start();

        }

        awaitSimulationsEnd();
    } // end runAsync() method

    private void awaitSimulationsEnd() throws InterruptedException {
        //
        for (Thread currentThread : simulationThreadList ) {
            currentThread.join();
        }
    } // end awaitSimulationsEnd() method
}
