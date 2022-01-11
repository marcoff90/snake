package snakegame.gamelogic;

import snakegame.apple.Apple;
import snakegame.snake.Snake;

public class GameLogic {

  private Snake snake;
  private Apple apple;
  private int moveDirection; // 1 - right, 2 - left, 3 - down, 4 - up
  private int delay;
  private boolean right;
  private boolean left;
  private boolean down;
  private boolean up;
  private boolean gameOver;
  private int screenWidth;
  private int screenHeight;
  private int score;

  public GameLogic(int numberOfObjects, int objectSize, int screenWidth, int screenHeight) {
    snake = new Snake(numberOfObjects, objectSize);
    apple = new Apple();
    apple.generateListOfPoints(screenWidth, screenHeight, objectSize);
    apple.generatePosition();
    this.screenHeight = screenHeight;
    this.screenWidth = screenWidth;
    delay = 175;
    moveDirection = 1;
    gameOver = false;
    score = 0;
  }
  public int getMoveDirection() {

    if (right) {
      moveDirection = 1;
    } else if (left) {
      moveDirection = 2;
    } else if (down) {
      moveDirection = 3;
    } else if (up) {
      moveDirection = 4;
    }
    return moveDirection;
  }

  public void checkApple() {
    if (snake.getSnakeXCoordinates()[0] == apple.getPositionX() && snake.getSnakeYCoordinates()[0] == apple.getPositionY()) {
      apple.generatePosition();
      snake.eatApple();
      score++;
      delay-=10;
    }
  }

  public void checkCollision() {
    if (snake.getSnakeXCoordinates()[0] >= screenWidth || snake.getSnakeXCoordinates()[0] < 25 || snake.getSnakeYCoordinates()[0] > screenHeight + 50
        || snake.getSnakeYCoordinates()[0] < 75) {
      gameOver = true;
      stopMovement();
    }

    for (int i = 1; i < snake.getSnakesLength(); i++) {
      if (snake.getSnakeXCoordinates()[i] == snake.getSnakeXCoordinates()[0] && snake.getSnakeYCoordinates()[i] == snake.getSnakeYCoordinates()[0]) {
        gameOver = true;
        stopMovement();
      }
    }
  }

  private void stopMovement() {
    left = false;
    right = false;
    up = false;
    down = false;
  }

  public Snake getSnake() {
    return snake;
  }

  public Apple getApple() {
    return apple;
  }

  public boolean isGameOver() {
    return gameOver;
  }

  public int getScore() {
    return score;
  }

  public int getDelay() {
    return delay;
  }

  public void setRight(boolean right) {
    this.right = right;
  }

  public void setLeft(boolean left) {
    this.left = left;
  }

  public void setDown(boolean down) {
    this.down = down;
  }

  public void setUp(boolean up) {
    this.up = up;
  }

  public boolean isRight() {
    return right;
  }

  public boolean isLeft() {
    return left;
  }

  public boolean isDown() {
    return down;
  }

  public boolean isUp() {
    return up;
  }
}
