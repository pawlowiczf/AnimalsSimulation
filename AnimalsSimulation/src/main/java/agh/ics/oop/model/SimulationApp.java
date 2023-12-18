package agh.ics.oop.model;

import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SimulationApp extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        //
        GrassField currentMap = new GrassField(1, 10);


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));
        BorderPane viewRoot = loader.load();

        SimulationPresenter presenter = loader.getController();
        currentMap.addSubscriber(presenter);
        presenter.setWorldMap(currentMap);

        configureStage(primaryStage, viewRoot);
        primaryStage.show();
    }

    private void configureStage(Stage primaryStage, BorderPane viewRoot) {
        //
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation app");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
    }


}
