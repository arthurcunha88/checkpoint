package entities;

// CLASSE DE COMPOSIÇÃO: Representa a empresa criadora do jogo
public class Desenvolvedora {
    private String nome;
    private String paisOrigem;

    public Desenvolvedora(String nome, String paisOrigem) {
        this.nome = nome;
        this.paisOrigem = paisOrigem;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getPaisOrigem() { return paisOrigem; }
    public void setPaisOrigem(String paisOrigem) { this.paisOrigem = paisOrigem; }
}