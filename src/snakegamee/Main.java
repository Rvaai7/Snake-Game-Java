package snakegamee;

import javafx.application.Application;
import javafx.stage.Stage;
import snakegamee.controller.GameController;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        GameController controller = new GameController(stage);
        controller.startGame();
    }

    public static void main(String[] args) {
        launch(args);
    }
}