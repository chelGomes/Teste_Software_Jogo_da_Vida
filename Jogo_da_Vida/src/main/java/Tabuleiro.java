import java.util.Arrays;
import java.util.Random;

public class Tabuleiro {

    private int linhas;    // Número de linhas do tabuleiro
    private int colunas;    // Número de colunas do tabuleiro
    private int[][] grade; // Matriz que representa o estado do tabuleiro

    // Construtor que inicializa o tabuleiro com dimensões especificadas
    public Tabuleiro(int linhas, int colunas) {
        if (linhas < 1 || colunas < 1) {
            throw new IllegalArgumentException("Dimensão inválida: linhas e colunas devem ser maiores que 0.");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        this.grade = new int[linhas][colunas];
    }

    // Inicializa o tabuleiro com valores aleatórios (0 ou 1)
    public void inicializarRandomly() {
        Random random = new Random();
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                grade[i][j] = random.nextInt(2); // Gera 0 ou 1 aleatoriamente
            }
        }
    }

    // Retorna o número de linhas do tabuleiro
    public int getLinhas() {
        return linhas;
    }

    // Retorna o número de colunas do tabuleiro
    public int getColunas() {
        return colunas;
    }

    // Retorna a matriz atual que representa o tabuleiro
    public int[][] getGrade() {
        return grade;
    }

    // Atualiza o estado do tabuleiro com uma nova matriz
    public void setGrade(int[][] novaGrade) {
        this.grade = novaGrade;
    }

    // Exibe o tabuleiro no console
    public void mostrar() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(grade[i][j] + " "); // Imprime o valor da célula
            }
            System.out.println(); // Nova linha após cada linha do tabuleiro
        }
    }

    public void proximaGeracao() {
        int[][] novaGrade = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                int vizinhosVivos = contarVizinhosVivos(i, j);

                if (grade[i][j] == 1) { // Célula viva
                    if (vizinhosVivos == 2 || vizinhosVivos == 3) {
                        novaGrade[i][j] = 1; // Permanece viva
                    } else {
                        novaGrade[i][j] = 0; // Morre
                    }
                } else { // Célula morta
                    if (vizinhosVivos == 3) {
                        novaGrade[i][j] = 1; // Revive
                    } else {
                        novaGrade[i][j] = 0; // Permanece morta
                    }
                }
            }
        }

        grade = novaGrade;
    }

    private int contarVizinhosVivos(int linha, int coluna) {
        int vizinhosVivos = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // Ignora a célula atual

                int novaLinha = linha + i;
                int novaColuna = coluna + j;

                // Verifica se está dentro dos limites do tabuleiro
                if (novaLinha >= 0 && novaLinha < linhas && novaColuna >= 0 && novaColuna < colunas) {
                    vizinhosVivos += grade[novaLinha][novaColuna];
                }
            }
        }
        return vizinhosVivos;
    }
}
