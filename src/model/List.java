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
        task.setStatus(task.getStatus() == 0 ? 1 : 0);
    }

    public void alterarPrioridade(Task task, int priority){
        task.setPriority(priority);
    }

    public void alterarNome(Task task,String name){
        task.setName(name);
    }

    public void removeAllTasks(){
        tasks.clear();
    }


    // list tasks sorted by priority
    
    public void showTasksByPriority(){
        int id = 1;
        ArrayList<Task> taskP1 = new ArrayList<Task>();
        ArrayList<Task> taskP2 = new ArrayList<Task>();
        ArrayList<Task> taskP3 = new ArrayList<Task>();
        ArrayList<Task> taskPun = new ArrayList<Task>();
        for (Task task : tasks) {
            switch (task.getPriority()) {
                case "High":
                    taskP1.add(task);
                    break;
                case "Medium":
                    taskP2.add(task);
                    break;
                case "Low":
                    taskP3.add(task);
                    break;
                default:
                    taskPun.add(task);
                    break;
            } 
        }

        for (Task task : taskP1) {
            System.out.println(id + " - " + task.getName() + " | " + task.getPriority() + " | " + 
                (task.getStatus() == 0 ? "PENDING ⏳️" : "DONE ✅"));
            id++;
        }
        for (Task task: taskP2){
            System.out.println(id + " - " + task.getName() + " | " + task.getPriority() + " | " + 
                (task.getStatus() == 0 ? "PENDING ⏳️" : "DONE ✅"));
            id++;
        }

        for (Task task: taskP3){
            System.out.println(id + " - " + task.getName() + " | " + task.getPriority() + " | " + 
                (task.getStatus() == 0 ? "PENDING ⏳️" : "DONE ✅"));
            id++;
        }

        for (Task task: taskPun){
            System.out.println(id + " - " + task.getName() + " | " + task.getPriority() + " | " + 
                (task.getStatus() == 0 ? "PENDING ⏳️" : "DONE ✅"));
            id++;
        }

    }

    public void showTasks(){
        int id = 1;
        for (Task task : tasks) {
            System.out.println(id + " - " + task.getName() + " | " + task.getPriority() + " | " + 
                (task.getStatus() == 0 ? "PENDING ⏳️" : "DONE ✅"));
            id++;
        }
        
    }

    
}
