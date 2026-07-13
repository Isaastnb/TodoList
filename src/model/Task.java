package model;

public class Task {
    private String name;
    private int priority;
    private int status;
    

    public Task(){
        
    }
    public Task(String name, int priority,int status){
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    public String getName(){
        return name;
    }

    public int writePriority(){
        return priority;
    }


    public String getPriority(){
        switch (priority) {
            case 1:
                return "High";
            case 2:
                return "Medium";
            
            case 3:
                return "Low";
            default:
                return "Undefined";
        }
    }

    public int getStatus(){
        return status;
    }
    public void setStatus(int status){
        this.status = status;
    }
    public void setPriority(int priority){
        this.priority = priority;
    }
    public void setName(String name){
        this.name = name;
    }

}
