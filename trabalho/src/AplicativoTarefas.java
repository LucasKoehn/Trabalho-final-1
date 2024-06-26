import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AplicativoTarefas {
    private ListaDeTarefas listaDeTarefas;
    private Scanner scanner;

    public AplicativoTarefas() {
        this.listaDeTarefas = new ListaDeTarefas();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int escolha = 0;
        do {
            System.out.println("=== Gerenciador de Tarefas ===");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Marcar Tarefa como Concluída");
            System.out.println("3. Desmarcar Tarefa como Concluída");
            System.out.println("4. Remover Tarefa");
            System.out.println("5. Listar Todas as Tarefas");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após o número

            switch (escolha) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    marcarTarefaComoConcluida();
                    break;
                case 3:
                    marcarTarefaComoNaoConcluida();
                    break;
                case 4:
                    removerTarefa();
                    break;
                case 5:
                    listarTodasTarefas();
                    break;
                case 6:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (escolha != 6);
    }

    private void adicionarTarefa() {
        System.out.print("Digite o título da tarefa: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite a data de vencimento da tarefa (AAAA-MM-DD): ");
        LocalDate dataVencimento = LocalDate.parse(scanner.nextLine());

        int novoIdTarefa = listaDeTarefas.obterTodasTarefas().size() + 1;
        Tarefa novaTarefa = new Tarefa(novoIdTarefa, titulo, descricao, dataVencimento);
        listaDeTarefas.adicionarTarefa(novaTarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private void marcarTarefaComoConcluida() {
        System.out.print("Digite o ID da tarefa que deseja marcar como concluída: ");
        int idTarefa = scanner.nextInt();
        Tarefa tarefa = listaDeTarefas.obterTarefaPorId(idTarefa);
        if (tarefa != null) {
            tarefa.marcarComoConcluida();
            System.out.println("Tarefa marcada como concluída!");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    private void marcarTarefaComoNaoConcluida() {
        System.out.print("Digite o ID da tarefa que deseja desmarcar como concluída: ");
        int idTarefa = scanner.nextInt();
        Tarefa tarefa = listaDeTarefas.obterTarefaPorId(idTarefa);
        if (tarefa != null) {
            tarefa.marcarComoNaoConcluida();
            System.out.println("Tarefa marcada como não concluída!");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    private void removerTarefa() {
        System.out.print("Digite o ID da tarefa que deseja remover: ");
        int idTarefa = scanner.nextInt();
        Tarefa tarefa = listaDeTarefas.obterTarefaPorId(idTarefa);
        if (tarefa != null) {
            listaDeTarefas.removerTarefa(idTarefa);
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    private void listarTodasTarefas() {
        System.out.println("=== Lista de Tarefas ===");
        List<Tarefa> tarefas = listaDeTarefas.obterTodasTarefas();
        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa);
        }
        System.out.println("========================");
    }

    public static void main(String[] args) {
        AplicativoTarefas app = new AplicativoTarefas();
        app.exibirMenu();
    }
}
