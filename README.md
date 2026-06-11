# projeto-poo
Repositório destinado a elaboração do projeto de programação orientada a objetos (POO)- 2026.1

Organização base 

src/
│
├── entities/                   # Guarda o modelo de dados e as regras de herança
│   ├── Jogo.java               (Abstrata)
│   ├── JogoCampanha.java       (Filha)
│   ├── JogoCompetitivo.java    (Filha)
│   ├── Review.java             (Composição)
│   └── RegrasBacklog.java      (Interface - pode ficar aqui ou num pacote 'interfaces')
│
├── services/                   # Guarda a lógica de negócios (salvar, listar, validar)
│   └── BacklogService.java
│
└── program/                    # Porta de entrada do sistema (Interface com o usuário)
    └── Main.java
