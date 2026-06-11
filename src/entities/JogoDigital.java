package entities;

// CLASSE FILHA: Herda de entities.Jogo e adiciona a propriedade da loja virtual
public abstract class JogoDigital extends Jogo {
    private String lojaVirtual;

    public JogoDigital(String titulo, String plataforma, Desenvolvedora desenvolvedora, String lojaVirtual) {
        super(titulo, plataforma, desenvolvedora);
        this.lojaVirtual = lojaVirtual;
    }

    public String getLojaVirtual() { return lojaVirtual; }
    public void setLojaVirtual(String lojaVirtual) { this.lojaVirtual = lojaVirtual; }

    @Override
    public String getTipoJogo() { return "Digital"; }

    @Override
    public String getAtributoEspecifico() { return "Loja: " + lojaVirtual; }

    @Override
    public String formatarParaArquivo() {
        return super.formatarParaArquivo() + ";" + lojaVirtual;
    }
}