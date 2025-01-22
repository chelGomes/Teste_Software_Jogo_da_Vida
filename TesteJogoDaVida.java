import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TesteJogoDaVida {

    @Test
    public void testInicializacaoTabuleiro() {
        Tabuleiro tabuleiro = new Tabuleiro(3, 3);
        int[][] gradeInicial = {
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}
        };
        tabuleiro.setGrade(gradeInicial);

        assertArrayEquals(gradeInicial, tabuleiro.getGrade(), "A grade inicial do tabuleiro deve ser configurada corretamente.");
    }

    @Test
    public void testEvolucaoSimples() {
        Tabuleiro tabuleiro = new Tabuleiro(3, 3);
        int[][] gradeInicial = {
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}
        };
        tabuleiro.setGrade(gradeInicial); // Configura a grade inicial
        tabuleiro.proximaGeracao();      // Gera a próxima geração

        int[][] gradeEsperada = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        // Compara a grade esperada com a grade gerada pelo método
        assertArrayEquals(gradeEsperada, tabuleiro.getGrade(),
                "A próxima geração do tabuleiro deve ser calculada corretamente.");
    }

    @Test
    public void testDimensaoInvalida() {
        Tabuleiro tabuleiro = null;
        try {
            tabuleiro = new Tabuleiro(0, 0);
        } catch (IllegalArgumentException e) {
            // Confirma que a exceção foi lançada
            assertTrue(e.getMessage().contains("Dimensão inválida"),
                    "Deve lançar exceção para dimensões inválidas.");
        }
        assertNull(tabuleiro, "Tabuleiro não deve ser criado com dimensões inválidas.");
    }

    @Test
    public void testCelulaMorrePorSuperpopulacao() {
        Tabuleiro tabuleiro = new Tabuleiro(3, 3);
        int[][] gradeInicial = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        tabuleiro.setGrade(gradeInicial); // Configura a grade inicial
        tabuleiro.proximaGeracao();      // Gera a próxima geração

        int[][] gradeEsperada = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        // Compara a grade esperada com a gerada pelo método
        assertArrayEquals(gradeEsperada, tabuleiro.getGrade(),
                "Célula deveria morrer por superpopulação.");
    }

}
