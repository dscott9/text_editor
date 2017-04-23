package dev.text.ed;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;

/**
 * Created: dale_
 * Date: 23/04/2017.
 */
public class TextEditor extends Application {

    private Stage window;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("TextEditor+");
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        // Create Scene start - refactor start
        Label label = new Label("TextEditor+ Project");
        Group root = new Group(label);
        Scene scene = new Scene(root, 1500, 800);

        // create menu
        Menu menu = createFileMenu();

        MenuBar menuBar = new MenuBar(menu);
        menuBar.prefWidthProperty().bind(window.widthProperty());

        root.getChildren().add(menuBar);

        window.setScene(scene);
        window.show();
    }

    private Menu createFileMenu() {
        MenuItem newMenuItem = createMenuItem("New");
        newMenuItem.setOnAction(event -> System.out.println("Option New Selected"));

        MenuItem saveMenuItem = createMenuItem("Save");
        saveMenuItem.setOnAction(event -> System.out.println("Option Save Selected"));

        MenuItem exitMenuItem = createMenuItem("Exit");
        exitMenuItem.setOnAction(e -> closeProgram());

        return new Menu("File", null, newMenuItem, saveMenuItem, new SeparatorMenuItem(), exitMenuItem);
    }

    private void closeProgram() {
        Boolean answer = ConfirmationBox.display("Close TextEditor+", "Are you sure?");
        if (answer)
            window.close();
    }

    private MenuItem createMenuItem(String menuItemName) {
        return new MenuItem(menuItemName);
    }
}
