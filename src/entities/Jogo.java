package entities;

// CLASSE ABSTRATA BASE: Molde para os jogos do sistema
public abstract class Jogo implements Avaliavel {
    protected String titulo;
    protected String plataforma;
    protected double nota;
    protected String comentario;
    protected StatusJogo status;
    protected Desenvolvedora desenvolvedora; // COMPOSIÇÃO

    public Jogo(String titulo, String plataforma, Desenvolvedora desenvolvedora) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.desenvolvedora = desenvolvedora;
        this.nota = 0;
        this.comentario = "Sem comentário";
        this.status = StatusJogo.NAO_INICIADO;
    }

    @Override
    public void avaliar(double nota, String comentario) {
        if (nota >= 0 && nota <= 5.0) {
            this.nota = nota;
        } else {
            System.out.println("[Erro] A nota deve ser obrigatoriamente entre 0 e 5.");
        }
        this.comentario = comentario;
    }

    // Métodos Getters e Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }
    public double getNota() { return nota; }
    public String getComentario() { return comentario; }
    public StatusJogo getStatus() { return status; }
    public void setStatus(StatusJogo status) { this.status = status; }
    public Desenvolvedora getDesenvolvedora() { return desenvolvedora; }
    public void setDesenvolvedora(Desenvolvedora desenvolvedora) { this.desenvolvedora = desenvolvedora; }

    // POLIMORFISMO: Métodos abstratos implementados nas subclasses
    // Linha 44
    public abstract String getTipoJogo();

    // Linha 46
    public abstract String getAtributoEspecifico();

    public String formatarParaArquivo() {
        return getTipoJogo() + ";" + titulo + ";" + plataforma + ";" +
                desenvolvedora.getNome() + ";" + desenvolvedora.getPaisOrigem() + ";" +
                nota + ";" + comentario + ";" + status.name();
    }
}