package entities;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// GERENCIADOR: Controla as regras de negócio, persistência em TXT e operações da lista
public class GerenciadorJogos {
    private ArrayList<Jogo> listaDeJogos;
    private final String CAMINHO_ARQUIVO = "backlog_jogos.txt";

    public GerenciadorJogos() {
        listaDeJogos = new ArrayList<>();
        carregarDoArquivo();
    }

    public void incluirJogo(Jogo jogo) {
        listaDeJogos.add(jogo);
        salvarNoArquivo();
        System.out.println("-> entities.Jogo '" + jogo.getTitulo() + "' cadastrado com sucesso!");
    }

    public boolean excluirJogo(String titulo) {
        Jogo jogo = buscarPorTituloInterno(titulo);
        if (jogo != null) {
            listaDeJogos.remove(jogo);
            salvarNoArquivo();
            return true;
        }
        return false;
    }

    public void atualizarArquivo() {
        salvarNoArquivo();
    }

    public Jogo buscarPorTituloInterno(String titulo) {
        for (Jogo j : listaDeJogos) {
            if (j.getTitulo().equalsIgnoreCase(titulo)) {
                return j;
            }
        }
        return null;
    }

    public void buscarEExibirJogo(String titulo) {
        Jogo j = buscarPorTituloInterno(titulo);
        if (j != null) {
            System.out.println("\n=== REGISTRO ENCONTRADO ===");
            System.out.println("Título: " + j.getTitulo());
            System.out.println("Plataforma: " + j.getPlataforma());
            System.out.println("entities.Desenvolvedora: " + j.getDesenvolvedora().getNome() + " (" + j.getDesenvolvedora().getPaisOrigem() + ")");
            System.out.println("Tipo: " + j.getTipoJogo() + " | " + j.getAtributoEspecifico());
            System.out.println("Status: " + j.getStatus().getDescricao());
            System.out.println("Nota do Usuário: " + j.getNota() + "/5");
            System.out.println("Comentário: " + j.getComentario());
            System.out.println("===========================");
        } else {
            System.out.println("-> entities.Jogo não encontrado no sistema.");
        }
    }

    public void listarJogosTabular(boolean ordenar) {
        if (listaDeJogos.isEmpty()) {
            System.out.println("Sua lista de jogos está vazia.");
            return;
        }

        ArrayList<Jogo> listaParaExibicao = new ArrayList<>(listaDeJogos);
        if (ordenar) {
            Collections.sort(listaParaExibicao, new Comparator<Jogo>() {
                @Override
                public int compare(Jogo j1, Jogo j2) {
                    return j1.getTitulo().compareToIgnoreCase(j2.getTitulo());
                }
            });
        }

        System.out.println("\n" + (ordenar ? "=== LISTA DE JOGOS ORDENADA (ALFABÉTICA) ===" : "=== LISTA DE JOGOS CADASTRADOS ==="));
        System.out.printf("%-25s | %-12s | %-18s | %-8s | %-13s | %-5s | %-20s%n",
                "TÍTULO", "PLATAFORMA", "DESENVOLVEDORA", "TIPO", "STATUS", "NOTA", "DETALHE ESPECÍFICO");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");

        for (Jogo j : listaParaExibicao) {
            System.out.printf("%-25s | %-12s | %-18s | %-8s | %-13s | %-5s | %-20s%n",
                    limitarTexto(j.getTitulo(), 25),
                    limitarTexto(j.getPlataforma(), 12),
                    limitarTexto(j.getDesenvolvedora().getNome(), 18),
                    j.getTipoJogo(),
                    j.getStatus().getDescricao(),
                    j.getNota() == 0 ? "-" : String.valueOf(j.getNota()),
                    j.getAtributoEspecifico());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
    }

    private String limitarTexto(String texto, int tamanhoMax) {
        if (texto.length() > tamanhoMax) {
            return texto.substring(0, tamanhoMax - 3) + "...";
        }
        return texto;
    }

    public void verificarECarregarObjetosPadrao() {
        if (listaDeJogos.isEmpty()) {
            System.out.println("-> Inicializando carga automática de 14 jogos de teste para avaliação (7 Físicos e 7 Digitais)...");

            Desenvolvedora nintendo = new Desenvolvedora("Nintendo", "Japão");
            Desenvolvedora FromSoft = new Desenvolvedora("FromSoftware", "Japão");
            Desenvolvedora SantaMonica = new Desenvolvedora("Santa Monica Studio", "EUA");
            Desenvolvedora Rockstar = new Desenvolvedora("Rockstar Games", "EUA");
            Desenvolvedora Capcom = new Desenvolvedora("Capcom", "Japão");
            Desenvolvedora NaughtyDog = new Desenvolvedora("Naughty Dog", "EUA");
            Desenvolvedora CDProjekt = new Desenvolvedora("CD Projekt Red", "Polônia");
            Desenvolvedora Mojang = new Desenvolvedora("Mojang Studios", "Suécia");
            Desenvolvedora Valve = new Desenvolvedora("Valve", "EUA");

            incluirJogo(new JogoFisico("The Legend of Zelda", "Switch", nintendo, true));
            incluirJogo(new JogoFisico("Elden Ring", "PS5", FromSoft, true));
            incluirJogo(new JogoFisico("God of War Ragnarok", "PS5", SantaMonica, true));
            incluirJogo(new JogoFisico("Red Dead Redemption 2", "Xbox One", Rockstar, false));
            incluirJogo(new JogoFisico("Resident Evil 4 Remake", "PS5", Capcom, true));
            incluirJogo(new JogoFisico("The Last of Us Part II", "PS4", NaughtyDog, true));
            incluirJogo(new JogoFisico("Super Mario Odyssey", "Switch", nintendo, false));

            incluirJogo(new JogoDigital("Cyberpunk 2077", "PC", CDProjekt, "Steam"));
            incluirJogo(new JogoDigital("Minecraft", "PC", Mojang, "Launcher"));
            incluirJogo(new JogoDigital("Counter-Strike 2", "PC", Valve, "Steam"));
            incluirJogo(new JogoDigital("Hades", "PC", new Desenvolvedora("Supergiant", "EUA"), "Epic Games"));
            incluirJogo(new JogoDigital("The Witcher 3", "PC", CDProjekt, "GOG"));
            incluirJogo(new JogoDigital("Stardew Valley", "PC", new Desenvolvedora("ConcernedApe", "EUA"), "Steam"));
            incluirJogo(new JogoDigital("Portal 2", "PC", Valve, "Steam"));

            listaDeJogos.get(0).avaliar(5, "entities.Jogo impecável de exploração!");
            listaDeJogos.get(0).setStatus(StatusJogo.FINALIZADO);
            listaDeJogos.get(7).avaliar(4, "Muito bom após as atualizações.");
            listaDeJogos.get(7).setStatus(StatusJogo.EM_ANDAMENTO);

            salvarNoArquivo();
        }
    }

    private void salvarNoArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            for (Jogo jogo : listaDeJogos) {
                writer.write(jogo.formatarParaArquivo());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("[Erro] Falha ao persistir dados: " + e.getMessage());
        }
    }

    private void carregarDoArquivo() {
        File arquivo = new File(CAMINHO_ARQUIVO);
        if (!arquivo.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length < 8) continue;

                String tipo = partes[0];
                String titulo = partes[1];
                String plataforma = partes[2];
                String nomeDev = partes[3];
                String paisDev = partes[4];
                int nota = Integer.parseInt(partes[5]);
                String comentario = partes[6];
                StatusJogo status = StatusJogo.valueOf(partes[7]);

                Desenvolvedora dev = new Desenvolvedora(nomeDev, paisDev);
                Jogo jogo;

                if (tipo.equals("Físico")) {
                    boolean temEncarte = Boolean.parseBoolean(partes[8]);
                    jogo = new JogoFisico(titulo, plataforma, dev, temEncarte);
                } else {
                    String loja = partes[8];
                    jogo = new JogoDigital(titulo, plataforma, dev, loja);
                }

                jogo.avaliar(nota, comentario);
                jogo.setStatus(status);
                listaDeJogos.add(jogo);
            }
        } catch (Exception e) {
            System.out.println("[Aviso] Iniciando com novo arquivo limpo.");
        }
    }
}