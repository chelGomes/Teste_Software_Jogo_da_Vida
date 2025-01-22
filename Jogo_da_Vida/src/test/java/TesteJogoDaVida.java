import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

    //caso de teste de classe de equivalencia
    @Test
    public void testDimensoesValidas() {
        Tabuleiro tabuleiro = new Tabuleiro(6, 6);
        assertNotNull(tabuleiro, "O tabuleiro com dimensões válidas deve ser criado.");
    }

    // caso de teste Análise do Valor Limite

    @Test
    public void testBordaDoTabuleiro() {
        Tabuleiro tabuleiro = new Tabuleiro(3, 3);
        int[][] gradeInicial = {
                {0, 1, 0},
                {0, 0, 0},
                {1, 1, 1}
        };
        tabuleiro.setGrade(gradeInicial);

        System.out.println("Grade inicial:");
        for (int[] linha : gradeInicial) {
            System.out.println(Arrays.toString(linha));
        }

        tabuleiro.proximaGeracao();

        int[][] gradeEsperada = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 1, 0}
        };

        System.out.println("Grade esperada:");
        for (int[] linha : gradeEsperada) {
            System.out.println(Arrays.toString(linha));
        }

        System.out.println("Grade gerada:");
        for (int[] linha : tabuleiro.getGrade()) {
            System.out.println(Arrays.toString(linha));
        }

        assertArrayEquals(gradeEsperada, tabuleiro.getGrade(),
                "Células na borda devem ser tratadas corretamente.");
    }




    // caso de teste Grafo de Causa-Efeito
    @Test
    public void testCelulaVivaPermaneceViva() {
        Tabuleiro tabuleiro = new Tabuleiro(3, 3);
        int[][] gradeInicial = {
                {0, 1, 0},
                {1, 1, 0},
                {0, 0, 0}
        };
        tabuleiro.setGrade(gradeInicial);

        System.out.println("Grade inicial:");
        for (int[] linha : tabuleiro.getGrade()) {
            System.out.println(Arrays.toString(linha));
        }

        tabuleiro.proximaGeracao();

        int[][] gradeEsperada = {
                {0, 1, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        System.out.println("Grade esperada:");
        for (int[] linha : gradeEsperada) {
            System.out.println(Arrays.toString(linha));
        }

        System.out.println("Grade gerada:");
        for (int[] linha : tabuleiro.getGrade()) {
            System.out.println(Arrays.toString(linha));
        }

        assertArrayEquals(gradeEsperada, tabuleiro.getGrade(),
                "Células vivas com 2 ou 3 vizinhos devem permanecer vivas.");
    }


    // caso de teste Critérios Funcionais

    @Test
    public void testPadraoEstavel() {
        Tabuleiro tabuleiro = new Tabuleiro(4, 4);
        int[][] gradeInicial = {
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };
        tabuleiro.setGrade(gradeInicial);
        tabuleiro.proximaGeracao();

        int[][] gradeEsperada = gradeInicial; // Padrão permanece inalterado

        assertArrayEquals(gradeEsperada, tabuleiro.getGrade(),
                "O padrão estável não deve mudar após a evolução.");
    }

}
