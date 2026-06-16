# 🎮 Checkpoint - Gerenciador de Backlog de Jogos

Este repositório contém o projeto de Programação Orientada a Objetos (POO) destinado à elaboração de um sistema de gerenciamento de backlog, logs e avaliações de jogos de videogame.

---

## 🏗️ Arquitetura do Projeto

O sistema está estruturado de forma a isolar as responsabilidades de cada componente, utilizando um arquivo de texto na raiz para persistência dos dados de forma simples e direta:

```text
checkpoint/                      # Raiz do projeto
│
├── backlog_jogos.txt            # Arquivo de texto utilizado para salvar e persistir o log dos jogos
│
└── src/                         # Código-fonte do sistema
    │
    ├── entities/                # Modelos de dados, contratos e estruturas principais
    │   ├── Avaliavel.java       # Interface que define o contrato para objetos que podem receber notas/críticas
    │   ├── StatusJogo.java      # Enumeração ou Interface que define os estados do jogo (ex: Jogando, Zerado, Backlog)
    │   ├── Desenvolvedora.java  # Classe que representa a empresa criadora do jogo (utilizada via Composição)
    │   ├── Jogo.java            # Classe abstrata base (Mãe) com os atributos e métodos comuns aos jogos
    │   ├── JogoDigital.java     # Classe filha que herda de Jogo (Especialização para mídia digital)
    │   ├── JogoFisico.java      # Classe filha que herda de Jogo (Especialização para mídia física)
    │   └── GerenciadorJogos.java# Classe responsável por agrupar ou orquestrar o comportamento das entidades
    │
    └── program/                 # Ponto de entrada (Entry Point) da aplicação
        └── Programa.java        # Classe principal com o método main e interface de linha de comando (CLI)
