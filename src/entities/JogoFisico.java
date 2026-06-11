package entities;

// CLASSE FILHA: Herda de entities.Jogo e adiciona a propriedade do encarte
public class JogoFisico extends Jogo {
    private boolean temEncarte;

    public JogoFisico(String titulo, String plataforma, Desenvolvedora desenvolvedora, boolean temEncarte) {
        super(titulo, plataforma, desenvolvedora);
        this.temEncarte = temEncarte;
    }

    public boolean isTemEncarte() { return temEncarte; }
    public void setTemEncarte(boolean temEncarte) { this.temEncarte = temEncarte; }

    @Override
    public String getTipoJogo() { return "Físico"; }

    @Override
    public String getAtributoEspecifico() {
        return temEncarte ? "Possui Encarte" : "Sem Encarte";
    }

    @Override
    public String formatarParaArquivo() {
        return super.formatarParaArquivo() + ";" + temEncarte;
    }

    @Override
    public void evaluar(int nota, String comentario) {

    }
}