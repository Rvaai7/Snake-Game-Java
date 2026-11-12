package snakegamee.view;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import snakegamee.model.GameModel;
import snakegamee.patterns.GameManager;

public class GameView {

    public Canvas canvas;
    private GraphicsContext gc;

    private int cornerSize = 25;

    public GameView(GameModel model) {
        canvas = new Canvas(model.width * cornerSize, model.height * cornerSize);
        gc = canvas.getGraphicsContext2D();
    }

    public void draw(GameModel model) {

        GameManager manager = GameManager.getInstance();

        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, model.width * cornerSize, model.height * cornerSize);

        gc.setFill(Color.WHITE);
        gc.fillText("Score: " + manager.score, 10, 20);
        gc.fillText("Level: " + manager.level, 10, 40);
        gc.fillText("High Score: " + manager.highScore, 10, 60);

        gc.setFill(Color.LIGHTBLUE);
        gc.fillOval(
                model.foodX * cornerSize,
                model.foodY * cornerSize,
                cornerSize,
                cornerSize
        );

        gc.setFill(Color.PINK);

        for(int[] part : model.snake) {
            gc.fillRect(
                    part[0] * cornerSize,
                    part[1] * cornerSize,
                    cornerSize - 1,
                    cornerSize - 1
            );
        }
    }

    public void drawGameOver() {

        GameManager manager = GameManager.getInstance();

        gc.setFill(Color.RED);
        gc.fillText("GAME OVER, Please Press ( R ) to reset the game", 200, 240);
        gc.setFill(Color.WHITE);
        gc.fillText("Score: " + manager.score, 210, 270);
        gc.fillText("High Score: " + manager.highScore, 190, 300);
    }
}