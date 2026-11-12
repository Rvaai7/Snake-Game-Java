package snakegamee.model;

import java.util.ArrayList;

public class GameModel {

    public int width = 20;
    public int height = 20;

    public ArrayList<int[]> snake = new ArrayList<>();

    public int foodX;
    public int foodY;

    public Direction direction = Direction.right;

    public boolean gameOver = false;

    public GameModel() {
        snake.add(new int[]{width / 2, height / 2});
    }

    public int[] getHead() {
        return snake.get(0);
    }

    public void moveSnake() {

        for(int i = snake.size() - 1; i >= 1; i--) {
            snake.get(i)[0] = snake.get(i - 1)[0];
            snake.get(i)[1] = snake.get(i - 1)[1];
        }

        int[] head = getHead();

        if(direction == Direction.up) {
            head[1]--;
        } else if(direction == Direction.down) {
            head[1]++;
        } else if(direction == Direction.left) {
            head[0]--;
        } else if(direction == Direction.right) {
            head[0]++;
        }
    }

    public void growSnake() {
        snake.add(new int[]{-1, -1});
    }
}