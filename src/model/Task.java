package model;

public class Task {

    private int id;
    private String name;
    private int priority;
    private int status;

    public Task() {
    }

    public Task(String name, int priority, int status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    public Task(int id, String name, int priority, int status) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriorityValue() {
        return priority;
    }

    public String getPriority() {
        return switch (priority) {
            case 1 -> "High";
            case 2 -> "Medium";
            case 3 -> "Low";
            default -> "Undefined";
        };
    }

    public int getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
