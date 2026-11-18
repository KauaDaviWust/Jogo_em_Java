
import javax.swing.JFrame;

public class Porta extends Objeto {
    private boolean encostou;

    public Porta(JFrame frame, Grade grade, boolean noMapa, int x, int y, int largura, int altura) {
        super(frame, grade, noMapa, x, y, largura, altura);
        colocarImagem("imagens\\porta.png");
    }

    @Override
    public void aoEncostar(Player p, boolean h, boolean v) {
        if (h || v) {
            this.encostou = true;
        }

    }

    public boolean isEncostou() {
        return encostou;
    }

    public void setEncostou(boolean encostou) {
        this.encostou = encostou;
    }

}
