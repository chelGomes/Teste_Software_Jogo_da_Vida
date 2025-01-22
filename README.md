# Teste_Software_Jogo_da_Vida

Especificação do Programa: Jogo da Vida

O jogo da vida consiste em um tabuleiro plano de dimensões 6x6, em que cada posição
possui um valor: 1 – corresponde a uma célula viva ou 0 – corresponde a uma célula
morta. O jogo começa com uma configuração inicial, gerada aleatoriamente. A partir desta
configuração, a cada passo, uma nova geração é obtida, de acordo com as seguintes
regras:
1. Qualquer célula viva com menos de dois vizinhos vivos morre de solidão.
2. Qualquer célula viva com mais de três vizinhos vivos morre de superpopulação.
3. Qualquer célula morta com exatamente três vizinhos vivos se torna uma célula viva.
4. Qualquer célula com dois vizinhos vivos continua no mesmo estado para a próxima
geração.
O jogo não tem fim, assim, o usuário pode a cada passo escolher uma nova geração ou
finalizar o jogo. A cada passo é mostrado ao usuário a geração anterior e a geração atual.
