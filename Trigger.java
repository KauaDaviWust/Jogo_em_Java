
import javax.swing.JFrame;

public class Trigger extends Objeto {
  private boolean ativou = false;

  public Trigger(JFrame frame, Grade grade, boolean noMapa, int x, int y, int Largura, int Altura) {
    super(frame, grade, noMapa, x, y, Largura, Altura);
  }

  public boolean isAtivou() {
    return ativou;
  }

  public void setAtivou(boolean ativou) {
    this.ativou = ativou;
  }

  @Override
  public void aoEncostar(Player p, boolean h, boolean v) {
    if (h || v) {
      this.setAtivou(true);
    } else {
      this.setAtivou(false);
    }

  }

}
