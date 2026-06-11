package program;
import entities.*;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        GerenciadorJogos gerenciador = new GerenciadorJogos();
        gerenciador.verificarECarregarObjetosPadrao();

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        System.out.println("\n=============================================");
        System.out.println("      BEM-VINDO AO SEU BACKLOG DE JOGOS       ");
        System.out.println("=============================================");

        do {
            System.out.println("\n>>> MENU PRINCIPAL <<<");
            System.out.println("1. Incluir Novo entities.Jogo");
            System.out.println("2. Alterar entities.Jogo Existente");
            System.out.println("3. Excluir entities.Jogo");
            System.out.println("4. Listar Todos os Jogos (Ordem de Cadastro)");
            System.out.println("5. Listar Todos os Jogos (Ordem Alfabética)");
            System.out.println("6. Buscar entities.Jogo por Título");
            System.out.println("7. Sair do program.Programa");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    System.out.print("\nDigite o título do jogo: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite a plataforma (ex: PC, PS5, Switch): ");
                    String plataforma = scanner.nextLine();
                    System.out.print("Nome da desenvolvedora: ");
                    String nomeDev = scanner.nextLine();
                    System.out.print("País da desenvolvedora: ");
                    String paisDev = scanner.nextLine();
                    Desenvolvedora dev = new Desenvolvedora(nomeDev, paisDev);

                    System.out.print("O jogo é Físico ou Digital? (F/D): ");
                    String tipo = scanner.nextLine();

                    if (tipo.equalsIgnoreCase("F")) {
                        System.out.print("O jogo possui encarte físico impresso? (S/N): ");
                        boolean encarte = scanner.nextLine().equalsIgnoreCase("S");
                        gerenciador.incluirJogo(new JogoFisico(titulo, plataforma, dev, encarte));
                    } else if (tipo.equalsIgnoreCase("D")) {
                        System.out.print("Qual é a loja digital de aquisição? (ex: Steam, Epic): ");
                        String loja = scanner.nextLine();
                        gerenciador.incluirJogo(new JogoDigital(titulo, plataforma, dev, loja));
                    } else {
                        System.out.println("[Erro] Opção inválida. Cadastro cancelado.");
                    }
                    break;

                case 2:
                    System.out.print("\nDigite exatamente o título do jogo que deseja alterar: ");
                    String tituloAlterar = scanner.nextLine();
                    Jogo jAlterar = gerenciador.buscarPorTituloInterno(tituloAlterar);

                    if (jAlterar != null) {
                        System.out.println("\nModificando dados de: " + jAlterar.getTitulo());
                        System.out.print("Novo Título (Deixe em branco para manter): ");
                        String novoTitulo = scanner.nextLine();
                        if (!novoTitulo.trim().isEmpty()) jAlterar.setTitulo(novoTitulo);

                        System.out.print("Nova Plataforma (Deixe em branco para manter): ");
                        String novaPlat = scanner.nextLine();
                        if (!novaPlat.trim().isEmpty()) jAlterar.setPlataforma(novaPlat);

                        System.out.println("\nEscolha o novo Status:");
                        System.out.println("1 - Não Iniciado | 2 - Em Andamento | 3 - Finalizado | 4 - Dropado");
                        System.out.print("Opção: ");
                        String opStatus = scanner.nextLine();
                        switch(opStatus) {
                            case "1": jAlterar.setStatus(StatusJogo.NAO_INICIADO); break;
                            case "2": jAlterar.setStatus(StatusJogo.EM_ANDAMENTO); break;
                            case "3": jAlterar.setStatus(StatusJogo.FINALIZADO); break;
                            case "4": jAlterar.setStatus(StatusJogo.DROPADO); break;
                        }

                        System.out.print("\nDeseja dar uma nota e comentário agora? (S/N): ");
                        if (scanner.nextLine().equalsIgnoreCase("S")) {
                            System.out.print("Digite a nota de avaliação (0 a 5): ");
                            int novaNota = Integer.parseInt(scanner.nextLine());
                            System.out.print("Escreva seu comentário/review: ");
                            String novoComent = scanner.nextLine();
                            jAlterar.avaliar(novaNota, novoComent);
                        }

                        gerenciador.atualizarArquivo();
                        System.out.println("-> Registro de jogo atualizado com sucesso!");
                    } else {
                        System.out.println("-> entities.Jogo não encontrado no sistema.");
                    }
                    break;

                case 3:
                    System.out.print("\nDigite o título do jogo que deseja deletar: ");
                    String tituloExcluir = scanner.nextLine();
                    boolean removido = gerenciador.excluirJogo(tituloExcluir);
                    if (removido) {
                        System.out.println("-> Registro apagado definitivamente do backlog.");
                    } else {
                        System.out.println("-> entities.Jogo não encontrado.");
                    }
                    break;

                case 4:
                    gerenciador.listarJogosTabular(false);
                    break;

                case 5:
                    gerenciador.listarJogosTabular(true);
                    break;

                case 6:
                    System.out.print("\nDigite o título do jogo para buscar: ");
                    String tituloBusca = scanner.nextLine();
                    gerenciador.buscarEExibirJogo(tituloBusca);
                    break;

                case 7:
                    System.out.println("\nSaindo do sistema... Até mais!");
                    break;

                default:
                    System.out.println("[Erro] Opção inválida. Escolha um número de 1 a 7.");
                    break;
            }
        } while (opcao != 7);

        scanner.close();
    }
}