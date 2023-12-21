package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {
    //
    private final List <Simulation> simulationList;
    private final ArrayList <Thread> simulationThreadList = new ArrayList<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

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

//        awaitSimulationsEnd();
    } // end runAsync() method

    private void awaitSimulationsEnd() throws InterruptedException {
        //
        for (Thread currentThread : simulationThreadList ) {
            currentThread.join();
        }

        if ( ! executorService.awaitTermination(10, TimeUnit.SECONDS) ) {
            executorService.shutdown();
        }

    } // end awaitSimulationsEnd() method

    public void runAsyncInThreadPool() throws InterruptedException {
        //
        for (Simulation currentSimulation : simulationList ) {
            executorService.submit( currentSimulation );
        }

        awaitSimulationsEnd();
    }

    // Zastosowanie puli wątków zapewnia efektywne zarządzanie wyjątkami, nie musimy przejmować się
    // tym zarządzaniem, wszystko jest robione za nas, warstwa abstrakcji. Ponadto nie tworzymy np. 10.000 wątków,
    // które zajmują pamięć i czas.
}
