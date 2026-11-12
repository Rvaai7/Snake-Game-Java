# 🐍 Snake Game | JavaFX

A Snake Game developed using **Java and JavaFX** as an academic programming project.

The project demonstrates fundamental programming concepts, Object-Oriented Programming (OOP), MVC architecture, and software design patterns.

## 🎮 Game Features

- Control the snake using keyboard arrow keys.
- Collect food to increase the score.
- Avoid collisions with walls and the snake's body.
- Progress through levels as the score increases.
- Experience increasing snake speed at higher levels.
- Track the current score, level, and high score.
- Save and load the high score between game sessions.

## 🛠️ Technologies Used

- **Java** – Core programming language.
- **JavaFX** – Graphical User Interface (GUI).
- **MVC Architecture** – Separation of application responsibilities.
- **Design Patterns** – Singleton and Factory.
- **File Handling** – Persistent high-score storage.

## 🏗️ MVC Architecture

The project follows the **Model-View-Controller (MVC)** architecture to organize the application into three components.

### Model – GameModel
Stores and manages game data, including:
- Snake position
- Food position
- Movement direction
- Game status

### View – GameView
Responsible for displaying:
- Snake and food
- Game screen
- Current score
- Game level
- Game-over message

### Controller – GameController
Handles:
- Game logic
- Keyboard input
- Snake movement
- Collision detection
- Level progression

## 🧩 Design Patterns

### 1. Singleton Pattern
Implemented in `GameManager` to manage the score, level, and high score through a single shared instance.

### 2. Factory Pattern
Implemented in `FoodFactory` to generate food at random positions while ensuring the food does not appear inside the snake's body.

## 💾 Persistent Data

The game stores the highest score in a text file named `highscore.txt`.

- The previous high score is loaded when the game starts.
- The score is updated during gameplay.
- When the game ends, the new high score is saved if it exceeds the previous record.

## 🎯 Learning Outcomes

Through this project, I gained practical experience in:

- Java and JavaFX development
- Object-Oriented Programming
- MVC software architecture
- Implementing design patterns
- Event handling and game logic
- File handling and data persistence
- Problem-solving and debugging

## 👩‍💻 Developed By

**Rahaf Alnadwi**

Computer Science Student

Academic Programming Project
