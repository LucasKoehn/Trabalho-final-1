import java.util.ArrayList;
import java.util.List;

public class ListaDeTarefas {
    private List<Tarefa> tarefas;

    public ListaDeTarefas() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public void removerTarefa(int idTarefa) {
        Tarefa tarefaRemover = null;
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == idTarefa) {
                tarefaRemover = tarefa;
                break;
            }
        }
        if (tarefaRemover != null) {
            tarefas.remove(tarefaRemover);
        } else {
            System.out.println("Tarefa com ID " + idTarefa + " não encontrada.");
        }
    }

    public Tarefa obterTarefaPorId(int idTarefa) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == idTarefa) {
                return tarefa;
            }
        }
        return null;
    }

    public List<Tarefa> obterTodasTarefas() {
        return tarefas;
    }
}
