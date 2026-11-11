package app;

import database.Database;
import repository.TaskRepository;
import model.Task;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        boolean loop = true;
        Database.createTable();
        Database.connect();
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("=== TODO LIST ===");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Finalizar tarefa");
            System.out.println("4. Excluir tarefa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            // Scanner moved before loop
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (option) {
                case 1 -> {
                    System.out.print("Digite o nome da tarefa: ");
                    String name = scanner.nextLine();

                    System.out.print("Digite a prioridade (1 - Alta, 2 - Média, 3 - Baixa): ");
                    int priority = scanner.nextInt();

                    Task task = new Task(name, priority, 0);
                    TaskRepository taskRepository = new TaskRepository();
                    taskRepository.save(task);

                    System.out.println("Tarefa adicionada com sucesso!");
                }
                case 2 -> {
                    TaskRepository taskRepository = new TaskRepository();
                    var tasks = taskRepository.findAll();

                    if (tasks.isEmpty()) {
                        System.out.println("Nenhuma tarefa encontrada.");
                    } else {
                        System.out.println("=== Lista de Tarefas ===");
                        for (Task task : tasks) {
                            System.out.printf("ID: %d | Nome: %s | Prioridade: %s | Status: %d%n",
                                    task.getId(), task.getName(), task.getPriority(), task.getStatus());
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Digite o ID da tarefa a ser finalizada: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    TaskRepository taskRepository = new TaskRepository();
                    Task task = taskRepository.findById(id);

                    if (task != null) {
                        task.setStatus(1); // Marcar como finalizada
                        taskRepository.update(task);

                        System.out.println("Tarefa finalizada com sucesso!");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                }
                case 4 -> {
                    System.out.print("Digite o ID da tarefa a ser excluída: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    TaskRepository taskRepository = new TaskRepository();
                    Task task = taskRepository.findById(id);

                    if (task != null) {
                        taskRepository.deleteById(id);
                        System.out.println("Tarefa excluída com sucesso!");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                }
                case 5 -> {
                    loop = false;
                    System.out.println("Saindo do aplicativo...");
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println();
        }
        scanner.close();

    }
}
