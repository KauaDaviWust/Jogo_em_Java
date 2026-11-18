
import java.awt.Rectangle;

public class Colisao {
   boolean colidiu(Rectangle areaO1, Rectangle areaO2) {
      return areaO1.intersects(areaO2);
   }

   public boolean colidiuHorizontal(
         int posicaoX,
         int posicaoY,
         int largura,
         int altura,
         int movimentoX,
         Rectangle areaO2) {

      Rectangle proximaArea = new Rectangle(
            posicaoX + movimentoX,
            posicaoY,
            largura,
            altura);

      return proximaArea.intersects(areaO2);
   }

   public boolean colidiuVertical(
         int posicaoX,
         int posicaoY,
         int largura,
         int altura,
         int movimentoY,
         Rectangle areaO2) {

      Rectangle proximaArea = new Rectangle(
            posicaoX,
            posicaoY + movimentoY,
            largura,
            altura);

      return proximaArea.intersects(areaO2);
   }

}
