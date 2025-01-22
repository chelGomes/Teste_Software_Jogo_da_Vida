import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JogoDaVida jogo = new JogoDaVida(6, 6);

        System.out.println("Configuração inicial do tabuleiro:");
        jogo.mostrarTabuleiro();

        while (true) {
            System.out.println("Digite '0' para próxima geração ou '1' para sair:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("1")) {
                System.out.println("Jogo encerrado. Obrigado por jogar!");
                break;
            } else if (input.equalsIgnoreCase("0")) {
                jogo.proximaGeracao();
                System.out.println("Nova geração:");
                jogo.mostrarTabuleiro();
            } else {
                System.out.println("Entrada inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}
