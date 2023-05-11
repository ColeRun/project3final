package edu.guilford;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CardPane extends Pane {
    static Pane layout = new Pane();
    // create scene constrcutor that can be used in CardFX
    Button button = new Button("BlackJack");
    Label label = new Label("Click the button to show results from a blackjack game");
    CheckBox checkBox = new CheckBox("Click me for a cool image:");

    // create a method to add the image to the pane
    public void addDisplay() {
        // create an imageview object
        ImageView imageView;
        button.setLayoutX(200);
        button.setLayoutY(200);
        checkBox.setLayoutY(200);
        // move label
        label.setLayoutX(300);
        label.setLayoutY(200);
        this.getChildren().add(button);
        this.getChildren().add(checkBox);
        this.getChildren().add(label);

        // create a file object
        // create image and siplay it
        File space = new File(this.getClass().getResource("imagesofspacee.jpg").getPath());
        imageView = new ImageView(space.toURI().toString());

        this.getChildren().add(imageView);
        // mkae it so if checkbox is clicked, image is visible
        // mkae image invisible
        imageView.setVisible(false);
        checkBox.setOnAction(e -> {
            if (imageView.isVisible() == false) {
                imageView.setVisible(true);
            } else {
                imageView.setVisible(false);
            }
        });

        button.setOnAction(e -> {
            label.setText(handgen.playGame());
        });

    }

    // method to change visibility of image if checkbox is pressed
    public void imagevisible(ImageView imageView) {
        imageView.setVisible(true);
    }
}
