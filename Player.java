import java.io.File;
import javax.swing.JFrame;

public class Player extends Objeto {
    private boolean vivo = true;
    private Colisao colisao = new Colisao();
    private Movimento m = new Movimento();
    private boolean podepular = true;
    private int deslocamentoY = 0;
    private ListaObjetos lista;
    private boolean colSolH;
    private boolean colSolV;
    private int numinagem = 0;
    private boolean dirDireita = true;
    private File[] moveDireita = new File("imagens\\player\\direita").listFiles();
    private File[] moveEsquerda = new File("imagens\\player\\esquerda").listFiles();

    public Player(JFrame frame, ListaObjetos lista, Grade grade, boolean noMapa, int x, int y,
            int largura, int altura) {
        super(frame, grade, noMapa, x, y, largura, altura);
        this.lista = lista;

        playerUpdate();
    }

    public void playerUpdate() {
        if (dirDireita) {
            this.colocarImagem(moveDireita[numinagem].getAbsolutePath());
        } else {
            this.colocarImagem(moveEsquerda[numinagem].getAbsolutePath());
        }
        // Negativo = Esquerda
        // Positivo = Direita
        int deslocamentoX = 0;

        // Negativo = Cima
        // Positivo = Baixo

        lista.objetosPerto(this, grade);
        m.teclas(frame, this);
        if (m.isDireita() && !m.isEsquerda()) {
            this.numinagem++;
            if (numinagem > 7) {
                this.numinagem = 0;
            }
            deslocamentoX = 5;
            this.dirDireita = true;
        }

        else if (m.isEsquerda() && !m.isDireita()) {
            this.numinagem++;
            if (numinagem > 7) {
                this.numinagem = 0;
            }
            deslocamentoX = -5;
            this.dirDireita = false;

        } else {
            this.numinagem = 0;
        }

        if (!colSolV || colSolH) {
            this.numinagem = 0;
        }

        if (m.isCima() && podepular) {
            deslocamentoY = -12;
            podepular = false;
        }

        colSolH = false;
        colSolV = false;

        for (Objeto objeto : lista.getObjetos()) {
            boolean colidiuH = false;
            boolean colidiuV = false;
            if (colisao.colidiuHorizontal(this.getAreaX(), this.getAreaY(), this.getAreaLargura(),
                    this.getAreaAltura(), deslocamentoX, objeto.getArea())) {
                colidiuH = true;

            }
            if (colisao.colidiuVertical(this.getAreaX(), this.getAreaY(), this.getAreaLargura(),
                    this.getAreaAltura(), deslocamentoY, objeto.getArea())) {
                colidiuV = true;

            }

            objeto.aoEncostar(this, colidiuH, colidiuV);
        }
        if (this.getAreaY() > 350) {
            this.vivo = false;
        }

        if (!colSolH) {
            moveX(deslocamentoX);

        }

        if (!colSolV) {
            if (deslocamentoY < 15) {
                deslocamentoY++;
            }
            moveY(deslocamentoY);
        }

    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    @Override
    public void aoEncostar(Player p, boolean h, boolean v) {

    }

    public boolean isPodepular() {
        return podepular;
    }

    public void setPodepular(boolean podepular) {
        this.podepular = podepular;
    }

    public int getDeslocamentoY() {
        return deslocamentoY;
    }

    public void setDeslocamentoY(int deslocamentoY) {
        this.deslocamentoY = deslocamentoY;
    }

    public boolean isColSolH() {
        return colSolH;
    }

    public void setColSolH(boolean colSolH) {
        this.colSolH = colSolH;
    }

    public boolean isColSolV() {
        return colSolV;
    }

    public void setColSolV(boolean colSolV) {
        this.colSolV = colSolV;
    }

    public File[] getMoveDireita() {
        return moveDireita;
    }

    public void setMoveDireita(File[] moveDireita) {
        this.moveDireita = moveDireita;
    }

    public File[] getMoveEsquerda() {
        return moveEsquerda;
    }

    public void setMoveEsquerda(File[] moveEsquerda) {
        this.moveEsquerda = moveEsquerda;
    }
}