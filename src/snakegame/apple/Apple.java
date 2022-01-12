package snakegame.apple;

import java.awt.Graphics;
import java.util.*;
import javax.swing.*;

public class Apple {

  private int positionY;
  private int positionX;
  private ImageIcon appleImage;
  private List<Integer> xCoordinates;
  private List<Integer> yCoordinates;

  public Apple() {
    appleImage = new ImageIcon("img/apple.png");
    xCoordinates = new ArrayList<>();
    yCoordinates = new ArrayList<>();
  }

  public void generateListOfPoints(int screenWidth, int screenHeight, int objectSize) {
    for (int i = 1; i < screenWidth / objectSize; i++) {  // the number of possible x/y positions is width/height divided by object size
      xCoordinates.add(i * objectSize);         // adding object size * i to the list in order to generate a random position for the apple
    }
    for (int i = 3; i < screenHeight / objectSize; i++) {
      yCoordinates.add(i * objectSize);
    }
  }

  public void generatePosition() {
    Random rand = new Random();
    int xRand = rand.nextInt(xCoordinates.size());
    positionX = xCoordinates.get(xRand);
    int yRand = rand.nextInt(yCoordinates.size());
    positionY = yCoordinates.get(yRand);
  }

  public void paintApple(JPanel panel, Graphics graphics) {
    appleImage.paintIcon(panel, graphics, positionX, positionY);
  }

  public int getPositionY() {
    return positionY;
  }

  public int getPositionX() {
    return positionX;
  }
}
