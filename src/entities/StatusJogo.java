package entities;

// ENUMERAÇÃO: Padroniza o progresso do jogador
public enum StatusJogo {
    NAO_INICIADO("Não Iniciado"),
    EM_ANDAMENTO("Em Andamento"),
    FINALIZADO("Finalizado"),
    DROPADO("Dropado");

    private String descricao;

    StatusJogo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() { return descricao; }
}