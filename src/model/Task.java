package model;

public class Task {
    private String name;
    private String priority;
    private String status;
    

    public Task(String name, String priority,String status){
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

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public void setPriority(String priority){
        this.priority = priority;
    }
    public void setName(String name){
        this.name = name;
    }

}
