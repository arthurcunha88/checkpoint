package entities;

// INTERFACE: Garante a obrigatoriedade das avaliações no sistema
public interface Avaliavel {
    void evaluar(double nota, String comentario);

    void avaliar(double nota, String comentario);
    double getNota();
    String getComentario();
}