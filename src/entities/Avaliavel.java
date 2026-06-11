package entities;

// INTERFACE: Garante a obrigatoriedade das avaliações no sistema
public interface Avaliavel {
    void evaluar(int nota, String comentario);

    void avaliar(int nota, String comentario);
    int getNota();
    String getComentario();
}