
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Espinho extends Objeto {
    public Espinho(JFrame frame, Grade grade, boolean noMapa, int x, int y, int largura, int altura) {
        super(frame, grade, noMapa, x, y, largura, altura);
        colocarImagem("imagens\\espinhos\\espinhos.png");
    }

    @Override
    public Graphics criarQuadrado(Graphics g) {
        Color corAnterior = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(getImagemX(), getImagemY(), getImageLargura(), getImagemAltura());
        g.setColor(corAnterior);
        return g;
    }

    @Override
    public void aoEncostar(Player p, boolean h, boolean v) {
        if ((h || v)) {
            p.setVivo(false);
        }
    }
}
