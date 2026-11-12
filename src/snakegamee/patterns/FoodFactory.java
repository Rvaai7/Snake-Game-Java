package snakegamee.patterns;

import snakegamee.model.GameModel;

import java.util.Random;

public class FoodFactory {

    public static void createFood(GameModel model) {

        Random random = new Random();

        while(true) {

            int x = random.nextInt(model.width);
            int y = random.nextInt(model.height);

            boolean onSnake = false;

            for(int[] part : model.snake) {
                if(part[0] == x && part[1] == y) {
                    onSnake = true;
                    break;
                }
            }

            if(!onSnake) {
                model.foodX = x;
                model.foodY = y;
                break;
            }
        }
    }
}