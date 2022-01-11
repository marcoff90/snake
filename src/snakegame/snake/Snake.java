package snakegame.snake;

import java.awt.Graphics;
import javax.swing.*;

public class Snake {

  private int[] snakeXCoordinates;
  private int[] snakeYCoordinates;
  private ImageIcon rightMouth;
  private ImageIcon leftMouth;
  private ImageIcon upMouth;
  private ImageIcon downMouth;
  private ImageIcon snakeBody;
  private int snakesLength;
  private int objectSize;

  public Snake(int numberOfObjects, int objectSize) {  // screenwidht * screenhight / object size
    this.objectSize = objectSize;
    snakeXCoordinates = new int[numberOfObjects];
    snakeYCoordinates = new int[numberOfObjects];
    snakesLength = 3;
    rightMouth = new ImageIcon("img/rightmouth.png");
    leftMouth = new ImageIcon("img/leftmouth.png");
    upMouth = new ImageIcon("img/upmouth.png");
    downMouth = new ImageIcon("img/downmouth.png");
    snakeBody = new ImageIcon("img/snakeimage.png");
    startingPosition();
  }

  public void startingPosition() {
    snakeXCoordinates[2] = 50;    // generates starting position where the new snake is painted
    snakeXCoordinates[1] = 75;
    snakeXCoordinates[0] = 100;
    snakeYCoordinates[2] = 100;
    snakeYCoordinates[1] = 100;
    snakeYCoordinates[0] = 100;
  }

  public void moveRight() {
    for (int i = snakesLength - 1; i >= 0; i--) {
      snakeYCoordinates[i + 1] = snakeYCoordinates[i]; // changing position of head to it's next index
    }
    for (int i = snakesLength; i >= 0; i--) {
      if (i == 0) {
        snakeXCoordinates[i] = snakeXCoordinates[i] + objectSize;   // changes coordinates of the head
      } else {
        snakeXCoordinates[i] = snakeXCoordinates[i - 1];    //sets the coordinates of the previous part to the current one which creates the movement
      }
    }
  }

  public void moveLeft() {
    for (int i = snakesLength - 1; i >= 0; i--) {
      snakeYCoordinates[i + 1] = snakeYCoordinates[i];
    }
    for (int i = snakesLength; i >= 0; i--) {
      if (i == 0) {
        snakeXCoordinates[i] = snakeXCoordinates[i] - objectSize;
      } else {
        snakeXCoordinates[i] = snakeXCoordinates[i - 1];
      }
    }
  }

  public void moveUp() {
    for (int i = snakesLength - 1; i >= 0; i--) {
      snakeXCoordinates[i + 1] = snakeXCoordinates[i];
    }
    for (int i = snakesLength; i >= 0; i--) {
      if (i == 0) {
        snakeYCoordinates[i] = snakeYCoordinates[i] - 25;
      } else {
        snakeYCoordinates[i] = snakeYCoordinates[i - 1];
      }
    }
  }

  public void moveDown() {
    for (int i = snakesLength - 1; i >= 0; i--) {
      snakeXCoordinates[i + 1] = snakeXCoordinates[i];
    }
    for (int i = snakesLength; i >= 0; i--) {
      if (i == 0) {
        snakeYCoordinates[i] = snakeYCoordinates[i] + 25;
      } else {
        snakeYCoordinates[i] = snakeYCoordinates[i - 1];
      }
    }
  }

  public void paintSnake(JPanel panel, Graphics graphics, int moveDirection) {
    for (int i = 0; i < snakesLength; i++) {
      if (i == 0) {
        switch (moveDirection) {
          case 1 -> rightMouth.paintIcon(panel, graphics, snakeXCoordinates[i], snakeYCoordinates[i]);
          case 2 -> leftMouth.paintIcon(panel, graphics, snakeXCoordinates[i], snakeYCoordinates[i]);
          case 3 -> downMouth.paintIcon(panel, graphics, snakeXCoordinates[i], snakeYCoordinates[i]);
          case 4 -> upMouth.paintIcon(panel, graphics, snakeXCoordinates[i], snakeYCoordinates[i]);
        }
      } else {
        snakeBody.paintIcon(panel, graphics, snakeXCoordinates[i], snakeYCoordinates[i]);
      }
    }
  }

  public void eatApple() {
    this.snakesLength++;
  }

  public int getSnakesLength() {
    return snakesLength;
  }

  public int[] getSnakeXCoordinates() {
    return snakeXCoordinates;
  }

  public int[] getSnakeYCoordinates() {
    return snakeYCoordinates;
  }
}