# 🏎️ Projeto Corrida JavaFX

Um minijogo de corrida de carros desenvolvido em **JavaFX** para demonstrar o uso de **Threads** (concorrência e paralelismo) e manipulação de interfaces gráficas (UI).

## 🎮 Funcionalidades

- **Múltiplas Threads**: Cada carro corre em sua própria `Thread`, avançando distâncias e pausando em tempos aleatórios para simular uma corrida real e imprevisível.
- **Pódio Dinâmico em Tempo Real**: Conforme os carros vão avançando, o pódio e as posições (1º, 2º e 3º) são atualizados na hora.
- **Interface Moderna (Dark Theme)**: O projeto conta com um CSS (`style.css`) customizado que traz um visual escuro moderno, sombras agradáveis e botões com degradê animado.
- **Restart Rápido**: Terminou a corrida? Basta clicar no botão de "Iniciar Corrida" novamente para que as threads sejam recriadas e os carros voltem limpos para a linha de largada.
- **Uso de Platform.runLater**: O jogo serve como um bom caso de estudo de como comunicar Threads de background com a Thread principal (FX Application Thread) sem gerar erros de concorrência.

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **JavaFX** (Componentes de UI: ImageView, Pane, HBox, VBox, Button)
- **Maven** (Gerenciamento de dependências e build)
- **CSS** (Estilização da interface)

## 🚀 Como Executar o Projeto

1. Certifique-se de ter o **Java** e o **Maven** instalados na sua máquina.
2. Clone este repositório.
3. Pelo terminal, navegue até a pasta `corrida`:
   ```bash
   cd corrida
   ```
4. Execute o comando Maven para compilar e rodar o projeto JavaFX:
   ```bash
   mvn clean javafx:run
   ```

## 📸 Imagens do Projeto

As imagens dos carrinhos e a textura da pista se encontram na pasta `src/main/resources/images`. Para personalizar, você pode simplesmente substituir as imagens de `carro1.png`, `carro2.png`, `carro3.png` e `pista.jpg` pelos assets de sua preferência.

---
*Este projeto foi criado com foco em estudos práticos de Programação Concorrente com Java e Interfaces Gráficas.*
