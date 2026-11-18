import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public abstract class Objeto {

  JFrame frame;
  Grade grade;

  private ImageIcon imagem;

  private int imagemX;
  private int imagemY;
  private int imageLargura;
  private int imagemAltura;

  private int areaX;
  private int areaY;
  private int areaLargura;
  private int areaAltura;

  private Rectangle area;
  private boolean noMapa;

  public Objeto(JFrame frame, Grade grade, boolean noMapa,
      int x, int y, int largura, int altura) {

    this.frame = frame;
    this.grade = grade;

    this.imagemX = x;
    this.imagemY = y;

    this.imageLargura = largura;
    this.imagemAltura = altura;

    this.areaX = x;
    this.areaY = y;
    this.areaLargura = largura;
    this.areaAltura = altura;

    this.area = new Rectangle(areaX, areaY, areaLargura, areaAltura);
    this.noMapa = noMapa;

    if (noMapa) {
      adicionarNaGrade();
    }
  }
  // -------------------------------------------------------------------------------
  // GRADE

  public void adicionarNaGrade() {

    if (!noMapa)
      return;

    int gradeX = areaX / 50;
    int gradeY = areaY / 50;

    int gradeLargura = (areaX + areaLargura - 1) / 50 - gradeX;
    int gradeAltura = (areaY + areaAltura - 1) / 50 - gradeY;

    for (int i = gradeX; i <= gradeX + gradeLargura; i++) {
      for (int j = gradeY; j <= gradeY + gradeAltura; j++) {
        grade.adicionar(this, j, i);
      }
    }
  }

  public void removerDaGrade() {

    if (!noMapa)
      return;

    int gradeX = areaX / 50;
    int gradeY = areaY / 50;

    int gradeLargura = (areaX + areaLargura - 1) / 50 - gradeX;
    int gradeAltura = (areaY + areaAltura - 1) / 50 - gradeY;

    for (int i = gradeX; i <= gradeX + gradeLargura; i++) {
      for (int j = gradeY; j <= gradeY + gradeAltura; j++) {
        grade.remover(this, j, i);
      }
    }
  }

  // -------------------------------------------------------------------------------------
  // MOVIMENTO

  public void moveX(int movX) {

    if (noMapa) {
      removerDaGrade();
    }

    imagemX += movX;
    areaX += movX;

    area.setLocation(areaX, areaY);

    if (noMapa) {
      adicionarNaGrade();
    }
  }

  public void moveY(int movY) {

    if (noMapa) {
      removerDaGrade();
    }

    imagemY += movY;
    areaY += movY;

    area.setLocation(areaX, areaY);

    if (noMapa) {
      adicionarNaGrade();
    }
  }

  // ------------------------------------------------------------------------------------------------------------------
  // DESENHO

  public Graphics criarQuadrado(Graphics g) {
    g.fillRect(areaX, areaY, areaLargura, areaAltura);
    return g;
  }

  public Graphics criarImagem(Graphics g) {

    if (imagem != null) {
      g.drawImage(imagem.getImage(),
          imagemX,
          imagemY,
          imageLargura,
          imagemAltura,
          null);
    }

    return g;
  }

  public void colocarImagem(String caminho) {

    ImageIcon icon = new ImageIcon(caminho);

    Image img = icon.getImage().getScaledInstance(imageLargura, imagemAltura, Image.SCALE_SMOOTH);

    this.imagem = new ImageIcon(img);
  }

  public void mudarImagem(String caminho) {
    colocarImagem(caminho);
  }

  public abstract void aoEncostar(Player p, boolean colidiuH, boolean colidiuV);

  // ------------------------------------------------------------------------------------------------------------
  // GETTERS E SETTERS

  public int getImagemX() {
    return imagemX;
  }

  public void setImagemX(int imagemX) {
    this.imagemX = imagemX;
  }

  public int getImagemY() {
    return imagemY;
  }

  public void setImagemY(int imagemY) {
    this.imagemY = imagemY;
  }

  public int getImageLargura() {
    return imageLargura;
  }

  public void setImageLargura(int imageLargura) {
    this.imageLargura = imageLargura;
  }

  public int getImagemAltura() {
    return imagemAltura;
  }

  public void setImagemAltura(int imagemAltura) {
    this.imagemAltura = imagemAltura;
  }

  public int getAreaX() {
    return areaX;
  }

  public void setAreaX(int areaX) {
    if (noMapa) {
      removerDaGrade();
    }
    this.areaX = areaX;
    this.imagemX = areaX;
    area.setLocation(this.areaX, this.areaY);
    if (noMapa) {
      adicionarNaGrade();
    }
  }

  public int getAreaY() {
    return areaY;
  }

  public void setAreaY(int areaY) {
    this.areaY = areaY;
    this.imagemY = areaY;
    area.setLocation(this.areaX, this.areaY);
  }

  public int getAreaLargura() {
    return areaLargura;
  }

  public void setAreaLargura(int areaLargura) {

    if (noMapa) {
      removerDaGrade();
    }

    this.areaLargura = areaLargura;
    this.imageLargura = areaLargura;

    area.setSize(this.areaLargura, this.areaAltura);

    if (noMapa) {
      adicionarNaGrade();
    }
  }

  public int getAreaAltura() {
    return areaAltura;
  }

  public void setAreaAltura(int areaAltura) {

    if (noMapa) {
      removerDaGrade();
    }

    this.areaAltura = areaAltura;
    this.imagemAltura = areaAltura;

    area.setSize(this.areaLargura, this.areaAltura);

    if (noMapa) {
      adicionarNaGrade();
    }
  }

  public boolean isNoMapa() {
    return noMapa;
  }

  public void setNoMapa(boolean noMapa) {
    this.noMapa = noMapa;
  }

  public Grade getGrade() {
    return grade;
  }

  public void setGrade(Grade grade) {
    this.grade = grade;
  }

  public ImageIcon getImagem() {
    return imagem;
  }

  public void setImagem(ImageIcon imagem) {
    this.imagem = imagem;
  }

  public Rectangle getArea() {
    return area;
  }

  public void setArea(Rectangle area) {
    this.area = area;
  }
}