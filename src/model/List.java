package model;


import java.util.ArrayList;

public class List {
    public ArrayList<Task> tasks;

    public List(){
        this.tasks = new ArrayList<Task>();
    }

    public Task getTask(int index){
        return tasks.get(index);
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
        int id = 0;
        for (Task task : tasks) {
            System.out.println(id + " - " + task.getName() + " - " + task.getPriority() + " - " + task.getStatus());
            id++;
        }
    }

    
}
