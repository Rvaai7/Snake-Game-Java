package snakegamee.controller;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import snakegamee.model.Direction;
import snakegamee.model.GameModel;
import snakegamee.patterns.FoodFactory;
import snakegamee.patterns.GameManager;
import snakegamee.view.GameView;

public class GameController {

    private GameModel model;
    private GameView view;
    private GameManager manager;

    private Stage stage;
    private long lastUpdate = 0;

    public GameController(Stage stage) {
        this.stage = stage;
        manager = GameManager.getInstance();
    }

    public void startGame() {

        model = new GameModel();
        view = new GameView(model);

        FoodFactory.createFood(model);

        Pane root = new Pane(view.canvas);
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(event -> {

            if(event.getCode() == KeyCode.R && model.gameOver) {
                restartGame();
            }

            if(event.getCode() == KeyCode.UP && model.direction != Direction.down) {
                model.direction = Direction.up;
            }

            if(event.getCode() == KeyCode.DOWN && model.direction != Direction.up) {
                model.direction = Direction.down;
            }

            if(event.getCode() == KeyCode.LEFT && model.direction != Direction.right) {
                model.direction = Direction.left;
            }

            if(event.getCode() == KeyCode.RIGHT && model.direction != Direction.left) {
                model.direction = Direction.right;
            }
        });

        stage.setTitle("Snake Game");
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {

                double speed = getSpeed();

                if(now - lastUpdate < speed) {
                    return;
                }

                lastUpdate = now;

                if(model.gameOver) {
                    manager.saveHighScore();
                    view.drawGameOver();
                    return;
                }

                updateGame();
                view.draw(model);
            }
        };

        timer.start();
    }

    private void restartGame() {
        manager.score = 0;
        manager.level = 1;

        model = new GameModel();
        FoodFactory.createFood(model);

        lastUpdate = 0;
        view.draw(model);
    }

    private void updateGame() {

        model.moveSnake();

        checkWallCollision();
        checkSelfCollision();
        checkFoodCollision();
    }

    private void checkWallCollision() {

        int[] head = model.getHead();

        if(head[0] < 0 || head[0] >= model.width
                || head[1] < 0 || head[1] >= model.height) {

            model.gameOver = true;
        }
    }

    private void checkSelfCollision() {

        int[] head = model.getHead();

        for(int i = 1; i < model.snake.size(); i++) {

            if(head[0] == model.snake.get(i)[0]
                    && head[1] == model.snake.get(i)[1]) {

                model.gameOver = true;
            }
        }
    }

    private void checkFoodCollision() {

        int[] head = model.getHead();

        if(head[0] == model.foodX && head[1] == model.foodY) {

            model.growSnake();
            manager.addScore();

            FoodFactory.createFood(model);
        }
    }

    private double getSpeed() {

        if(manager.level == 1) {
            return 300000000;
        }

        if(manager.level == 2) {
            return 240000000;
        }

        if(manager.level == 3) {
            return 180000000;
        }

        return 140000000;
    }
}