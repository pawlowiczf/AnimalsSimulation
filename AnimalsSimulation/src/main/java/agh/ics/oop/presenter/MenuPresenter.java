package agh.ics.oop.presenter;

import agh.ics.oop.model.GrassField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPresenter {
    //
    private int mapCounter;

    public void startNewSimulation() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));
        BorderPane viewRoot = loader.load();

        SimulationPresenter presenter = loader.getController();

        GrassField currentMap = new GrassField(mapCounter, 10);
        mapCounter++;

        currentMap.addSubscriber(presenter);
        presenter.setWorldMap(currentMap);

        Stage primaryStage = new Stage();
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation app");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
        primaryStage.show();
    }



}
