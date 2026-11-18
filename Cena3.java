import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Cena3 extends Cena {

  private Jogo jogo;
  private JFrame frame;
  private Timer timer;
  private boolean concluida = false;

  private Grade grade;
  private Player player;

  private Plataforma objeto1;
  private Plataforma objeto2;
  private Plataforma objeto3;
  private Plataforma objeto4;
  private Espinho espinho1;
  private ParedeDeEspinhos paredeDeEspinhos1;
  private ParedeDeEspinhos paredeDeEspinhos2;
  private ParedeDeEspinhos paredeDeEspinhos3;
  private Trigger trigger1;
  private Trigger trigger2;
  private boolean esquerda = false;
  private boolean direita = false;
  private Porta porta;

  public Cena3(JFrame frame, Jogo jogo) {
    Random gerador = new Random();
    this.frame = frame;
    this.jogo = jogo;

    grade = new Grade(frame);

    ListaObjetos lista = new ListaObjetos();

    objeto1 = new Plataforma(frame, grade, true, 0, 0, 50, 400);
    objeto2 = new Plataforma(frame, grade, true, 0, 300, 800, 100);
    objeto3 = new Plataforma(frame, grade, true, 0, 0, 800, 50);
    objeto4 = new Plataforma(frame, grade, true, 750, 0, 50, 400);
    paredeDeEspinhos1 = new ParedeDeEspinhos(frame, grade, true, 750, 0, 30, 400, false);
    paredeDeEspinhos2 = new ParedeDeEspinhos(frame, grade, true, 0, 0, 30, 400, false);
    paredeDeEspinhos2.setEsquerda(true);
    paredeDeEspinhos3 = new ParedeDeEspinhos(frame, grade, true, 0, 0, 800, 30, true);
    paredeDeEspinhos3.setBaixo(true);
    trigger1 = new Trigger(frame, grade, true, 400, 0, 50, 300);
    trigger2 = new Trigger(frame, grade, true, 300, 0, 50, 300);
    espinho1 = new Espinho(frame, grade, true, 750, 270, 15, 7);
    porta = new Porta(frame, grade, true, 650, 225, 50, 75);
    espinho1.colocarImagem(
        "C:\\Users\\Kauã Davi Wüst\\OneDrive\\Desktop\\projeto prog2\\imagens\\espinhos\\espinho-lateral-direita.png");

    player = new Player(frame, lista, grade, true, 350, 240, 20, 30);
    timer = new Timer(30, e -> {

      player.playerUpdate();

      if (!player.isVivo()) {
        timer.stop();

        jogo.reiniciarFase();

        return;
      }

      if (porta != null && porta.isEncostou()) {
        timer.stop();
        jogo.proximaFase();
        return;
      }

      paredeDeEspinhos3.moveY(1);

      if (trigger2.isAtivou()) {
        this.esquerda = true;
      }
      if (trigger1.isAtivou()) {
        this.direita = true;
      }
      if (esquerda) {
        paredeDeEspinhos2.moveX(5);
      }
      if (direita) {
        paredeDeEspinhos1.moveX(-5);
      }
      porta.setAreaX(frame.getWidth() - 100);

      repaint();
    });

    timer.start();
  }

  @Override
  public Graphics desenhar(Graphics g) {
    porta.criarImagem(g);
    paredeDeEspinhos1.criarImagem(g);
    paredeDeEspinhos2.criarImagem(g);
    paredeDeEspinhos3.criarImagem(g);
    espinho1.criarImagem(g);
    objeto1.criarQuadrado(g);
    objeto2.criarQuadrado(g);
    objeto3.criarQuadrado(g);
    objeto4.criarQuadrado(g);
    player.criarImagem(g);

    return g;
  }

  @Override
  public boolean cenaConcluida() {
    return concluida;
  }
}
