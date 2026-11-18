import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListaObjetos {

    private HashSet<Objeto> objetos = new HashSet<>();

    public void objetosPerto(Player player, Grade grade) {

        objetos.clear();

        int col = player.getAreaX() / 50;
        int row = player.getAreaY() / 50;

        int maxRow = grade.getGrade().length;
        int maxCol = grade.getGrade()[0].length;

        // percorre as 9 posições ao redor
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {

                // verifica se está dentro da grade
                if (i >= 0 && i < maxRow && j >= 0 && j < maxCol) {

                    List<Objeto> celula = grade.getGrade()[i][j];

                    if (celula != null) {
                        objetos.addAll(celula);
                    }
                }
            }
        }
    }

    public Set<Objeto> getObjetos() {
        return objetos;
    }
}