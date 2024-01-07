package agh.ics.oop.model;

import java.io.*;
import java.util.Scanner;

public class FileMapDisplay implements MapChangeListener {
    //

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        //
        String path = "map_" + worldMap.getId() + ".log";
        File mapFileChanges = new File(path);

        try (PrintWriter printToFile = new PrintWriter( new FileWriter(mapFileChanges, true) )) {
            //
            if ( !mapFileChanges.exists() ) { mapFileChanges.createNewFile(); }

            printToFile.println(message);
            printToFile.append( worldMap.toString() );
            printToFile.println( "----------------------------");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    } // end method mapChanged()

}
