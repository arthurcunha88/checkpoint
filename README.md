# 🎮 Checkpoint - Gerenciador de Backlog de Jogos

Este repositório contém o projeto de Programação Orientada a Objetos (POO) destinado à elaboração de um sistema de gerenciamento de backlog e avaliações de jogos de videogame.

---

## 🏗️ Arquitetura do Projeto

O sistema está organizado utilizando o padrão de arquitetura em camadas para isolar responsabilidades e manter o código limpo, escalável e legível:

```text
src/
│
├── entities/                   # Modelos de dados e contratos
│   ├── Jogo.java               (Classe Abstrata Mãe)
│   ├── JogoCampanha.java       (Classe Filha - Herança)
│   ├── JogoCompetitivo.java    (Classe Filha - Herança)
│   ├── Review.java             (Classe de Avaliação - Composição)
│   └── RegrasBacklog.java      (Interface de Contrato)
│
├── services/                   # Lógica de negócios e armazenamento
│   └── BacklogService.java     (Gerenciamento da lista em memória)
│
└── program/                    # Ponto de entrada do sistema
    └── Main.java               (Interface/Fluxo do usuário)
