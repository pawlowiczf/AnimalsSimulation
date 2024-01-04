package agh.ics.oop.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileMapDisplay implements MapChangeListener {
    //

    @Override
    public void mapChanged(WorldMap worldMap, String message) {

        String path = "map_" + worldMap.getId() + ".log";
        File mapFileChanges = new File(path);
        boolean success = mapFileChanges.createNewFile();

        try {
            mapFileChanges.createNewFile();
            updateMap( path, worldMap.toString() );

        } catch (IOException error) {
            error.printStackTrace();
        }

    } // end method mapChanged()


    private void updateMap(String path, String mapString) throws FileNotFoundException {
        //
        try (PrintWriter content = new PrintWriter(path) ) {
            //
            content.append(mapString);

        } catch (FileNotFoundException error) {
            error.printStackTrace();
        }

    } // end method updateMap()

}
