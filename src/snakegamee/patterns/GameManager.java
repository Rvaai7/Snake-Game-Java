package snakegamee.patterns;

import java.io.*;

public class GameManager {

    private static GameManager instance;

    public int score = 0;
    public int level = 1;
    public int highScore = 0;

    private String fileName = "highscore.txt";

    private GameManager() {
        highScore = loadHighScore();
    }

    public static GameManager getInstance() {

        if(instance == null) {
            instance = new GameManager();
        }

        return instance;
    }

    public void addScore() {
        score++;

        if(score >= 5) {
            level = 2;
        }

        if(score >= 10) {
            level = 3;
        }

        if(score >= 15) {
            level = 4;
        }
    }

    public void saveHighScore() {

        if(score > highScore) {
            highScore = score;
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(String.valueOf(highScore));
            writer.close();

        } catch(Exception e) {
            System.out.println("Error saving high score");
        }
    }

    public int loadHighScore() {

        try {
            File file = new File(fileName);

            if(!file.exists()) {
                return 0;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int savedScore = Integer.parseInt(reader.readLine());
            reader.close();

            return savedScore;

        } catch(Exception e) {
            return 0;
        }
    }
}