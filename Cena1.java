import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Cena1 extends Cena {

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
    private Plataforma objeto5;

    private Trigger trigger1;
    private Trigger trigger2;
    private Espinho espinhos1;
    private Espinho espinhos2;

    private Porta porta;

    public Cena1(JFrame frame, Jogo jogo) {

        this.frame = frame;
        this.jogo = jogo;

        grade = new Grade(frame);

        ListaObjetos lista = new ListaObjetos();

        objeto1 = new Plataforma(frame, grade, true, 0, 0, 50, 400);
        objeto2 = new Plataforma(frame, grade, true, 0, 300, 450, 100);
        objeto5 = new Plataforma(frame, grade, true, 450, 300, 350, 100);
        objeto3 = new Plataforma(frame, grade, true, 0, 0, 800, 50);
        objeto4 = new Plataforma(frame, grade, true, 750, 0, 50, 400);

        trigger1 = new Trigger(frame, grade, true, 400, 185, 50, 100);
        trigger2 = new Trigger(frame, grade, true, 200, 285, 0, 0);

        espinhos1 = new Espinho(frame, grade, true, 170, 285, 50, 15);
        espinhos2 = new Espinho(frame, grade, true, 400, 285, 50, 15);

        porta = new Porta(frame, grade, true, 650, 225, 50, 75);

        player = new Player(frame, lista, grade, true, 51, 240, 20, 30);

        timer = new Timer(30, e -> {

            player.playerUpdate();

            if (!player.isVivo()) {
                timer.stop();

                jogo.reiniciarFase();

                return;
            }

            if (trigger1.isAtivou()) {
                objeto5.setAreaLargura(150);
                objeto5.setAreaX(650);

                trigger1.setAreaAltura(0);
                trigger1.setAreaLargura(0);
                trigger2.setAreaAltura(15);
                trigger2.setAreaLargura(200);
            }

            if (trigger2.isAtivou()) {
                objeto5.setAreaX(450);
                objeto5.setAreaLargura(350);
                trigger2.setAreaAltura(0);
                trigger2.setAreaLargura(0);
            }

            if (porta.isEncostou()) {
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
        grade.desenharGrade(g);
        objeto1.criarQuadrado(g);
        objeto2.criarQuadrado(g);
        objeto3.criarQuadrado(g);
        objeto4.criarQuadrado(g);
        objeto5.criarQuadrado(g);
        espinhos1.criarImagem(g);
        espinhos2.criarImagem(g);

        porta.criarImagem(g);

        player.criarImagem(g);
        return g;
    }

    @Override
    public boolean cenaConcluida() {
        System.out.println(concluida);
        return concluida;
    }
}