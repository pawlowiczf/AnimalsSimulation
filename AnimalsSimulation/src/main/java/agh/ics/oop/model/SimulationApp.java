package agh.ics.oop.model;

import agh.ics.oop.Simulation;
import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;
import javafx.css.SizeUnits;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static agh.ics.oop.OptionsParser.directionParser;

public class SimulationApp extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        //
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("menu.fxml"));
        BorderPane viewRoot = loader.load();

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
