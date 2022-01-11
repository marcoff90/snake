package snakegame.snake;

import java.util.ArrayList;
import java.util.List;

public class Snake {

  private List<BodyPart> snakesBody;
  private int size;
  private int objectSize;

  public Snake(int objectSize) {
    this.size = 6;
    this.snakesBody = new ArrayList<>();
    this.objectSize = objectSize;
    makeSnake();
  }

  private void makeSnake() {
    for (int i = 0; i < size; i++) {            // adds starting bodyparts
      snakesBody.add(new BodyPart(objectSize));
    }

    for (int i = snakesBody.size() - 1; i >= 0 ; i--) {   // adds starting coordinates to each body part
      snakesBody.get(i).setPositionX(i * objectSize);
    }
  }

  public void move() {
    for (int i = snakesBody.size() - 1; i >= 0 ; i--) {
      snakesBody.get(i).setPositionX(snakesBody.get(i).getPositionX() + objectSize);
    }
  }

  public List<BodyPart> getSnakesBody() {
    return snakesBody;
  }
}
