import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Cena2 extends Cena {

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
  private boolean moveEspinho;
  private Plataforma plataforma1;
  private Plataforma plataforma2;
  private Plataforma plataforma3;
  private Plataforma plataforma4;

  private Trigger trigger1;

  private Porta porta;

  public Cena2(JFrame frame, Jogo jogo) {
    Random gerador = new Random();
    this.frame = frame;
    this.jogo = jogo;

    grade = new Grade(frame);

    ListaObjetos lista = new ListaObjetos();

    objeto1 = new Plataforma(frame, grade, true, 0, 0, 50, 400);
    objeto2 = new Plataforma(frame, grade, true, 0, 300, 800, 100);
    objeto3 = new Plataforma(frame, grade, true, 0, 0, 800, 50);
    objeto4 = new Plataforma(frame, grade, true, 750, 0, 50, 400);
    plataforma1 = new Plataforma(frame, grade, true, 150, 250, 50, 10);
    plataforma2 = new Plataforma(frame, grade, true, 300, 250, 50, 10);
    plataforma3 = new Plataforma(frame, grade, true, 450, 250, 50, 10);
    plataforma4 = new Plataforma(frame, grade, true, 600, 250, 50, 10);
    paredeDeEspinhos1 = new ParedeDeEspinhos(frame, grade, true, 750, 50, 15, 250, false);
    paredeDeEspinhos2 = new ParedeDeEspinhos(frame, grade, true, 100, 350, 450, 15, true);
    trigger1 = new Trigger(frame, grade, true, 650, 225, 50, 75);
    trigger1.colocarImagem("C:\\Users\\Kauã Davi Wüst\\OneDrive\\Desktop\\projeto prog2\\imagens\\porta.png");
    espinho1 = new Espinho(frame, grade, true, 750, 270, 15, 7);
    espinho1.colocarImagem(
        "C:\\Users\\Kauã Davi Wüst\\OneDrive\\Desktop\\projeto prog2\\imagens\\espinhos\\espinho-lateral-direita.png");

    player = new Player(frame, lista, grade, true, 51, 240, 20, 30);
    this.moveEspinho = true;
    timer = new Timer(30, e -> {

      if (moveEspinho) {
        espinho1.moveX(-10);
      } else {
        espinho1.setAreaX(750);
        paredeDeEspinhos1.moveX(-5);
      }
      if (espinho1.getAreaX() < 0) {
        espinho1.setAreaY(gerador.nextInt((285 - 225) + 1) + 225);
        espinho1.setAreaX(750);
      }

      player.playerUpdate();

      if (!player.isVivo()) {
        timer.stop();

        jogo.reiniciarFase();

        return;
      }

      if (trigger1.isAtivou()) {
        trigger1.setAreaAltura(0);
        trigger1.setAreaLargura(0);
        if (porta == null) {
          porta = new Porta(frame, grade, true, 50, 225, 50, 75);
          paredeDeEspinhos2.moveY(-65);
        }
        moveEspinho = false;

      }

      if (porta != null && porta.isEncostou()) {
        timer.stop();
        jogo.proximaFase();
        return;
      }

      repaint();
    });

    timer.start();
  }

  @Override
  public Graphics desenhar(Graphics g) {
    if (porta != null) {
      porta.criarImagem(g);
    }
    paredeDeEspinhos1.criarImagem(g);
    paredeDeEspinhos2.criarImagem(g);
    trigger1.criarImagem(g);
    espinho1.criarImagem(g);
    objeto1.criarQuadrado(g);
    objeto2.criarQuadrado(g);
    objeto3.criarQuadrado(g);
    objeto4.criarQuadrado(g);
    plataforma1.criarQuadrado(g);
    plataforma2.criarQuadrado(g);
    plataforma3.criarQuadrado(g);
    plataforma4.criarQuadrado(g);

    player.criarImagem(g);
    return g;
  }

  @Override
  public boolean cenaConcluida() {
    return concluida;
  }
}
