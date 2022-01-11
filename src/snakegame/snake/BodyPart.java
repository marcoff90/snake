package snakegame.snake;

public class BodyPart {

  private int positionX;
  private int positionY;
  private int objectSize;

  public BodyPart(int objectSize) {
    this.objectSize = objectSize;
  }

  public int getPositionX() {
    return positionX;
  }

  public int getPositionY() {
    return positionY;
  }

  public void setPositionX(int positionX) {
    this.positionX = positionX;
  }

  public void setPositionY(int positionY) {
    this.positionY = positionY;
  }
}
