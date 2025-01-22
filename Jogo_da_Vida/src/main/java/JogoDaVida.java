public class JogoDaVida {
    private Tabuleiro tabuleiro; // Representa o tabuleiro do jogo

    // Construtor que inicializa o tabuleiro com dimensões especificadas
    public JogoDaVida(int linhas, int colunas) {
        this.tabuleiro = new Tabuleiro(linhas, colunas);
        tabuleiro.inicializarRandomly(); // Inicializa o tabuleiro com valores aleatórios
    }

    // Gera a próxima geração do tabuleiro seguindo as regras do jogo
    public void proximaGeracao() {
        int[][] atual = tabuleiro.getGrade(); // Obtém o estado atual do tabuleiro
        int[][] proximo = new int[tabuleiro.getLinhas()][tabuleiro.getColunas()]; // Novo estado do tabuleiro

        // Percorre cada célula do tabuleiro
        for (int i = 0; i < tabuleiro.getLinhas(); i++) {
            for (int j = 0; j < tabuleiro.getColunas(); j++) {
                int vidaVizinhos = contVidaVizinhos(atual, i, j); // Conta os vizinhos vivos

                // Aplica as regras do Jogo da Vida
                if (atual[i][j] == 1) {
                    // Célula viva
                    proximo[i][j] = (vidaVizinhos < 2 || vidaVizinhos > 3) ? 0 : 1;
                } else {
                    // Célula morta
                    proximo[i][j] = (vidaVizinhos == 3) ? 1 : 0;
                }
            }
        }
        // Atualiza o tabuleiro com o novo estado
        tabuleiro.setGrade(proximo);
    }

    // Conta os vizinhos vivos de uma célula específica
    int contVidaVizinhos(int[][] grade, int linha, int coluna) {
        int cont = 0;
        int[] direcoes = {-1, 0, 1}; // Direções relativas para checar os vizinhos

        // Verifica todas as combinações de deslocamentos
        for (int dr : direcoes) {
            for (int dc : direcoes) {
                if (dr == 0 && dc == 0) continue; // Ignorar a célula atual

                int novaLinha = linha + dr;
                int novaColuna = coluna + dc;

                // Verifica se o vizinho está dentro dos limites do tabuleiro
                if (novaLinha >= 0 && novaLinha < tabuleiro.getLinhas() &&
                        novaColuna >= 0 && novaColuna < tabuleiro.getColunas()) {
                    cont = cont + grade[novaLinha][novaColuna]; // Soma 1 se o vizinho estiver vivo
                }
            }
        }
        return cont;
    }

    // Exibe o tabuleiro atual
    public void mostrarTabuleiro() {

        tabuleiro.mostrar();
    }

    public int[][] calcularProximaGeracao(int[][] grade) {
        return grade;
    }
}
