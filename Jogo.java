import javax.swing.JFrame;

public class Jogo {

  private JFrame frame;
  private int numFase = 0;

  public Jogo() {

    frame = new JFrame("Tela");
    frame.setSize(800, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    iniciarFase();

    frame.setVisible(true);
  }

  public void iniciarFase() {

    Cena cenaAtual = null;

    if (numFase == 0) {
      cenaAtual = new Cena1(frame, this);
    }

    else if (numFase == 1) {
      cenaAtual = new Cena2(frame, this);
    }

    else if (numFase == 2) {
      cenaAtual = new Cena3(frame, this);
    }

    frame.setContentPane(cenaAtual);
    frame.revalidate();
    frame.repaint();
  }

  public void proximaFase() {
    numFase++;
    if (numFase > 2) {
      frame.dispose();
      return;
    }
    iniciarFase();
  }

  public void reiniciarFase() {
    iniciarFase();
  }

  public static void main(String[] args) {
    new Jogo();
  }
}