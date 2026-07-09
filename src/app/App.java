package app;
import model.Task;
import model.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;

public class App {
    public static void main (String[] args) throws IOException {
        List list = new List();
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader("src/app/task.txt"));
        boolean loop = true;
        String line;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            Task tsk = new Task();
            String[] readLine = line.split(";");
            tsk.setName(readLine[0]);
            tsk.setPriority(readLine[1]);
            tsk.setStatus(Boolean.parseBoolean(readLine[2]));
            list.adicionar(tsk);
        }
        br.close();

        while(loop) {
            System.out.println("1 - View tasks");
            System.out.println("2 - Add task");
            System.out.println("3 - Remove task");
            System.out.println("4 - Update task");
            System.out.println("5 - Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            
            switch (option) {
                case 1: // show tasks
                    list.showTasks();
                    break;
                case 2: // add task
                    sc.nextLine();
                    System.out.print("Enter task name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter task priority: ");
                    String priority = sc.nextLine();
                    System.out.print("Enter task status: ");
                    boolean status = sc.nextBoolean();
                    list.adicionar(new Task(name, priority, status));
                    break;
                case 3: // remove tasks
                    System.out.print("Enter task id to remove: ");
                    int idToRemove = sc.nextInt();
                    list.remover(list.getTask(idToRemove));
                    break;
                case 4: // update tasks
                    System.out.println("What do you want to update?");
                    System.out.println("1 - Name");
                    System.out.println("2 - Priority");
                    System.out.println("3 - Status");
                    System.out.print("Choose an option: ");
                    int optionToUpdate = sc.nextInt();
                    switch (optionToUpdate) {
                        case 1:
                            System.out.print("Enter task id to update: ");
                            int idToUpdate = sc.nextInt();
                            System.out.print("Enter new task name: ");
                            String newName = sc.next();
                            list.alterarNome(list.getTask(idToUpdate), newName);
                            break;
                        case 2:
                            System.out.print("Enter task id to update: ");
                            idToUpdate = sc.nextInt();
                            System.out.print("Enter new task priority: ");
                            String newPriority = sc.nextLine();
                            list.alterarPrioridade(list.getTask(idToUpdate), newPriority);
                            break;
                        case 3:
                            System.out.print("Enter task id to update: ");
                            idToUpdate = sc.nextInt();
                            System.out.print("Enter new task status: ");
                            boolean newStatus = sc.nextBoolean();
                            list.alterarStatus(list.getTask(idToUpdate));
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;
                    }
                    break;
                case 5: // exit
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            System.out.println();
        }
        

        // open writer (false to overwrite / truncate) and write all tasks
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/app/task.txt", false));
        for (Task task : list.tasks) {
            bw.write(task.getName() + ";" + task.getPriority() + ";" + task.getStatus() + "\n");
        }
        bw.close();
        sc.close();

        
        
    }
}
