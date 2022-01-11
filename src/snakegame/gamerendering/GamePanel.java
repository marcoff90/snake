package snakegame.gamerendering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import snakegame.snake.Snake;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

  private static final int SCREEN_SIZE = 600;
  private Snake snake;

  private int moveType;

  public GamePanel() {
    this.setBackground(Color.BLACK);
    this.setPreferredSize(new Dimension(SCREEN_SIZE, SCREEN_SIZE));
    this.setFocusable(true);
    this.snake = new Snake(20);
    Timer timer = new Timer(1000, this);
    timer.start();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.WHITE);
    for (int i = 0; i < SCREEN_SIZE / 20; i++) {
      g.drawLine(20 * i, 0, 20 * i, SCREEN_SIZE);
      g.drawLine(0, 20 * i, SCREEN_SIZE, 20 * i);
    }
    drawSnake(g);
  }

  private void draw(Graphics graphics) {

  }

  private void drawSnake(Graphics graphics) {
    for (int i = 0; i < snake.getSnakesBody().size(); i++) {
      graphics.setColor(Color.GREEN);
      graphics.fillRect(snake.getSnakesBody().get(i).getPositionX(), snake.getSnakesBody().get(i).getPositionY(), 20, 20);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    snake.moveDown();
    repaint();
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      moveType = 4;
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      moveType = 3;
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      moveType = 1;
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      moveType = 2;
    }
  }
}
