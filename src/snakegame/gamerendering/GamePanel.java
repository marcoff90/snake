package snakegame.gamerendering;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import snakegame.gamelogic.GameLogic;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

  private static final int SCREEN_WIDTH = 850;
  private static final int SCREEN_HEIGHT = 575;
  private static final int OBJECT_SIZE = 25;
  private static final int NUMBER_OF_OBJECTS = (SCREEN_WIDTH * SCREEN_HEIGHT) / OBJECT_SIZE;
  private GameLogic gameLogic;
  private Timer timer;

  public GamePanel() {
    this.gameLogic = new GameLogic(NUMBER_OF_OBJECTS, OBJECT_SIZE, SCREEN_WIDTH, SCREEN_HEIGHT);
    addKeyListener(this);
    this.setFocusable(true);
    this.setFocusTraversalKeysEnabled(false);
    timer = new Timer(gameLogic.getDelay(), this);
    timer.start();
  }

  public void paint(Graphics graphics) {
    gameLogic.checkCollision();
    paintGameBase(graphics);
    paintSnake(graphics);
    gameLogic.checkApple();
    paintApple(graphics);
  }

  public void paintGameBase(Graphics graphics) {
    graphics.setColor(Color.WHITE);
    graphics.drawRect(24, 10, 851, 55);

    ImageIcon titleImage = new ImageIcon("img/snaketitle.jpg");
    titleImage.paintIcon(this, graphics, 25, 11);

    graphics.setColor(Color.BLACK);
    graphics.fillRect(25, 75, SCREEN_WIDTH, SCREEN_HEIGHT);

    graphics.setColor(Color.WHITE);
    graphics.setFont(new Font("Arial", Font.PLAIN, 14));
    graphics.drawString("Score: " + gameLogic.getScore(), 780, 30);

    if (gameLogic.isGameOver()) {
      graphics.setColor(Color.RED);
      graphics.setFont(new Font("Arial", Font.BOLD, 60));
      graphics.drawString("Game Over Dude!", 200, 300);
      graphics.setColor(Color.WHITE);
      graphics.setFont(new Font("Arial", Font.BOLD, 30));
      graphics.drawString("Press space for new game", 250,340);
    }
  }

  public void paintSnake(Graphics graphics) {
    if (!gameLogic.isGameOver()) {
      gameLogic.getSnake().paintSnake(this, graphics, gameLogic.getMoveDirection());
    }
  }

  public void paintApple(Graphics graphics) {
    gameLogic.getApple().paintApple(this, graphics);
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_RIGHT -> {   // after each movement setting the other directins to false in odred to be able to move and "bite itself"
        gameLogic.setRight(true);
        gameLogic.setLeft(false);
        gameLogic.setUp(false);
        gameLogic.setDown(false);
      }
      case KeyEvent.VK_LEFT -> {
        gameLogic.setLeft(true);
        gameLogic.setRight(false);
        gameLogic.setUp(false);
        gameLogic.setDown(false);
      }
      case KeyEvent.VK_DOWN -> {
        gameLogic.setLeft(false);
        gameLogic.setRight(false);
        gameLogic.setUp(false);
        gameLogic.setDown(true);
      }
      case KeyEvent.VK_UP -> {
        gameLogic.setLeft(false);
        gameLogic.setRight(false);
        gameLogic.setUp(true);
        gameLogic.setDown(false);
      }
      case KeyEvent.VK_SPACE -> {
        gameLogic = new GameLogic(NUMBER_OF_OBJECTS, OBJECT_SIZE, SCREEN_WIDTH, SCREEN_HEIGHT);
      }
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (gameLogic.isRight()) {
      gameLogic.getSnake().moveRight();
    } else if (gameLogic.isLeft()) {
      gameLogic.getSnake().moveLeft();
    } else if (gameLogic.isDown()) {
      gameLogic.getSnake().moveDown();
    } else if (gameLogic.isUp()) {
      gameLogic.getSnake().moveUp();
    }
    repaint();
  }
}