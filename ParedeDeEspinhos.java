import java.awt.Graphics;
import javax.swing.JFrame;

public class ParedeDeEspinhos extends Objeto {

  private int tamanhoEspinho = 30;
  private boolean horizontal;
  private boolean baixo;
  private boolean esquerda;

  public ParedeDeEspinhos(JFrame frame,
      Grade grade,
      boolean noMapa,
      int x,
      int y,
      int largura,
      int altura,
      boolean horizontal) {

    super(frame, grade, noMapa, x, y, largura, altura);

    this.horizontal = horizontal;

    colocarImagem(
        "imagens\\espinhos\\espinhos.png");
    if (!horizontal) {
      colocarImagem(
          "imagens\\espinhos\\espinhos-lateral-direita.png");
    }
  }

  @Override
  public Graphics criarImagem(Graphics g) {

    if (horizontal) {
      if (baixo) {
        colocarImagem(
            "imagens\\espinhos\\espinhos-baixo.png");

      }
      // espinhos lado a lado
      for (int i = 0; i < getAreaLargura(); i += tamanhoEspinho) {

        g.drawImage(
            getImagem().getImage(),
            getAreaX() + i,
            getAreaY(),
            tamanhoEspinho,
            getAreaAltura(),
            null);
      }

    } else {
      if (esquerda) {
        this.colocarImagem(
            "imagens\\espinhos\\espinhos-lateral-esquerda.png");
      }
      // espinhos um embaixo do outro
      for (int i = 0; i < getAreaAltura(); i += tamanhoEspinho) {

        g.drawImage(
            getImagem().getImage(),
            getAreaX(),
            getAreaY() + i,
            getAreaLargura(),
            tamanhoEspinho,
            null);
      }
    }

    return g;
  }

  @Override
  public void aoEncostar(Player p, boolean h, boolean v) {

    if (h || v) {
      p.setVivo(false);
    }
  }

  public boolean isBaixo() {
    return baixo;
  }

  public void setBaixo(boolean baixo) {
    this.baixo = baixo;
  }

  public boolean isEsquerda() {
    return esquerda;
  }

  public void setEsquerda(boolean esquerda) {
    this.esquerda = esquerda;
  }
}