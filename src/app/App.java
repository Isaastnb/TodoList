package app;

import model.Task;
import model.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main (String[] args) throws IOException {
        List list = new List();
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        // Initialize Jackson ObjectMapper configured for field-based serialization/deserialization
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        File jsonFile = new File("src/app/tasks.json");

        if (jsonFile.exists()) {
            Task[] loadedTasks = mapper.readValue(jsonFile, Task[].class);
            for (Task tsk : loadedTasks) {
                list.adicionar(tsk);
            }
        } else {
            System.out.println("No tasks file found, please create a file named tasks.json in the src/app/ folder!");
        }

        // Initial menu
        while(loop) {
            System.out.println("----------------------------");
            System.out.println("1 - View tasks");
            System.out.println("2 - Add task");
            System.out.println("3 - Remove task");
            System.out.println("4 - Update task");
            System.out.println("5 - Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            System.out.println("----------------------------");
            
            switch (option) {
                case 1: // show tasks
                    list.showTasks();
                    break;
                case 2: // add task
                    sc.nextLine();
                    System.out.print("Enter task name: ");
                    String name = sc.nextLine();
                    System.out.println("------------------------");
                    System.out.println("Set 1 for High priority");
                    System.out.println("Set 2 for Medium priority");
                    System.out.println("Set 3 for Low priority");
                    System.out.println("Or set 0 to Undefined priority");
                    System.out.println("------------------------");
                    System.out.print("Enter task priority: ");
                    String priorityInput = sc.nextLine().trim();
                    int priority = priorityInput.isEmpty() ? 0 : Integer.parseInt(priorityInput);
                    int status = 0;
                    list.adicionar(new Task(name, priority, status));
                    break;
                case 3: // remove tasks
                    System.out.print("Enter task number to remove: ");
                    int idToRemove = sc.nextInt();
                    list.remover(list.getTask(idToRemove-1));
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
                            list.alterarNome(list.getTask(idToUpdate - 1), newName);
                            break;
                        case 2:
                            System.out.print("Enter task id to update: ");
                            idToUpdate = sc.nextInt();
                            sc.nextLine(); // Clear scanner buffer
                            System.out.println("-----------------------");
                            System.out.println("Set 1 for High priority");
                            System.out.println("Set 2 for Medium priority");
                            System.out.println("Set 3 for Low priority");
                            System.out.println("Or set nothing to Undefined priority");
                            System.out.println("-----------------------");
                            System.out.print("Enter new task priority: ");
                            String newPriorityInput = sc.nextLine().trim();
                            int newPriority = newPriorityInput.isEmpty() ? 0 : Integer.parseInt(newPriorityInput);
                            list.alterarPrioridade(list.getTask(idToUpdate - 1), newPriority);
                            break;
                        case 3:
                            System.out.print("Enter task id to update: ");
                            idToUpdate = sc.nextInt();
                            list.alterarStatus(list.getTask(idToUpdate - 1));
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

        // Save all tasks in pretty-printed JSON format
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, list.tasks);
            System.out.println("Tasks successfully saved!");
        } catch (Exception e) {
            System.out.println("Error saving tasks to JSON file: " + e.getMessage());
        }
        
        sc.close();
    }
}
