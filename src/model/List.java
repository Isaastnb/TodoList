package model;
import java.util.ArrayList;

public class List {
    private ArrayList<Task> tasks;

    public List(){
        this.tasks = new ArrayList<Task>();
    }

    public void adicionar(Task task){
        tasks.add(task);    

    }
    public void remover(Task task){
        tasks.remove(task);
    }

    public void alterarStatus(Task task){
        task.setStatus(!task.getStatus());
    }

    public void alterarPrioridade(Task task, String priority){
        task.setPriority(priority);
    }

    public void alterarNome(Task task,String name){
        task.setName(name);
    }

    public void showTasks(){
        for (Task task : tasks) {
            System.out.println(task.getName() + " - " + task.getPriority() + " - " + task.getStatus());
        }
    }

    
}
