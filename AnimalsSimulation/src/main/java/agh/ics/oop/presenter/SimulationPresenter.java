package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import javafx.application.Platform;
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
//        infoLabel.setText( String.valueOf(map) );

        Boundary boundary = map.getCurrentBounds();
        int width  = boundary.rightBorder().getX() - boundary.leftBorder().getX() + 1;
        int height = boundary.rightBorder().getY() - boundary.leftBorder().getY() + 1;

        clearGrid();
        createNewGrid(width, height, boundary);
        updateWorldElementsPositionGrid(height, boundary);

    }

    private void createNewGrid(int width, int height, Boundary boundary) {
        //
        Label legend = new Label("y\\x");
        mapGrid.add(legend,0, 0);

        GridPane.setHalignment(legend, HPos.CENTER);
        mapGrid.getColumnConstraints().add(new ColumnConstraints(25));
        mapGrid.getRowConstraints().add(new RowConstraints(25));

        for (int counter = 0; counter < width; counter++) {
            //
            mapGrid.getColumnConstraints().add(new ColumnConstraints(25));
//            mapGrid.getRowConstraints().add(new RowConstraints(25));

            Label contentInside = new Label( "%d".formatted(counter + boundary.leftBorder().getX() ) );
            mapGrid.add( contentInside, counter + 1, 0 );
            GridPane.setHalignment(contentInside, HPos.CENTER);
        }

        for (int counter = 0; counter < height ; counter++) {
            //
//            mapGrid.getColumnConstraints().add(new ColumnConstraints(25));
            mapGrid.getRowConstraints().add(new RowConstraints(25));

            Label contentInside = new Label( "%d".formatted(height + boundary.leftBorder().getY() - counter - 1) );
            mapGrid.add( contentInside, 0, counter + 1);
            GridPane.setHalignment(contentInside, HPos.CENTER);
        }

    } // end method createNewGrid()

    private void updateWorldElementsPositionGrid(int height, Boundary boundary) {
        //
        List <WorldElement> worldElements = map.getElements();

        for (WorldElement element : worldElements) {
            //
            int xPosition = element.getPosition().getX() - boundary.leftBorder().getX() + 1;
            int yPosition = height - ( element.getPosition().getY() - boundary.leftBorder().getY() );
            Label contentInside = new Label( element.toString() );
            mapGrid.add( contentInside, xPosition, yPosition );
            GridPane.setHalignment(contentInside, HPos.CENTER);

        }
    } //

    private void clearGrid() {
        mapGrid.getChildren().retainAll( mapGrid.getChildren().get(0) ); // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    @FXML
    private Label moveInfo;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        //
        Platform.runLater( () -> {
            this.drawMap();
            this.moveInfo.setText(message);
        }
        );
    }

    @FXML
    private TextField enteredMoves;


    @FXML
    private void onSimulationStartClicked() throws InterruptedException {
        //

//        String[] enteredChars = enteredMoves.getText().split( "\\s+" );
//        List <MoveDirection> directions = OptionsParser.directionParser(enteredChars);

        List <MoveDirection> directions = OptionsParser.directionParser(enteredMoves.getText().split(" "));
        List <Vector2d> positions       = List.of( new Vector2d(1, 0), new Vector2d(2, 0 ), new Vector2d(3,0  ) );

        Simulation simulation = new Simulation(positions, directions, map);

        SimulationEngine simulationEngine = new SimulationEngine( new ArrayList <> ( List.of(simulation) ) );
        simulationEngine.runAsync();


    }
}
