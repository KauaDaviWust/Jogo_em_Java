# Jogo-em-java

Jogo de plataforma em Java com interface grafica Swing. O objetivo e atravessar tres fases, evitando espinhos e paredes de espinhos ate chegar a porta.

## Controles

| Acao | Tecla |
|---|---|
| Mover para a esquerda | `A` |
| Mover para a direita | `D` |
| Pular | `Espaco` |

## Como executar

Certifique-se de ter o Java Development Kit (JDK) instalado.

No terminal, entre na pasta do projeto e compile todos os arquivos:

```bash
javac *.java
```

Execute o jogo pela classe principal:

```bash
java Jogo
```

Mantenha a pasta `imagens` dentro da pasta do projeto, pois ela contem os sprites do personagem, portas e espinhos.

## Fases

- **Fase 1:** ativa mecanismos por meio de triggers para abrir caminhos.
- **Fase 2:** atravesse plataformas enquanto evita espinhos que se movem pela fase.
- **Fase 3:** desvie das paredes de espinhos e alcance a porta final.

Ao tocar em espinhos ou cair da area jogavel, o jogador morre e a fase reinicia automaticamente.

## Estrutura principal

- `Jogo.java`: inicia a janela, controla as fases e encerra o jogo.
- `Cena.java`: classe base das fases.
- `Cena1.java`, `Cena2.java`, `Cena3.java`: implementacoes das tres fases.
- `Player.java`: movimento, animacao e estado do jogador.
- `Movimento.java`: leitura das teclas.
- `Objeto.java`: base dos elementos posicionados no mapa.
- `Plataforma.java`, `Espinho.java`, `ParedeDeEspinhos.java`, `Porta.java`, `Trigger.java`: elementos de jogo e colisao.
- `Grade.java`: desenho da grade visual.
- `Colisao.java`: verificacao de colisoes.
