package com.example.gamblinggame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.example.gamblinggame.Comparison.Compare;
import static com.example.gamblinggame.Comparison.c;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        HBox hbox0 = new HBox();
        HBox hbox1 = new HBox(10);
        HBox hbox2 = new HBox(10);
        VBox vbox = new VBox(20);

        Text intro = new Text("You will enter a 3 digits number (from 100 to 999) and the computer will generate a number at the same range." +
                "\nIf you can guess the number generated by the computer the you win otherwise you can try again. " +
                "\nBEST OF LUCK!");
        Text text = new Text("ENTER 3 DIGITS NUMBER BELOW");
        HBox.setMargin(text, new Insets(10,10,10,10));

        TextField tf = new TextField();
        tf.setPromptText("Enter text");
        tf.setFocusTraversable(false);
        HBox.setMargin(tf, new Insets(10,10,10,10));

        Text comment = new Text();
        HBox.setMargin(comment, new Insets(10,10,10,10));

        Button sb = new Button("Submit");
        HBox.setMargin(sb, new Insets(10,10,10,10));
        sb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Compare(Integer.parseInt(tf.getText()));
                comment.setText(c);
            }
        });

        hbox0.getChildren().addAll(intro);
        hbox1.getChildren().addAll(text, tf, sb);
        hbox2.getChildren().addAll(comment);
        vbox.getChildren().addAll(hbox0, hbox1, hbox2);

        Scene scene = new Scene(vbox, 700, 500);
        stage.setScene(scene);
        stage.show();
    }
}