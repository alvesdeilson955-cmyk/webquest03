// Integrantes da equipe:
// Deilson Pereia Alves
// Juciana Maria Diniz
// Mathias Ferreira do Nascimento e Silva
// Rayassa Beatriz Alencar Almeida
import java.util.Scanner;

public class AgendaApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AgendaManager agenda = new AgendaManager();

        int opcao = 0;

        while (opcao != 7) {

            System.out.println("\n===== AGENDA ELETRÔNICA =====");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Buscar contato");
            System.out.println("3 - Remover contato");
            System.out.println("4 - Listar todos os contatos");
            System.out.println("5 - Salvar em CSV");
            System.out.println("6 - Carregar CSV");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                if (opcao == 1) {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    agenda.adicionarContato(new Contato(nome, telefone, email));
                    System.out.println("Contato adicionado!");
                }

                else if (opcao == 2) {
                    System.out.print("Digite o nome: ");
                    System.out.println(agenda.buscarContato(scanner.nextLine()));

                } else if (opcao == 3) {
                    System.out.print("Digite o nome: ");
                    agenda.removerContato(scanner.nextLine());
                    System.out.println("Contato removido!");

                } else if (opcao == 4) {
                    System.out.println("\n--- Lista de Contatos ---");
                    for (Contato c : agenda.listarTodosContatos()) {
                        System.out.println(c);
                    }

                } else if (opcao == 5) {
                    System.out.print("Nome do arquivo: ");
                    agenda.salvarContatosCSV(scanner.nextLine());
                    System.out.println("Arquivo salvo!");

                } else if (opcao == 6) {
                    System.out.print("Nome do arquivo: ");
                    agenda.carregarContatosCSV(scanner.nextLine());
                    System.out.println("Arquivo carregado!");

                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
