package model;

public class Task {
    private String name;
    private String priority;
    private boolean status;
    

    public Task(){
        
    }
    public Task(String name, String priority,boolean status){
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    public String getName(){
        return name;
    }

    public String getPriority(){
        return priority;
    }

    public boolean getStatus(){
        return status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }
    public void setPriority(String priority){
        this.priority = priority;
    }
    public void setName(String name){
        this.name = name;
    }

}
