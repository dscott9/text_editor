package dev.text.ed;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created: dale_
 * Date: 23/04/2017.
 */
public class ConfirmationBox {

    static boolean answer;

    public static boolean display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);

        Label label = new Label();
        label.setText(message);

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        GridPane grid = new GridPane();
        grid.setMinSize(300, 100);
        grid.setPadding(new Insets(10, 10 ,10 ,10));
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setAlignment(Pos.CENTER);

        grid.add(label, 1, 0);
        grid.add(yesButton, 0, 1);
        grid.add(noButton, 2, 1);

        yesButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        noButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        label.setStyle("-fx-font: normal bold 20px 'serif' ");
        grid.setStyle("-fx-background-color: BEIGE;");

        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
