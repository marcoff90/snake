package snakegame.gamerendering;

import java.awt.Color;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

  public GameFrame() {
    this.add(new GamePanel());
    this.setBounds(10, 10, 905, 705);
    this.setBackground(Color.DARK_GRAY);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Snake");
    this.setResizable(false);
  }
}
