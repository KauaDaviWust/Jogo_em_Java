import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Grade {

  private ArrayList<Objeto>[][] grade;

  public Grade(JFrame frame) {
    this.grade = new ArrayList[frame.getHeight() / 50][frame.getWidth() / 50];

    // inicializa todas as células
    for (int i = 0; i < grade.length; i++) {
      for (int j = 0; j < grade[i].length; j++) {
        grade[i][j] = new ArrayList<>();
      }
    }
  }

  public void adicionar(Objeto objeto, int x, int y) {

    // evita sair fora da matriz
    if (x < 0 || x >= grade.length || y < 0 || y >= grade[0].length) {
      return;
    }

    // evita duplicar objeto na mesma célula
    if (!grade[x][y].contains(objeto)) {
      grade[x][y].add(objeto);
    }
  }

  public void remover(Objeto objeto, int x, int y) {
    if (x < 0 || x >= grade.length || y < 0 || y >= grade[0].length) {
      return;
    }

    grade[x][y].remove(objeto);
  }

  public ArrayList<Objeto> getObjetos(int x, int y) {

    if (x < 0 || x >= grade.length || y < 0 || y >= grade[0].length) {
      return new ArrayList<>();
    }

    return grade[x][y];
  }

  public Graphics desenharGrade(Graphics g) {

    for (int i = 0; i < grade.length; i++) {
      for (int j = 0; j < grade[i].length; j++) {
        g.drawRect(j * 50, i * 50, 50, 50);
      }
    }

    return g;
  }

  // limpa completamente uma célula (útil para debug)
  public void limparCelula(int x, int y) {

    if (x < 0 || x >= grade.length || y < 0 || y >= grade[0].length) {
      return;
    }

    grade[x][y].clear();
  }

  public ArrayList<Objeto>[][] getGrade() {
    return grade;
  }

  public void setGrade(ArrayList<Objeto>[][] grade) {
    this.grade = grade;
  }
}