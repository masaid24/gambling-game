package com.example.gamblinggame;

import java.util.function.UnaryOperator;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.*;
import javafx.util.converter.IntegerStringConverter;

import javafx.geometry.Pos;

// this is a wrapper for the TextField
public class InputBox {
    private TextField tf;

    // filter for only 1 int
    UnaryOperator<TextFormatter.Change> integerFilter = change -> {
        String newText = change.getControlNewText();
        if (newText.matches("-?([0-9])?")) {
        return change;
        }
        return null;
    };

    InputBox() {
        this.tf = new TextField();
        tf.setPromptText("Enter text");
        tf.setPrefWidth(50);
        tf.setAlignment(Pos.CENTER);
        tf.setFocusTraversable(false);
        HBox.setMargin(tf, new Insets(5,5,5,10));

        tf.setTextFormatter(
            new TextFormatter<Integer>(new IntegerStringConverter(), 0, this.integerFilter));
    }

    TextField Input() {
        return this.tf;
    }

    String GetText() {
        return this.tf.getText().substring(this.tf.getText().length() - 1);
    }
}