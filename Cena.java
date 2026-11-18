import java.awt.Graphics;
import javax.swing.JPanel;

public abstract class Cena extends JPanel {
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    desenhar(g);
  }

  public abstract Graphics desenhar(Graphics g);

  public abstract boolean cenaConcluida();
}
