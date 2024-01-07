package agh.ics.oop.model;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class WorldElementBox {
    //
    @FXML
    private final Image image;

    @FXML
    private final ImageView imageView;

    public WorldElementBox(WorldElement element) {
        //
        this.image = new Image( element.getFilePath() );
        this.imageView = new ImageView();
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
    }

    public void setImage() {
        this.imageView.setImage(image);
    }

    public VBox newVBox() {
        //
        VBox newBox = new VBox();
        newBox.
    }

}
