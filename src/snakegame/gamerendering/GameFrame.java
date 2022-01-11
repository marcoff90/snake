package snakegame.gamerendering;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

  public GameFrame() {
    this.add(new GamePanel());
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Snake");
    this.setResizable(false);
    this.pack();
  }
}
