
import javax.swing.JFrame;

public class Plataforma extends Objeto {

  public Plataforma(JFrame frame, Grade grade, boolean noMapa, int x, int y, int largura, int altura) {
    super(frame, grade, noMapa, x, y, largura, altura);

  }

  @Override
  public void aoEncostar(Player p, boolean h, boolean v) {
    if (v) {
      p.setColSolV(true);
      if (p.getAreaY() < this.getAreaY()) {
        p.moveY(this.getAreaY() - (p.getAreaY() + p.getAreaAltura()));
        p.setPodepular(true);
      } else if (p.getAreaY() > this.getAreaY()) {
        p.setDeslocamentoY(0);
        p.moveY((this.getAreaY() + this.getAreaAltura()) - p.getAreaY());
      }
    }
    if (h) {
      p.setColSolH(h);
      // this na direita
      if (p.getAreaX() < this.getAreaX()) {
        p.moveX(this.getAreaX() - (p.getAreaX() + p.getAreaLargura()));
      } else if (p.getAreaX() > this.getAreaX()) {
        p.moveX((this.getAreaX() + this.getAreaLargura()) - p.getAreaX());
      }
    }
  }

}
