
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Movimento {
  private boolean direita = false;
  private boolean esquerda = false;
  private boolean cima = false;
  private boolean baixo = false;

  public void teclas(JFrame frame, Objeto objeto) {

    frame.addKeyListener(new KeyListener() {

      @Override
      public void keyTyped(KeyEvent e) {
      }

      @Override
      public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_D -> setDireita(true);
            case KeyEvent.VK_A -> setEsquerda(true);
            case KeyEvent.VK_S -> setBaixo(true);
            case KeyEvent.VK_SPACE -> setCima(true);
        }


      }

      @Override
      public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_D -> setDireita(false);
            case KeyEvent.VK_A -> setEsquerda(false);
            case KeyEvent.VK_S -> setBaixo(false);
            case KeyEvent.VK_SPACE -> setCima(false);
        }
      }

    });

  }

    public boolean isDireita() {
        return direita;
    }

    public void setDireita(boolean direita) {
        this.direita = direita;
    }

    public boolean isEsquerda() {
        return esquerda;
    }

    public void setEsquerda(boolean esquerda) {
        this.esquerda = esquerda;
    }

    public boolean isCima() {
        return cima;
    }

    public void setCima(boolean cima) {
        this.cima = cima;
    }

    public boolean isBaixo() {
        return baixo;
    }

    public void setBaixo(boolean baixo) {
        this.baixo = baixo;
    }


}
