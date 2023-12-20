package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class SimulationPresenter implements MapChangeListener  {
    //
    private GrassField map;

    @FXML
    private Label infoLabel;

    public void setWorldMap(GrassField map) {
        this.map = map;
    }

    @FXML
    private GridPane mapGrid;

    public void drawMap() {
//        infoLabel.setText( String.valueOf(map) ); tak było w pierwszej części konspektu, teraz tworzymy GridPane:
        clearGrid();
        createNewGrid();
        updateWorldElementsPositionGrid();

    }

    private void createNewGrid() {
        //
        Boundary boundary = map.getCurrentBounds();
        int mapWidth  = abs( boundary.rightBorder().getX() ) + abs( boundary.leftBorder().getX() );
        int mapHeight = abs( boundary.rightBorder().getY() ) + abs( boundary.leftBorder().getY() );

        int leftX = boundary.leftBorder().getX();
        int upperY = boundary.rightBorder().getY();

        Label legend = new Label("y\\x");
        mapGrid.add(legend,0, 0);

        mapGrid.getColumnConstraints().add(new ColumnConstraints(25));
        mapGrid.getRowConstraints().add(new RowConstraints(25));

        for (int counter = 0; counter < mapWidth; counter++) {
            //
            mapGrid.getColumnConstraints().add(new ColumnConstraints(25));
            mapGrid.getRowConstraints().add(new RowConstraints(25));
            Label contentInside = new Label( "%d".formatted(leftX + counter) );
            mapGrid.add( contentInside, counter + leftX, 0 );
            GridPane.setHalignment(contentInside, HPos.CENTER);
        }

        for (int counter = 0; counter < mapHeight ; counter++) {
            mapGrid.getColumnConstraints().add(new ColumnConstraints(25));
            mapGrid.getRowConstraints().add(new RowConstraints(25));
            Label contentInside = new Label( "%d".formatted(upperY - counter) );
            mapGrid.add( contentInside, 0, upperY - counter);
            GridPane.setHalignment(contentInside, HPos.CENTER);
        }

    }

    private void updateWorldElementsPositionGrid() {
        //
        List <WorldElement> worldElements = map.getElements();

        for (WorldElement element : worldElements) {
            //
            Label contentInside = new Label( element.toString() );
            mapGrid.add( contentInside, element.getPosition().getX(), element.getPosition().getY() );
            GridPane.setHalignment(contentInside, HPos.CENTER);

        }
    } //

    private void clearGrid() {
        mapGrid.getChildren().retainAll( mapGrid.getChildren().get(0) ); // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }


    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        drawMap();
    }

    @FXML
    private TextField enteredMoves;


    @FXML
    private void onSimulationStartClicked() {
        //

//        String[] enteredChars = enteredMoves.getText().split( "\\s+" );
//        List <MoveDirection> directions = OptionsParser.directionParser(enteredChars);

        List <MoveDirection> directions = OptionsParser.directionParser(enteredMoves.getText().split(" "));
        List <Vector2d> positions       = List.of( new Vector2d(2, 2), new Vector2d(3, 2 ), new Vector2d(0,0  ) );

        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run();

    }
}
